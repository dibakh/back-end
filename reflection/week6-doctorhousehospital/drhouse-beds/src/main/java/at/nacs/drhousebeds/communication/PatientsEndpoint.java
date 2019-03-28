package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.logic.Nurse;
import at.nacs.drhousebeds.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final Nurse nurse;

    @PostMapping
    public Patient postPatient(@RequestBody Patient patient) {
        nurse.provideTreatment(patient);
        return patient;
    }
}
