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
        System.out.println("1- pharmacy manager: " + patient.toString());
        patient = apothecary.getMedicine(patient);
        System.out.println("2- got medicine: " + patient.toString());
        repository.save(patient);
        client.calculateCosts(patient);
        return patient;
    }
}

