package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.InvoiceManager;
import at.nacs.drhouseaccountancy.persistance.Invoice;
import at.nacs.drhouseaccountancy.persistance.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class AccountancyEndpoint {

    private InvoiceManager manager;

    @PostMapping
    void post(@RequestBody PatientDTO patientDTO){
        manager.post(patientDTO);
    }

    @GetMapping("/invoices")
    List<Invoice> getAll(){
        return manager.getAll();
    }

    @PutMapping("/invoices/{id}/paid")
    void paidInvoice(@PathVariable Long id){
        manager.setPaid(id);
    }

}
