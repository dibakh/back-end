package at.nacs.drhousediagnoses.Communication;

import at.nacs.drhousediagnoses.logic.DoctorHouse;
import at.nacs.drhousediagnoses.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientEndpoint {

    private final DoctorHouse doctorHouse;

    @PostMapping
    public Patient diagnose(@RequestBody Patient patient) {
         doctorHouse.recognize(patient);
        return patient;
    }
}

//Later on, after all parts of the Doctor House Hospital series are concluded,
// the Dr House will forward the Patient with his right diagnosis to the Beds or the Pharmacy apps.