package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Patient;
import at.nacs.drhouseaccountancy.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistance.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PatientManager {

  private final PatientRepository patientRepository;


  public Patient saveOrUpdate(PatientDTO patientDTO) {

    Long patientId = Long.valueOf(patientDTO.getId());
    Optional<Patient> patient = patientRepository.findByUuid(patientId);  // or finbByUuid
    if (patient.isPresent()) {
      return patient.get();
    }
    Patient newPatient = getPatient(patientDTO);
    patientRepository.save(newPatient);

    return newPatient;
  }

  Patient getPatient(PatientDTO patientDTO) {
    return Patient.builder()
                  .uuid(patientDTO.getId())
                  .name(patientDTO.getName())
                  .build();
  }


}
