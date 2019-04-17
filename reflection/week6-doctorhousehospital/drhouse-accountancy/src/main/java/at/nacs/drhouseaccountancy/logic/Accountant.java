package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.domain.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Accountant {

  private final PatientManager patientManager;
  private final InvoiceManager invoiceManager;
  private final InvoiceIssuer invoiceIssuer;

  public PatientDTO invoice(PatientDTO patientDTO) {

    patientManager.saveOrUpdate(patientDTO);
    Invoice invoice = invoiceIssuer.generateInvoice(patientDTO);
    invoiceManager.save(invoice);

    return patientDTO;
  }
}


