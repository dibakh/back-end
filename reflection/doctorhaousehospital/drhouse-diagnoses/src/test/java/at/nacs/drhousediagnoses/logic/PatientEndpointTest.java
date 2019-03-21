package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.Communication.BedsClient;
import at.nacs.drhousediagnoses.Communication.PatientEndpoint;
import at.nacs.drhousediagnoses.Communication.PharmacyClient;
import at.nacs.drhousediagnoses.persistance.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

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
        Patient patient = Patient.builder().name("Omar").symptoms("headache").build();

        Patient actual = testRestTemplate.postForObject("/patients", patient, Patient.class);

        Assertions.assertThat(actual.getName()).isEqualTo("Omar");
        Assertions.assertThat(actual.getSymptoms()).isEqualTo("headache");
        Assertions.assertThat(actual.getDiagnosis()).isEqualTo("Punch");
    }
}

//Test the PatientsEndpoint with a TestRestTemplate and WebEnvironment.RANDOM_PORT