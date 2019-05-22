package at.nacs.cashier;

import at.nacs.cashier.persistance.domain.BaristaClient;
import at.nacs.cashier.persistance.domain.Purchase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CashierEndpointTest {

  @Autowired
  TestRestTemplate restTemplate;

  @MockBean
  BaristaClient baristaClient;

  String url = "/barista";


  @Autowired
  Purchase purchase;

  @Test
  void get() {
    restTemplate.postForObject(url, purchase, Void.class);
    //   verify(messagesClient).getMessage();
    Mockito.verify(baristaClient).post();
  }
}