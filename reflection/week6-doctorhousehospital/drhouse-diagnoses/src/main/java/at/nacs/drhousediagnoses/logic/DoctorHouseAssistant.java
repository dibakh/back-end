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
public class DoctorHouseAssistant {

  @Setter
  private Map<String, String> treatment;

  private final PharmacyClient pharmacyClient;
  private final BedClient bedClient;

  public void refer(Patient patient){
    String diagnosis = patient.getDiagnosis();
    String section = treatment.get(diagnosis);
    if (section.equals("bed")){
      bedClient.forward(patient);
    }
    pharmacyClient.forward(patient);
  }
}
