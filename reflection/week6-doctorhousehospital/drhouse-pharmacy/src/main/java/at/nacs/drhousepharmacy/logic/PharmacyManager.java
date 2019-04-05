package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.Communication.AccountancyClient;
import at.nacs.drhousepharmacy.configuration.PharmacyRepository;
import at.nacs.drhousepharmacy.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PharmacyManager {

    private final Apothecary apothecary;
    private final PharmacyRepository repository;
    private final AccountancyClient client;

    public Patient register(Patient patient) {
        patient = apothecary.getMedicine(patient);
        repository.save(patient);
        client.calculateCosts(patient);
        return patient;
    }
}

