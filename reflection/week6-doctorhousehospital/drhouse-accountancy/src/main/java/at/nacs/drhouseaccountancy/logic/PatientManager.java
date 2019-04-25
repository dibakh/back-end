package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistance.domain.Patient;
import at.nacs.drhouseaccountancy.persistance.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientManager {

  private final PatientRepository patientRepository;

  public Patient createOrUpdate(PatientDTO patientDTO) {
    Optional<Patient> patient = getPatient(patientDTO);
    if (patient.isPresent()) {
      return patient.get();
    }
    return createAndSave(patientDTO);
  }

  private Optional<Patient> getPatient(PatientDTO patientDTO) {
    return patientRepository.findByUuid(patientDTO.getId());
  }

  private Patient createAndSave(PatientDTO patientDTO) {
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
