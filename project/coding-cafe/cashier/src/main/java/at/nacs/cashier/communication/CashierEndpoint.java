package at.nacs.cashier.communication;


import at.nacs.cashier.logic.CashierManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class CashierEndpoint {

  private final CashierManager cashierManager;

  @PostMapping
  void post(@RequestBody List<String> items) {
    cashierManager.manage(items);
  }
}
