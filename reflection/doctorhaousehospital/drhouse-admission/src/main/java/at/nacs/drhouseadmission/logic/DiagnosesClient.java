package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class DiagnosesClient {

    private final RestTemplate restTemplate;

    //    @Value("${patients.server.url}")
    private String url = "http://localhost:9002/patients";

    public void forward(Patient patient) {
        restTemplate.postForObject(url, patient, Patient.class);
    }
}
