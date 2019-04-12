package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.Domain.Kind;
import at.nacs.drhouseaccountancy.Domain.Patient;
import at.nacs.drhouseaccountancy.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistance.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistance.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("price")
public class InvoiceManager {

  private final InvoiceRepository invoiceRepository;
  private final PatientRepository patientRepository;

  private final Map<String, Double> treathment;
  private final Map<String, Double> medicine;

  public List<Invoice> findAll() {

    return invoiceRepository.findAll();
  }

  public Double calculateCosts(PatientDTO patientDTO) {

    Double price = 0.0;

    Invoice invoice = getInvoice(patientDTO);
    String providedTreatment = patientDTO.getTreatment();
    Kind kind = invoice.getKind();

    switch (kind) {
      case MEDICINE:
        price = medicine.get(providedTreatment);
        break;
      case TREATMENT:
        price = treathment.get(providedTreatment);
    }
    return price;
  }

  private Invoice getInvoice(PatientDTO patientDTO) {
    Long patientId = Long.valueOf(patientDTO.getId());
    return invoiceRepository.getOne(patientId);
  }

  public Patient save(PatientDTO patientDTO, double price) {
    Long id = Long.valueOf(patientDTO.getId());
    Optional<Invoice> patientInvoice = invoiceRepository.findById(id);
    Invoice invoice = patientInvoice.get();
    invoice.setCost(price);
    invoiceRepository.save(invoice);

    Optional<Patient> patient = patientRepository.findById(id);
    return patient.get();
  }

  public void update(Long id) {
    Invoice invoice = invoiceRepository.findById(id).orElse(null);
    invoice.setPaid(true);
    invoiceRepository.save(invoice);
  }
}
