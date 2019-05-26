package at.nacs.cashier.logic;


import at.nacs.cashier.persistance.domain.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PurchaseIssuer {

  public Purchase issue(List<String> items) {
    String uuid = UUID.randomUUID().toString();
    return Purchase.builder()
                   .items(items)
                   .uuid(uuid)
                   .build();
  }
}
