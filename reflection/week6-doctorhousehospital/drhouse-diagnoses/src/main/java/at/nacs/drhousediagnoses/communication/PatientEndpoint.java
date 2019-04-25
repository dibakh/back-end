package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.logic.DoctorHouse;
import at.nacs.drhousediagnoses.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientEndpoint {

    private final DoctorHouse doctorHouse;

    @PostMapping
    public void diagnose(@RequestBody Patient patient) {
        doctorHouse.diagnose(patient);
    }
}
