package at.nacs.cashier.logic;


import at.nacs.cashier.persistance.domain.Product;
import at.nacs.cashier.persistance.domain.Purchase;
import at.nacs.cashier.persistance.domain.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketIssuer {

  private final Map<String, Double> priceList;
  private final PurchaseIssuer purchaseIssuer;

  public Ticket createTicket(List<String> items) {
    Purchase purchase = purchaseIssuer.issue(items);
    return Ticket.builder()
                 .uuid(purchase.getUuid())
                 .products(products(purchase))
                 .total(getTotal(purchase))
                 .build();
  }

  private Double getTotal(Purchase purchase) {
    long total = purchase.getItems().stream()
                         .map(e -> priceList.get(e))
                         .count();
    return Double.valueOf(total);
  }

  private List<Product> products(Purchase purchase) {
    List<String> products = purchase.getItems();
    return products.stream()
                   .map(e -> getProduct(e))
                   .collect(Collectors.toList());

  }

  private Product getProduct(String e) {
    return Product.builder().name(e).price(priceList.get(e)).build();
  }
}
