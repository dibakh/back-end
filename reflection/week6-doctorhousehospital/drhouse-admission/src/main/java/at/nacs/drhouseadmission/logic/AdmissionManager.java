package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.communication.DiagnosesClient;
import at.nacs.drhouseadmission.persistance.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdmissionManager {

  private final DiagnosesClient client;
  private final Admission admission;

  public void admit(Patient patient) {
    patient = admission.setId(patient);
    client.forward(patient);
  }
}
