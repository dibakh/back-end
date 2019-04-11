package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Invoice;
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
  private  final PatientRepository patientRepository;
  public List<Invoice> findAll() {

    return invoiceRepository.findAll();
  }

  public int calculateCosts(PatientDTO patientDTO) {
    int price = 0;
    return price;
  }

  public Patient save(PatientDTO patientDTO, double price) {
    Long id = Long.valueOf(patientDTO.getId());
    Optional<Invoice> patientInvoice = invoiceRepository.findById(id);
//    Invoice invoice = patientInvoice.orElseThrow(patientInvoice.get().setCost(price));
    Optional<Patient> patient = patientRepository.findById(id);
    return patient.get();
  }

  public void update(Long id) {
    Optional<Invoice> patientInvoice = invoiceRepository.findById(id);
    patientInvoice.get().setPaid(true);
  }
}
