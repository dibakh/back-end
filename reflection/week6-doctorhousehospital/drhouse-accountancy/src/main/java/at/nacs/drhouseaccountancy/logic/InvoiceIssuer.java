package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.domain.Invoice;
import at.nacs.drhouseaccountancy.domain.Kind;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InvoiceIssuer {

  private final Map<String, Double> treatmentPrices;
  private final Map<String, Double> medicinePrices;
  private PatientDTO patientDTO; // is that ok?

  public Invoice generateInvoice(PatientDTO patientDTO) {
    return Invoice.builder()
                  .id(getId())
                  .kind(getKind())
                  .cost(getCost())
                  .diagnosis(patientDTO.getDiagnosis())
                  .paid(false)
                  .provided(getProvided())
                  .symptoms(patientDTO.getSymptoms())
                  .timestamp(LocalDateTime.now())
                  .build();
  }

  private Long getId() {
    return Long.valueOf(patientDTO.getId());
  }

  private Kind getKind() {
    if (anyMedicinePrescribed()) {
      return Kind.MEDICINE;
    }
    return Kind.TREATMENT;
  }

  private double getCost() {
    if (anyMedicinePrescribed()) {
      return medicinePrices.get(getMedicine());
    }
    return treatmentPrices.get(getMedicine());
  }

  private String getProvided() {
    if (anyMedicinePrescribed()) {
      return patientDTO.getMedicine();
    }
    return patientDTO.getTreatment();
  }

  private boolean anyMedicinePrescribed() {
    return getMedicine().isBlank();
  }

  private String getMedicine() {
    return patientDTO.getMedicine();
  }
}
