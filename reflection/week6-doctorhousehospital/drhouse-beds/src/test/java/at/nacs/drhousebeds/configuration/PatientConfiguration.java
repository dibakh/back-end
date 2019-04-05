package at.nacs.drhousebeds.configuration;

import at.nacs.drhousebeds.persistence.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfiguration {

    @Bean
    Patient getPatient(){
        return Patient.builder()
                .name("name")
                .symptoms("symptoms")
                .diagnosis("diagnosis")
                .build();
    }
}
