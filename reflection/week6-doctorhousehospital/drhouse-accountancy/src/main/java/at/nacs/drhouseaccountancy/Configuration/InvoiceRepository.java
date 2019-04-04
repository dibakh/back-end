package at.nacs.drhouseaccountancy.Configuration;

import at.nacs.drhouseaccountancy.persistance.Invoice;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findAllByPatient();
}
