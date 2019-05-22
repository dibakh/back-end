package at.nacs.cashier.logic;


import at.nacs.cashier.persistance.domain.Purchase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PurchaseIssuer {

  public Purchase issue(Purchase purchase) {
    purchase.setUuid(UUID.randomUUID().toString());
    return purchase;
  }
}
