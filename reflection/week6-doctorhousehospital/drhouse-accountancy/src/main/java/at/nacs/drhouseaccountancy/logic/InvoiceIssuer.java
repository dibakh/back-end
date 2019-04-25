package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistance.domain.Invoice;
import at.nacs.drhouseaccountancy.persistance.domain.Kind;
import at.nacs.drhouseaccountancy.persistance.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InvoiceIssuer {

  private final Map<String, Double> treatmentPrices;
  private final Map<String, Double> medicinePrices;

  public Invoice generateInvoice(PatientDTO patientDTO, Patient patient) {
    return Invoice.builder()
                  .patient(patient)
                  .kind(getKind(patientDTO))
                  .cost(getCost(patientDTO))
                  .diagnosis(patientDTO.getDiagnosis())
                  .paid(false)
                  .provided(getProvided(patientDTO))
                  .symptoms(patientDTO.getSymptoms())
                  .timestamp(LocalDateTime.now())
                  .build();
  }

  private Kind getKind(PatientDTO patientDTO) {
    if (anyMedicinePrescribed(patientDTO)) {
      return Kind.MEDICINE;
    }
    return Kind.TREATMENT;
  }

  private double getCost(PatientDTO patientDTO) {
    if (anyMedicinePrescribed(patientDTO)) {
      return medicinePrices.getOrDefault(patientDTO.getMedicine(), 25.0);
    }
    return treatmentPrices.getOrDefault(patientDTO.getTreatment(), 25.0);
  }

  private String getProvided(PatientDTO patientDTO) {
    if (anyMedicinePrescribed(patientDTO)) {
      return patientDTO.getMedicine();
    }
    return patientDTO.getTreatment();
  }

  private boolean anyMedicinePrescribed(PatientDTO patientDTO) {
    return patientDTO.getMedicine().isBlank();
  }

}
