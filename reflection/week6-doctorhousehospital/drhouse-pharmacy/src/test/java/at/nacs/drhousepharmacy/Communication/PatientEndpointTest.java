package at.nacs.drhousepharmacy.Communication;

import at.nacs.drhousepharmacy.persistance.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @MockBean
    RestTemplate restTemplate;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    PatientEndpoint endpoint;

    @MockBean
    AccountancyClient client;


    @Test
    void diagnose() {
        Patient patient = Patient.builder()
                .name("patientName")
                .diagnosis("1")
                .build();

        assertThat(patient.getMedicine()).isBlank();

        Patient actual = testRestTemplate.postForObject("/patients", patient, Patient.class);
        assertThat(actual.getMedicine()).isEqualTo("medicine1");


    }
}