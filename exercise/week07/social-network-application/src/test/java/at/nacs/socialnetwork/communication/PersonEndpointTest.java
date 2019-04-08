package at.nacs.socialnetwork.communication;

import at.nacs.socialnetwork.logic.PersonManager;
import at.nacs.socialnetwork.persiistence.Person;
import at.nacs.socialnetwork.persiistence.PersonRepository;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("dataset")
class PersonEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Getter
    @Setter
    List<Person> persons;

    @SpyBean
    PersonManager manager;

    @MockBean
    PersonRepository repository;

    private String url = "/persons";

    @Test
    void findAll() {
        restTemplate.getForObject(url, Person[].class);

        verify(manager).findAll();
    }

    @Test
    void findPersonsOneFriend() {
        restTemplate.getForObject(url + "/friends/with", Person[].class);

        verify(manager).findAllPersonsWithFriend();
    }

    @Test
    void findPersonsWithNoFriends() {
        restTemplate.getForObject(url + "/friends/without", Person[].class);

        verify(manager).findAllPersonsWithNoFriend();
    }

    @Test
    void save() {
        String person = persons.get(0).getName();
        restTemplate.postForEntity(url, person, Person.class);
        verify(manager).save(person);
    }


    @Test
    void testMakefriends() {
        Long id1 = 1L;
        Long id2 = 2L;

        restTemplate.put(url + "/" + id1 + "/friend/" + id2, void.class);

        verify(manager).makeFriend(id1, id2);
    }

    @Test
    void unfriend() {
        Long id1 = 1L;
        Long id2 = 2L;

        restTemplate.put(url + "/" + id1 + "/unfriend/" + id2, void.class);

        verify(manager).makeUnfriend(id1, id2);
    }
}