package at.nacs.drhouseaccountancy.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("price")
public class PriceConfiguration {

  @Getter
  @Setter
  Map<String,Double> treatment;

  @Bean
  Map<String,Double> getPrices(){
    return treatment;
  }


}
