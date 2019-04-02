package at.nacs.phonebook.logic;

import at.nacs.phonebook.configuration.ContactRepository;
import at.nacs.phonebook.persistence.Address;
import at.nacs.phonebook.persistence.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactManager {

    private final ContactRepository repository;

    public List<Contact> getAll() {
        return repository.findAll();
    }

    public void post(Contact contact) {
        repository.save(contact);
    }

//    public List<Contact> getAddress(Address address) {
//    List<Contact> allByAddress = repository.findAllByAddress();
//        return allByAddress;
//    }
}