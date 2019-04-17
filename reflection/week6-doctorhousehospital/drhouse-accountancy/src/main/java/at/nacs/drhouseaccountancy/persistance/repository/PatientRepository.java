package at.nacs.drhouseaccountancy.persistance.repository;

import at.nacs.drhouseaccountancy.persistance.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
  Optional<Patient> findByUuid(String uuid);

}
