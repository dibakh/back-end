package at.nacs.cashier;

import at.nacs.cashier.logic.CashierManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CashierEndpointTest {

  @Autowired
  TestRestTemplate restTemplate;

  @MockBean
  CashierManager cashierManager;


  String url = "/items";

  List<String> items = List.of("capuccino", "espresso");

  @Test
  void post() {
    restTemplate.postForObject(url, items, Void.class);
    verify(cashierManager).manage(items);
  }
}