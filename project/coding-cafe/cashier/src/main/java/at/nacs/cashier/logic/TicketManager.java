package at.nacs.cashier.logic;


import at.nacs.cashier.persistance.domain.Purchase;
import at.nacs.cashier.persistance.domain.Ticket;
import at.nacs.cashier.persistance.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketManager {

  private final TicketRepository ticketRepository;
  private final TicketIssuer ticketIssuer;

  public Ticket save(Purchase purchase) {
    Ticket ticket = ticketIssuer.createTicket(purchase);
    return ticketRepository.save(ticket);
  }
}
