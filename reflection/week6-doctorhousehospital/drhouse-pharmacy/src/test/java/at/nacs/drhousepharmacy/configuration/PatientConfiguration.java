package at.nacs.drhousepharmacy.configuration;

import at.nacs.drhousepharmacy.persistance.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfiguration {

    @Bean
    Patient getPatient() {
        return Patient.builder()
                .name("name")
                .symptoms("symptoms")
                .diagnosis("x")
                .build();
    }


}
