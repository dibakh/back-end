package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.Communication.BedsClient;
import at.nacs.drhousediagnoses.Communication.PatientEndpoint;
import at.nacs.drhousediagnoses.Communication.PharmacyClient;
import at.nacs.drhousediagnoses.persistance.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    PatientEndpoint patient;

    @MockBean
    BedsClient bedsClient;

    @MockBean
    PharmacyClient pharmacyClient;

    @Test
    void diagnose() {
        Patient patient = Patient.builder()
                .name("Omar")
                .symptoms("headache")
                .diagnosis("Incurable disease")
                .build();

        String url = "/patients";
        Patient actual = testRestTemplate.postForObject(url, patient, Patient.class);

        assertThat(actual.getName()).isEqualTo("Omar");
        assertThat(actual.getSymptoms()).isEqualTo("headache");
        assertThat(actual.getDiagnosis()).isEqualTo("Incurable disease");
    }
}
