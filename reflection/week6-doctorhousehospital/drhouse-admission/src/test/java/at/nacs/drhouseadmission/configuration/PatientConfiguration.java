package at.nacs.drhouseadmission.configuration;

import at.nacs.drhouseadmission.persistance.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfiguration {

    @Bean
    Patient getPatient() {
        return Patient.builder()
                .name("name")
                .symptoms("symptoms")
                .build();
    }

    ;


}
