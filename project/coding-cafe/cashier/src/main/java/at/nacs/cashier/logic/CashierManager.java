package at.nacs.cashier.logic;


import at.nacs.cashier.persistance.domain.BaristaClient;
import at.nacs.cashier.persistance.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CashierManager {

  private final OrderIssuer orderIssuer;
  private final BaristaClient baristaClient;

  public void sendEachOrder(Purchase purchase) {
    String uuid = purchase.getUuid();
    List<String> items = purchase.getItems();
    items.stream()
         .map(e -> orderIssuer.issue(uuid, e))
         .forEach(e -> baristaClient.post(e));
  }
}
