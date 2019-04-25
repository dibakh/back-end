package at.nacs.drhousepharmacy.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Configuration
@ConfigurationProperties("apothecary")
public class MedicineConfiguration {

  @Getter
  @Setter
  private Map<String, String> medicines;

  @Bean
  Map<String, String> medicines() {
    return medicines;
  }
}
