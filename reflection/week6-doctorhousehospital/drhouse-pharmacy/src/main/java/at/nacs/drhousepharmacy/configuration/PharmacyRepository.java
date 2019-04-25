package at.nacs.drhousepharmacy.configuration;

import at.nacs.drhousepharmacy.persistance.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends MongoRepository<Patient, String> {
}
