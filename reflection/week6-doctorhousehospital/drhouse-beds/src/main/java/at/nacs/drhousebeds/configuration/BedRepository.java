package at.nacs.drhousebeds.configuration;

import at.nacs.drhousebeds.persistence.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BedRepository extends MongoRepository<Patient, String> {

}
