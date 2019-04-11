package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.Domain.Patient;
import at.nacs.drhouseaccountancy.dto.PatientDTO;
import at.nacs.drhouseaccountancy.logic.Accountant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class AccountancyEndpoint {

  private final Accountant accountant;

  @PostMapping
  Patient post(@RequestBody PatientDTO patientDTO) {
    return accountant.register(patientDTO);
  }

  @GetMapping("/invoices")
  List<Invoice> getAll() {
    return accountant.getAll();
  }

  @PutMapping("/invoices/{id}/paid")
  void paidInvoice(@PathVariable Long id) {
    accountant.setPaid(id);
  }

}
