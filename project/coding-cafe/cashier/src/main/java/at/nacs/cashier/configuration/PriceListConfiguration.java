package at.nacs.cashier.configuration;


import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ConfigurationProperties("info")
@Configuration
public class PriceListConfiguration {

  @Setter
  private Map<String, Double> priceList;

  @Bean
  public Map<String, Double> priceList() {
    return priceList;
  }
}
