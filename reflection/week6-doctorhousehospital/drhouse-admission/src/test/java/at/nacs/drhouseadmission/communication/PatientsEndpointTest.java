package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.logic.Admission;
import at.nacs.drhouseadmission.persistance.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

  @Autowired
  TestRestTemplate restTemplate;

  @MockBean
  DiagnosesClient client;

  @SpyBean
  Admission admission;

  @Autowired
  Patient patient;

  String url = "/patients";

  @Test
  void postPatient() {

        restTemplate.postForObject(url, patient, Patient.class);
  }
}