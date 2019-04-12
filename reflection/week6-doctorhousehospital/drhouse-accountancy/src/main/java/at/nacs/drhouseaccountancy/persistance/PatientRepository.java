package at.nacs.drhouseaccountancy.persistance;

import at.nacs.drhouseaccountancy.Domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
  Optional<Patient> findByUuid(Long patientUuid);

}
