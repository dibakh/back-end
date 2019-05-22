package at.nacs.cashier.configuration;


import at.nacs.cashier.persistance.domain.Purchase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CashierConfiguration {

  @Bean
  public Purchase purchase() {
    return Purchase.builder()
                   .uuid("1234")
                   .items(Arrays.asList("capuccino", "espresso"))
                   .build();
  }

}
