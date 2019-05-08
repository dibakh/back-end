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
public class Section {

  @Setter
  private Map<String, String> treatment;

  private final PharmacyClient pharmacyClient;
  private final BedClient bedClient;

  public Patient refer(Patient patient){
    String diagnosis = patient.getDiagnosis();
    String section = treatment.get(diagnosis);



    return patient;
  }
}
