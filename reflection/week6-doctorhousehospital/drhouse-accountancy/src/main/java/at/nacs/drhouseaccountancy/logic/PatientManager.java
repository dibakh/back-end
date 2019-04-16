package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Patient;
import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistance.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PatientManager {

  private final PatientRepository patientRepository;

  public void saveOrUpdate(PatientDTO patientDTO) {

    Optional<Patient> patient = getPatient(patientDTO);

    if (!patient.isPresent()) {
      saveNotExistedPatient(patientDTO);
    }
  }

  private Optional<Patient> getPatient(PatientDTO patientDTO) {
    // getUuid??? getId?????
    Long patientId = Long.valueOf(patientDTO.getId());
    return patientRepository.findByUuid(patientId);
  }

  private Patient saveNotExistedPatient(PatientDTO patientDTO) {
    Patient newPatient = getNewPatient(patientDTO);
    patientRepository.save(newPatient);
    return newPatient;
  }

  Patient getNewPatient(PatientDTO patientDTO) {
    return Patient.builder()
                  .uuid(patientDTO.getId())
                  .name(patientDTO.getName())
                  .build();
  }
}
