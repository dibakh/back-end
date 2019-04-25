package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.communication.BedClient;
import at.nacs.drhousediagnoses.communication.PharmacyClient;
import at.nacs.drhousediagnoses.persistance.Patient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("patient")
public class DoctorHouse {

  @Setter
  private Map<String, String> diagnoses;

  private final PharmacyClient pharmacyClient;
  private final BedClient bedClient;

  public void diagnose(Patient patient) {

    String symptoms = patient.getSymptoms();
    String section = diagnoses.getOrDefault(symptoms, "pharmacy");
    patient.setDiagnosis(section);
    if (section.equals("bed")) {
      bedClient.forward(patient);
    } else {
      pharmacyClient.forward(patient);
    }
  }
}
