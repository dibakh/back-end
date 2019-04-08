package at.nacs.phonebook.communication;

import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.Contact;
import at.nacs.phonebook.persistence.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ContactsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @SpyBean
    ContactManager manager;

    String url = "/contacts";

    @MockBean
    ContactRepository repository;

    @Autowired
    List<Contact> contacts;

    String address;

    @BeforeEach
    void before() {
        repository.deleteAll();
    }

    @Test
    void get() {
        testRestTemplate.getForObject(url, Contact[].class);
        verify(manager).getAll();
    }

    @Test
    void post() {
        Contact contact = contacts.get(0);
        testRestTemplate.postForObject(url, contact, Contact.class);
        verify(manager).save(contact);
    }

    @Test
    void getAddress() {
        address = "new-address";
        String newAddress = url + "/address/" + address;
        testRestTemplate.getForObject(newAddress, Contact[].class);
        verify(manager).findByAddressNameLike(address);
    }
}