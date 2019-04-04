package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.persistence.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    PatientsEndpoint endpoint;

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    AccountancyClient client;

    @Test
    void postPatient() {
        Patient patient = Patient.builder()
                .name("Omar")
                .symptoms("fever")
                .diagnosis("lupus")
                .build();

        assertThat(patient.getTreatment()).isNull();

        String url = "/patients";
        Patient actual = restTemplate.postForObject(url, patient, Patient.class);

        assertThat(actual.getTreatment()).isNotNull();
    }
}