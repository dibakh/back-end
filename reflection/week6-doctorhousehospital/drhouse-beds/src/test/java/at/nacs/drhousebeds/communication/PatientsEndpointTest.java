package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.configuration.RestTemplateConfiguration;
import at.nacs.drhousebeds.logic.Nurse;
import at.nacs.drhousebeds.persistence.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    PatientsEndpoint endpoint;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    Nurse nurse;

    @MockBean
    RestTemplateConfiguration restTemplateConfiguration;

    @MockBean
    AccountancyClient accountancyClient;


    @Test
    void postPatient() {
        Patient patient = Patient.builder()
                .name("Omar")
                .symptoms("fever")
                .diagnosis("lupus")
                .build();
        Patient actual = endpoint.postPatient(patient);

        Assertions.assertThat(actual.getTreatment()).isEqualTo("tablets");
    }
}