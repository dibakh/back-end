package at.nacs.phonebook.logic;

import at.nacs.phonebook.configuration.ContactRepository;
import at.nacs.phonebook.persistence.Address;
import at.nacs.phonebook.persistence.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ContactManagerTest {

    @Autowired
    Contact contact;

    @Autowired
    ContactRepository repository;

    @Autowired
    private ContactManager manager;

    @BeforeEach
    void before() {
        repository.save(contact);
    }

    @AfterEach
    void after() {
        repository.deleteById(contact.getId());
        contact.setId(null);
        contact.getAddress().setId(null);
    }

    @Test
    void getAll() {
        List<Contact> all = manager.getAll();

        assertThat(all).isNotEmpty();
        assertThat(all).size().isEqualTo(1);
    }

    @Test
    void find() {
        List<Contact> actual = manager.findByAddressNameLike("nbh");
        List<Contact> expected = List.of(contact);
        assertThat(actual).isEqualTo(expected);
    }
}