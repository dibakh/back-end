package at.nacs.cashier.logic;


import at.nacs.cashier.persistance.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderIssuer {

  public Order issue(String item, String uuid) {
    return Order.builder()
                .uuid(uuid)
                .item(item)
                .build();
  }
}
