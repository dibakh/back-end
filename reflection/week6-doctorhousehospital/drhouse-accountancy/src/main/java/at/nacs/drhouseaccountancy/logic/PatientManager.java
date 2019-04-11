package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Patient;
import at.nacs.drhouseaccountancy.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistance.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PatientManager {

  private final PatientRepository repository;

  public void save(PatientDTO patientDTO) {
    // save patient
    Long patientId = Long.valueOf(patientDTO.getId());
    Patient patient = repository.findAllById(patientId);
    repository.save(patient);
  }
}
