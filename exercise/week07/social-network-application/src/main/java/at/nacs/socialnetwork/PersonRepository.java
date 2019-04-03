package at.nacs.socialnetwork;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

//    List<Person> findAllByFriendsIsNotNull();
    List<Person> findAllByFriends_Empty();
    List<Person> findAllPersonByFriendsNotNull();
}
