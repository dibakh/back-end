package at.nacs.todos.communication;

import at.nacs.todos.Business.ToDoManager;
import at.nacs.todos.persistence.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDoEndpointTest {

    @Autowired
    ToDoEndpoint endpoint;

    @Autowired
    TestRestTemplate restTemplate;

    String url = "/todos";

    @SpyBean
    ToDoManager manager;

    ToDo toDo;

    @BeforeEach
    void before() {
        manager.deleteAll();

        toDo = ToDo.builder()
                .title("do the test!")
                .build();
    }

    @Test
    void getAll() {
        ToDo[] actual = restTemplate.getForObject(url, ToDo[].class);

        assertThat(actual).isEmpty();
    }

    @Test
    void toDoWithId() {
        manager.save(toDo);

        String id = toDo.getId();
        String url = this.url + "/" + id;

        ToDo actual = restTemplate.getForObject(url, ToDo.class);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotBlank();
        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(actual.getTitle());
        assertThat(actual.isDone()).isFalse();
    }

    @Test
    void addToDo() {
        ToDo postedToDo = restTemplate.postForObject(url, this.toDo, ToDo.class);
        String id = postedToDo.getId();

        Optional<ToDo> toDo = manager.find(id);
        assertThat(toDo.isPresent()).isTrue();

        ToDo actual = toDo.get();

        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(postedToDo.getTitle());

    }

    @Test
    void putToDo() {
        manager.save(toDo);
        String id = toDo.getId();
        url = url + "/" + id + "/done";

        assertThat(toDo.isDone()).isFalse();

        restTemplate.put(url, null);

        Optional<ToDo> toDo = manager.find(id);
        assertThat(toDo.isPresent()).isTrue();

        ToDo actual = toDo.get();
        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(toDo.get().getTitle());
        assertThat(actual.isDone()).isTrue();

    }

    @Test
    void deleteId() {
        manager.save(toDo);

        String id = toDo.getId();
        String toDoUrl = url + "/" + id;
        restTemplate.delete(toDoUrl, ToDo.class);

        Optional<ToDo> actual = manager.find(id);
        assertThat(actual.isPresent()).isFalse();

    }
}