package at.nacs.drhousepharmacy.Communication;

import at.nacs.drhousepharmacy.logic.Apothecary;
import at.nacs.drhousepharmacy.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientEndpoint {

    private final Apothecary apothecary;

    @PostMapping
    public Patient diagnose(@RequestBody Patient patient) {

        return apothecary.getMedicine(patient);
    }
}
