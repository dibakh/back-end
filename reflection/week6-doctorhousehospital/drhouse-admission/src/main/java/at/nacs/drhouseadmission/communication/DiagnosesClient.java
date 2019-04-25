package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DiagnosesClient {

  private final RestTemplate restTemplate;

  @Value("${patients.url}")
  private String url;

  public void forward(Patient patient) {
    restTemplate.postForObject(url, patient, void.class);
  }
}
