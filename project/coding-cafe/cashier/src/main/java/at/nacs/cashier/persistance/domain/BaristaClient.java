package at.nacs.cashier.persistance.domain;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("barista")
public interface BaristaClient {

  @PostMapping("/orders")
  void post(Order order);
}
