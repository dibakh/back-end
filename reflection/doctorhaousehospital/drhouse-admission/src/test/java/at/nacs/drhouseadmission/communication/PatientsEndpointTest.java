package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.persistance.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;
//    @MockBean
//    DiagnosesClient diagnosesClient;

    @Test
    void postPatient() {
        Patient patient = Patient.builder().name("Omar").symptoms("headache").build();

        Patient actual = testRestTemplate.postForObject("/patients", patient, Patient.class);
        Assertions.assertThat(actual.getName()).isEqualTo("Omar");

        Assertions.assertThat(actual.getSymptoms()).isEqualTo("headache");
        Assertions.assertThat(actual.getId()).isNotEmpty();
    }
}