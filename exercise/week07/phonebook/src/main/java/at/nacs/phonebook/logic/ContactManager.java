package at.nacs.phonebook.logic;

import at.nacs.phonebook.configuration.ContactRepository;
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

    public void save(Contact contact) {
        repository.save(contact);
    }

    public List<Contact> findByAddressNameLike(String address) {
        address = "%" + address + "%";
        List<Contact> allByAddress = repository.findByAddressNameLike(address);
        return allByAddress;
    }

}