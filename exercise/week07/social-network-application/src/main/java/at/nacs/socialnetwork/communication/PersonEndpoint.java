package at.nacs.socialnetwork;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonEndpoint {

    private final PersonManager manager;

    @GetMapping
    List<Person> findAll() {
        List<Person> all = manager.findAll();
        return all;
    }

    @GetMapping("/friends/with")
    List<Person> findPersonsOneFriend() {
        return manager.findAllPersonsWithFriend();
    }

    @GetMapping("/friends/without")
    List<Person> findPersonsWithNoFriends() {
        return manager.findAllPersonsWithNoFriend();
    }

    @PostMapping
    void save(@RequestBody String name) {
        manager.save(name);
    }

    @PutMapping("/{id1}/friend/{id2}")
    void makeFriends(@PathVariable Long id1, @PathVariable Long id2){
        manager.makeFriend(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void unfriend(@PathVariable Long id1, @PathVariable Long id2){
        manager.makeUnfriend(id1, id2);
    }

}
