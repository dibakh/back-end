package at.nacs.drhousepharmacy.Communication;

import at.nacs.drhousepharmacy.logic.PharmacyManager;
import at.nacs.drhousepharmacy.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

  private final PharmacyManager manager;

  @PostMapping
  public void diagnose(@RequestBody Patient patient) {
    manager.register(patient);
  }
}

