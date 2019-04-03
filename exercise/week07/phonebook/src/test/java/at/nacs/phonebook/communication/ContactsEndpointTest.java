package at.nacs.phonebook.communication;

import at.nacs.phonebook.configuration.ContactRepository;
import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

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

    Contact contact;
    String address;

    @BeforeEach
    void before(){
        repository.deleteAll();
    }

    @Test
    void get() {
        testRestTemplate.getForObject(url, Contact[].class);
        Mockito.verify(manager).getAll();
    }

    @Test
    void post() {
        testRestTemplate.postForObject(url, contact, Contact.class);
        Mockito.verify(manager).save(contact);
    }

    @Test
    void getAddress(){
        testRestTemplate.getForObject("/address", Contact.class);
        Mockito.verify(manager).findByAddressNameLike(address);
    }
}