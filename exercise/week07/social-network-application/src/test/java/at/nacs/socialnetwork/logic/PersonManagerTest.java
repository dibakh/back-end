package at.nacs.socialnetwork.logic;

import at.nacs.socialnetwork.logic.PersonManager;
import at.nacs.socialnetwork.persiistence.Person;
import at.nacs.socialnetwork.persiistence.PersonRepository;
import lombok.Setter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("dataset")
class PersonManagerTest {

    @Setter
    Person personwithnofriends;

    @Setter
    Person personwithfriends;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonManager manager;

    @BeforeEach
    void before() {
        repository.save(personwithfriends);
        repository.save(personwithnofriends);

    }

    @AfterEach
    void after() {
        repository.deleteAll();
    }


    @Test
    void findAll() {
        List<Person> allPersons = manager.findAll();
        System.out.println("===========" + allPersons);
        assertThat(allPersons).isNotEmpty();

        assertThat(allPersons.size()).isEqualTo(2);
    }

    @Test
    void findAllPersonsWithFriend() {
        Long id = personwithfriends.getId();
        Long id1 = personwithnofriends.getId();
        manager.makeFriend(id, id1);
        List<Person> allPersonsWithFriend = manager.findAllPersonsWithFriend();
        assertThat(allPersonsWithFriend.size()).isEqualTo(2);
    }

    @Test
    void findAllPersonsWithNoFriend() {
        List<Person> allPersonsWithNoFriend = manager.findAllPersonsWithNoFriend();

        assertThat(allPersonsWithNoFriend.size()).isEqualTo(2);
    }

    @Test
    void save() {
        manager.save(personwithfriends.getName());
        List<Person> all = manager.findAll();
        assertThat(all).contains(personwithfriends);
    }

    @Test
    void makeFriend() {
        Long id1 = personwithfriends.getId();
        Long id2 = personwithnofriends.getId();
        List<Person> asFriends = manager.makeFriend(id1, id2);
        System.out.println("=======1111111111" + asFriends);

        List<Person> friends1 = personwithnofriends.getFriends();
        List<Person> friends2 = personwithfriends.getFriends();
        System.out.println("=====111" + friends1);
        System.out.println("=====222" + friends2);

        assertThat(asFriends.size()).isEqualTo(2);


//        assertThat(friends1).contains(friends2.get(1));

        System.out.println("id1: " + id1 + "|   id2: " + id2);
//        List<Person> friends = personwithfriends.getFriends();
//        System.out.println("friends " + friends);
//        boolean id1IsFriendWithId2 = friends.contains(id2);
//        assertThat(id1IsFriendWithId2).isTrue();
//
//        boolean id2IsFriendWithId1 = personwithnofriends.getFriends().contains(id1);
//        assertThat(id2IsFriendWithId1).isTrue();
//        repository.save(personwithnofriends);
//        repository.save(personwithfriends);
    }

    @Test
    void makeUnfriend() {
        Long person1 = personwithfriends.getId();
        Long person2 = personwithnofriends.getId();
        List<Person> newFriends = manager.makeFriend(person1, person2);

        assertThat(newFriends).isNotEmpty();

        manager.makeUnfriend(person1, person2);

        List<Person> allPersonsWithFriend = manager.findAllPersonsWithFriend();

        assertThat(allPersonsWithFriend).isNull();
    }
}