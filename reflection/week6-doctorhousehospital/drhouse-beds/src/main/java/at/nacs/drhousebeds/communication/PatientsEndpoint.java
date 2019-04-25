package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.logic.CureManager;
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

    private final CureManager manager;

    @PostMapping
    public void postPatient(@RequestBody Patient patient) {
        manager.register(patient);
    }
}

