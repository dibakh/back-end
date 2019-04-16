package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.domain.Invoice;
import at.nacs.drhouseaccountancy.logic.InvoiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoiceEndpoint {

  private final InvoiceManager manager;

  @GetMapping
  List<Invoice> getAll() {
    return manager.getAll();
  }

  @PutMapping("/{id}/paid")
  void paidInvoice(@PathVariable Long id) {
    manager.markAsPaidInvoice(id);
  }
}

