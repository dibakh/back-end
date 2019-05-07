package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.persistance.Patient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Admission {

  public Patient setId(Patient patient){
    patient.setId(UUID.randomUUID().toString());
    return patient;
  }
}
