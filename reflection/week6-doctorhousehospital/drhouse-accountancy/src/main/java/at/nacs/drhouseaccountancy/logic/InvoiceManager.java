package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.domain.Invoice;
import at.nacs.drhouseaccountancy.persistance.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceManager {

  private final InvoiceRepository repository;

  public void save(Invoice invoice) {
    repository.save(invoice);
  }

  public List<Invoice> getAll() {
    return repository.findAll();
  }

  public void markAsPaidInvoice(Long id) {
    Optional<Invoice> patientInvoice = repository.findById(id);
    if (!patientInvoice.isPresent()) {
      // how tell user that id is not valid?

    }
    Invoice invoice = patientInvoice.get();
    invoice.setPaid(true);
    repository.save(invoice);
  }
}
