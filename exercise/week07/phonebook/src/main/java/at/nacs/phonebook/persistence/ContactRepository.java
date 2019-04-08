package at.nacs.phonebook.configuration;

import at.nacs.phonebook.persistence.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByAddressNameLike(String name);

}