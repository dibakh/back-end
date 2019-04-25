package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class PharmacyClient {
  private final RestTemplate restTemplate;

  @Value("${pharmacy.url}")
  private String url;

  public void forward(Patient patient) {
    restTemplate.postForObject(url, patient, void.class);
  }
}
