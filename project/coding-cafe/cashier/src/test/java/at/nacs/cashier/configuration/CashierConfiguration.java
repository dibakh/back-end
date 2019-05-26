package at.nacs.cashier.configuration;


import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CashierConfiguration {

  //  @Bean
  public List<String> items() {
    return List.of("capuccino", "espresso");
  }

}
