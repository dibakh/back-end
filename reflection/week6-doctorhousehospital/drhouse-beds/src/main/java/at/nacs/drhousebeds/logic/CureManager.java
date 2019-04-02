package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.communication.AccountancyClient;
import at.nacs.drhousebeds.configuration.BedRepository;
import at.nacs.drhousebeds.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CureManager {
    private final Nurse nurse;
    private final BedRepository repository;
    private final AccountancyClient client;


    public Patient register(Patient patient) {
        patient = nurse.provideTreatment(patient);
        repository.save(patient);
        client.calculateCosts(patient);
        return patient;
    }
}
