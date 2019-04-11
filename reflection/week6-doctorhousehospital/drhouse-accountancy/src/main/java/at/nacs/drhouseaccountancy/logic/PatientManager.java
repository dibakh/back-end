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

  private final PatientRepository repository;

  // save patient
  public void save(PatientDTO patientDTO) {

    Long patientId = Long.valueOf(patientDTO.getId());
    Optional<Patient> patient = repository.findById(patientId);
    repository.save(patient.get());
  }
}
