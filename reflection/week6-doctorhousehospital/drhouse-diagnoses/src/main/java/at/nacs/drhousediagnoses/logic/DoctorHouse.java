package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorHouse {

    public Patient getDiagnosis(Patient patient) {
        patient.setDiagnosis("Incurable disease");

        return patient;
    }
}
