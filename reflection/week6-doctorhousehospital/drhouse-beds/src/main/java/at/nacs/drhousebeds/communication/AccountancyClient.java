package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountancyClient {

  private final RestTemplate restTemplate;

  @Value("${patient.url}")
  private String url;

  public void post(Patient patient) {
    restTemplate.postForObject(url + "/patients", patient, void.class);
  }
}
