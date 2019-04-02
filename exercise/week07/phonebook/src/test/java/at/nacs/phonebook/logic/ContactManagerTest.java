package at.nacs.phonebook.logic;

import at.nacs.phonebook.persistence.Address;
import at.nacs.phonebook.persistence.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ContactManagerTest {

    Contact client;
    Contact addresse;
    @Autowired
    private ContactManager manager;

    @BeforeEach


    @Test
    void getAll() {
        List<Contact> all = manager.getAll();
        assertThat(all).isNotEmpty();
        assertThat(all).size().isEqualTo(1);
    }

    @Test
    void find() {
        manager.post(client);
        Long clientId = client.getId();
        Address address = addresse.getAddress();
        Long addressId = address.getId();

        assertThat(clientId).isEqualTo(addressId);


    }
}