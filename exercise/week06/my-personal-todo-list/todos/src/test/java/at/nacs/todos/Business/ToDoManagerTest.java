package at.nacs.todos.Business;

import at.nacs.todos.persistence.ToDo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager manager;

    ToDo toDo;

    @BeforeEach
    void beforre() {
        manager.deleteAll();

        toDo = ToDo.builder()
                .title("Do test!")
                .build();
    }

    @Test
    void findAll() {
        List<ToDo> toDos = manager.findAll();
        Assertions.assertThat(toDos).isEmpty();
    }

    @Test
    void find() {
        manager.save(toDo);

        String id = toDo.getId();
        Optional<ToDo> actual = manager.find(id);

        actual.ifPresent(e -> assertThat(e).isEqualTo(toDo));

    }

    @Test
    void save() {
        manager.save(toDo);

        String id = toDo.getId();
        Optional<ToDo> actual = manager.find(id);
        actual.ifPresent(e -> assertThat(e).isEqualTo(toDo));

    }

    @Test
    void markAsDone() {
        manager.save(toDo);
        String id = toDo.getId();
        manager.markAsDone(id);

        Optional<ToDo> toDo = manager.find(id);
        assertThat(toDo.get().isDone()).isTrue();


    }

    @Test
    void delete() {
        manager.save(toDo);
        String id = toDo.getId();
        assertThat(toDo.getId()).isNotBlank();

        manager.delete(id);

        Optional<ToDo> actual = manager.find(id);
        assertThat(actual.isPresent()).isFalse();
    }

    @Test
    void deleteAll() {
        manager.save(toDo);

        manager.deleteAll();

        List<ToDo> actual = manager.findAll();
        assertThat(actual.size()).isZero();
    }
}