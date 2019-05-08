package at.nacs.drhousediagnoses.logic;

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

  private final DoctorHouseAssistant assistants;

  @Setter
  private Map<String, String> diagnoses;

  public void diagnose(Patient patient) {
    String symptoms = patient.getSymptoms();
    String diagnosis = diagnoses.getOrDefault(symptoms, "lupus");
    patient.setDiagnosis(diagnosis);
    assistants.refer(patient);
  }
}
