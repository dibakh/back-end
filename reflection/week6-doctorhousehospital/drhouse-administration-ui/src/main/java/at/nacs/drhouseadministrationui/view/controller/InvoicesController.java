package at.nacs.drhouseadministrationui.view.controller;

import at.nacs.drhouseadministrationui.communication.InvoiceClient;
import at.nacs.drhouseadministrationui.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoicesController {

  private final InvoiceClient client;

  @ModelAttribute("invoices")
  List<Invoice> invoices() {
    return client.getAll();
  }

  @GetMapping
  String page() {
    return "invoices";
  }

  @PostMapping()
  String markAsDone(@RequestParam String id) {
    client.markAsPaid(id);
    return "redirect:/invoices";
  }
}
