package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.logic.Admission;
import at.nacs.drhouseadmission.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientsEndpoint {

    private final Admission admission;

    @PostMapping
    public Patient postPatient(@RequestBody Patient patient) {
        return admission.admit(patient);
    }
}


