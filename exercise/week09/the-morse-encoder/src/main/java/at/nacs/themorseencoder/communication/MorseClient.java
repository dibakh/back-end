package at.nacs.themorseencoder.communication;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class MorseClient {

  private final RestTemplate restTemplate;

  @Value("${morse.url}")
  String url;

  public String encode(String text) {
    return restTemplate.postForObject(url, text, String.class);
  }
}
