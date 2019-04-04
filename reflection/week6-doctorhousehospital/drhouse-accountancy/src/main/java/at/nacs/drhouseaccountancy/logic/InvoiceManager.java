package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Configuration.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistance.Invoice;
import at.nacs.drhouseaccountancy.persistance.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceManager {

    private Accountant accountant;
    private InvoiceRepository repository;

    public void post(PatientDTO patientDTO) {
        patientDTO = accountant.generateInvoice(patientDTO);
    }

    public List<Invoice> getAll() {
        return repository.findAllByPatient();
    }

    public void setPaid(Long id) {
        Optional<Invoice> byId = repository.findById(id);
        byId.get().setPaid(true);
//        repository.save();
    }
}
