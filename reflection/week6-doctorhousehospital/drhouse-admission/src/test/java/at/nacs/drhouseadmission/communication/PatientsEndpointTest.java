package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.logic.AdmissionManager;
import at.nacs.drhouseadmission.persistance.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

  @Autowired
  TestRestTemplate restTemplate;

  @Autowired
  Patient patient;

  @MockBean
  DiagnosesClient client;

  @SpyBean
  AdmissionManager admissionManager;

  String url = "/patients";

  @BeforeEach
  void setId() {
    patient.setId(null);
  }

  @Test
  void postPatient() {

    restTemplate.postForObject(url, patient, Patient.class);

    assertThat(patient.getId().isBlank());

    Mockito.verify(admissionManager).admit(patient);
  }
}