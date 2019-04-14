package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.dto.PatientDTO;

public class InvoiceIssuer {
  public Invoice generateInvoice(PatientDTO patientDTO) {
    return null;
  }
}

// private final PatientRepository patientRepository;
//  private final InvoiceRepository invoiceRepository;
//
//  private final PatientDTO patientDTO;
//  private Kind kind;
//
//  public PatientDTO saveOrUpdate(PatientDTO patientDTO) {
//
//    Long patientId = Long.valueOf(patientDTO.getId());
//    Optional<Patient> patient = patientRepository.findByUuid(patientId);
//    if (patient.isPresent()) {
//      generateInvoice(patientDTO, patient.get());
//    }
//    patientRepository.save(patient.get());
//  }
//
//  private void generateInvoice(PatientDTO patientDTO, Patient patient) {
//    Invoice invoice = Invoice.builder()
//                             .patient(patient)
//                             .symptoms(patientDTO.getSymptoms())
//                             .diagnosis(patientDTO.getDiagnosis())
//                             .kind(getKindOfInvoice())
//                             .provided(getProvided())
//                             .cost(calculatesCosts())
//                             .paid(false)
//                             .timestamp(LocalDateTime.now())
//                             .build();
//
//    invoiceRepository.save(invoice);
//  }
//
//  private double calculatesCosts() {
//    // data from yml file
//    return 0;
//  }
//
//  private Kind getKindOfInvoice() {
//    if (patientDTO.getMedicine().isEmpty()) {
//      kind = Kind.TREATMENT;
//    }
//    kind = Kind.MEDICINE;
//
//    return kind;
//  }
//
//  private String getProvided() {
//    return null;
//  }
