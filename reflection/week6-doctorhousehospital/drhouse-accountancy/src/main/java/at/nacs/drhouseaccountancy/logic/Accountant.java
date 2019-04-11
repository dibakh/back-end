package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.Domain.Patient;
import at.nacs.drhouseaccountancy.dto.PatientDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Accountant {

  private final PatientManager patientManager;
  private final InvoiceManager invoiceManager;

  public Patient register(PatientDTO patientDTO) {
    patientManager.save(patientDTO);

    Integer price = invoiceManager.calculateCosts(patientDTO);

    Patient patient = invoiceManager.save(patientDTO, price);
    return patient;
  }

  public List<Invoice> getAll() {
    return invoiceManager.findAll();
  }

  public void setPaid(Long id) {
    invoiceManager.update(id);
  }
}
