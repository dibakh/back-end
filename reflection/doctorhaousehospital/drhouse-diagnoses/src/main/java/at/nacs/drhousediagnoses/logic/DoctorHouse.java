package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.Communication.BedsClient;
import at.nacs.drhousediagnoses.Communication.PharmacyClient;
import at.nacs.drhousediagnoses.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorHouse {

    private final BedsClient bed;
    private final PharmacyClient pharmacy;

    public Patient getDiagnosis(Patient patient) {
        patient.setDiagnosis("Incurable disease");

        return patient;
    }
}
