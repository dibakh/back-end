package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.Communication.AccountancyClient;
import at.nacs.drhousepharmacy.persistance.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("patient")
public class Apothecary {


    @Setter
    @Getter
    private Map<String, String> medicines;

    public Patient getMedicine(Patient patient) {
        String medicine = recieveMedicine(patient);
        patient = setMedicine(patient, medicine);
        return patient;
    }

    private String recieveMedicine(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        return medicines.getOrDefault(diagnosis, "Cure not found!");
    }

    private Patient setMedicine(Patient patient, String medicine) {
        patient.setMedicine(medicine);
        return patient;
    }
}