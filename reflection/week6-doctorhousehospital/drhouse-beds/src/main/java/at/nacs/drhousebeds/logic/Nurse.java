package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistence.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("patient")
public class Nurse {

    @Setter
    @Getter
    private Map<String, String> cure;

    public Patient provideTreatment(Patient patient) {
        String treatment = getTreatment(patient);
        patient = setTreatment(patient, treatment);
        return patient;
    }

    private String getTreatment(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        return cure.getOrDefault(diagnosis, "Treatment not found!");
    }

    private Patient setTreatment(Patient patient, String treatment) {
        patient.setTreatment(treatment);
        return patient;
    }
}
