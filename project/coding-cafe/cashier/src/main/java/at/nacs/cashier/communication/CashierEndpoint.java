package at.nacs.cashier.communication;


import at.nacs.cashier.logic.CashierManager;
import at.nacs.cashier.persistance.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashier")
@RequiredArgsConstructor
public class CashierEndpoint {

  private final CashierManager cashierManager;

  @PostMapping
  void post(Purchase purchase) {
    cashierManager.sendEachOrder(purchase);
  }
}
