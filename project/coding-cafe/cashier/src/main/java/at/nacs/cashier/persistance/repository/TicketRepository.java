package at.nacs.cashier.persistance.repository;

import at.nacs.cashier.persistance.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
