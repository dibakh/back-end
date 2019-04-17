package at.nacs.drhouseaccountancy.persistance.repository;

import at.nacs.drhouseaccountancy.persistance.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
