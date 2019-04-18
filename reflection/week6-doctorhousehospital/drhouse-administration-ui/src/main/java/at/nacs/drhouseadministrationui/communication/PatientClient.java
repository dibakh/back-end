package at.nacs.drhouseadministrationui.communication;

import at.nacs.drhouseadministrationui.view.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class PatientClient {

  private final RestTemplate restTemplate;

  @Value("${admission.url}")
  private String url;

  public Patient save(Patient patient) {
    return restTemplate.postForObject(url, patient, Patient.class);
  }
}