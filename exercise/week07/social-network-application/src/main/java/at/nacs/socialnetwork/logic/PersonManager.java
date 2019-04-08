package at.nacs.socialnetwork;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonManager {

    private final PersonRepository repository;

    public List<Person> findAll() {
        List<Person> allPersons = repository.findAll();
        return allPersons;
    }

    public List<Person> findAllPersonsWithFriend() {
        List<Person> allByFriendsGreaterThan0 = repository.findAllPersonByFriendsNotNull();
        List<Person> peopleWith1Friend = Optional.of(allByFriendsGreaterThan0)
                .orElse(null);
        if (allByFriendsGreaterThan0.size()>0){
//            return peopleWith1Friend;
            return repository.saveAll(peopleWith1Friend);
        }
        return null;
    }

    public List<Person> findAllPersonsWithNoFriend() {
        List<Person> allByFriends_empty = repository.findAllByFriends_Empty();
        List<Person> friendLessPeople = Optional.of(allByFriends_empty)
                .orElse(null);
        return friendLessPeople;
    }

    public void save(String name) {
        Person person = new Person();
        person.setName(name);
        repository.save(person);
    }

    public List<Person> makeFriend(Long id1, Long id2) {
        Person person1 = getPerson(id1);
        Person person2 = getPerson(id2);

        List<Person> person1Friends = getFriends(person1);
        person1Friends.add(person2);
        repository.save(person1);

        List<Person> person2friends = getFriends(person2);
        person2friends.add(person1);
        repository.save(person2);
        List<Person> all = repository.findAll();
        return all;
    }

    private List<Person> getFriends(Person person) {
        return person.getFriends();
    }

    public void makeUnfriend(Long id1, Long id2) {
        Person person1 = getPerson(id1);
        Person person2 = getPerson(id2);

        List<Person> person1friends = getFriends(person1);
        person1friends.remove(person2);
//        person1.setFriends(person1friends);
//        person1.getFriends().remove(id2);

        List<Person> person2friends = getFriends(person2);
        person2friends.remove(person1);
//        person2.setFriends(person2friends);
//        person2.getFriends().remove(id1);

        repository.save(person1);
        repository.save(person2);
    }

    private Person getPerson(Long id) {
        return repository.findById(id).orElse(null);
    }
}
