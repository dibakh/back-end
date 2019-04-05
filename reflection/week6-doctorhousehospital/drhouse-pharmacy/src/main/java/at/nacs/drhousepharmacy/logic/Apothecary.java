package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class Apothecary {

    private final Map<String, String> medicines;

    public Patient getMedicine(Patient patient) {
        String medicine = matchMedicine(patient);
        return setMedicine(patient, medicine);
    }

    private String matchMedicine(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        return medicines.getOrDefault(diagnosis, "Cure not found!");
    }

    private Patient setMedicine(Patient patient, String medicine) {
        patient.setMedicine(medicine);
        return patient;
    }
}