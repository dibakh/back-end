package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.logic.DiagnosesClient;
import at.nacs.drhouseadmission.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Admission {

    private final DiagnosesClient client;

    public Patient admit(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        client.forward(patient);
        return patient;
    }
}
