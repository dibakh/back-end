package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistance.domain.Invoice;
import at.nacs.drhouseaccountancy.persistance.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

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
    Invoice invoice = patientInvoice.orElseThrow(displayException(id));
    invoice.setPaid(true);
    repository.save(invoice);
  }

  private Supplier<IllegalArgumentException> displayException(Long id) {
    return () -> new IllegalArgumentException("There is no patient registered with the id :" + id);
  }
}

