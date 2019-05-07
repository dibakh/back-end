package at.nacs.drhouseadmission.configuration;

import at.nacs.drhouseadmission.persistance.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("dataset")
public class PatientConfiguration {

  @Getter
  @Setter
  Patient patient;

  @Bean
  Patient getPatient() {
    return patient;
  }
}
