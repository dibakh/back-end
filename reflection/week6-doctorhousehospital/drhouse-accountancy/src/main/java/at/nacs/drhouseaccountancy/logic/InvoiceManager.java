package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.persistance.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    Invoice invoice = repository.findById(id).orElse(null);
    invoice.setPaid(true);
    repository.save(invoice);
  }
}
