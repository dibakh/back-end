package at.nacs.phonebook.communication;


import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactsEndpoint {

    private final ContactManager manager;

    @GetMapping
    List<Contact> get() {
        return manager.getAll();
    }

    @PostMapping
    void post(@RequestBody Contact contact) {
        manager.save(contact);
    }

    @GetMapping("/address/{address}")
    List<Contact> getAddress(@PathVariable String address){
        return manager.findByAddressNameLike(address);
    }
}
