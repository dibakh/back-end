package at.nacs.drhousepharmacy.Communication;

import at.nacs.drhousepharmacy.persistance.Patient;
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


    public Patient calculateCosts(Patient patient) {
        restTemplate.postForObject(url, patient, Patient.class);
        return patient;
    }
}
