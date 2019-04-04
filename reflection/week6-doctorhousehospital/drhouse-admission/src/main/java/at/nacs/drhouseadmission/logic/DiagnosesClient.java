package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
public class DiagnosesClient {

    private final RestTemplate restTemplate;

    @Value("${patients.server.url}")
    private String url;

    public Patient forward(Patient patient) {
        restTemplate.postForObject(url, patient, Patient.class);
        return patient;
    }
}
