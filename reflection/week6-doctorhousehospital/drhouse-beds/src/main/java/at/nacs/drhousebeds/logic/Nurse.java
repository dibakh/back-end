package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.communication.AccountancyClient;
import at.nacs.drhousebeds.configuration.PatientRepository;
import at.nacs.drhousebeds.persistence.Patient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("cure")
public class Nurse {

    private final AccountancyClient client;
    private final PatientRepository repository;

    @Setter
    private Map<String, String> cure;

    public Patient provideTreatment(Patient patient) {
        String treatment = getTreatment(patient);
        patient = setTreatment(patient, treatment);

        client.forward(patient);
        return patient;

    }

    private Patient setTreatment(Patient patient, String treatment) {
        patient.setTreatment(treatment);
        String id = patient.getId();
        patient = repository.findById(id).orElse(null);
        patient.setTreatment(treatment);
        repository.save(patient);
        return patient;
    }

    private String getTreatment(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        System.out.println(cure);
        String treatment = cure.getOrDefault(diagnosis, "There is no cure for this diagnosis! ");

        return cure.get(diagnosis);
    }
}
