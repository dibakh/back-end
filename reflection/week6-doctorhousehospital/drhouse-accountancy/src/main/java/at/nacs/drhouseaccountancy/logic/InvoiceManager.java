package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.Domain.Kind;
import at.nacs.drhouseaccountancy.Domain.Patient;
import at.nacs.drhouseaccountancy.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistance.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistance.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceManager {

  private final InvoiceRepository invoiceRepository;
  private final PatientRepository patientRepository;

  public List<Invoice> findAll() {

    return invoiceRepository.findAll();
  }

  public int calculateCosts(PatientDTO patientDTO) {
    Long patientId = Long.valueOf(patientDTO.getId());
    Invoice invoice = invoiceRepository.getOne(patientId);
    Kind kind = invoice.getKind();
    int price = 0;
    switch (kind) {
      case MEDICINE:
        price = 200;
        break;
      case TREATMENT:
        price = 400;
    }
    return price;
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
