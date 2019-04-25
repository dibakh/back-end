package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistance.domain.Invoice;
import at.nacs.drhouseaccountancy.persistance.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Accountant {

  private final PatientManager patientManager;
  private final InvoiceManager invoiceManager;
  private final InvoiceIssuer invoiceIssuer;

  public void invoice(PatientDTO patientDTO) {
    Patient patient = patientManager.createOrUpdate(patientDTO);
    Invoice invoice = invoiceIssuer.generateInvoice(patientDTO, patient);
    invoiceManager.save(invoice);
  }
}


