package at.nacs.cashier.logic;


import at.nacs.cashier.persistance.domain.Ticket;
import at.nacs.cashier.persistance.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketManager {

  private final TicketRepository ticketRepository;
  private final TicketIssuer ticketIssuer;

  public Ticket save(List<String> items) {
    Ticket ticket = ticketIssuer.createTicket(items);
    return ticketRepository.save(ticket);
  }
}
