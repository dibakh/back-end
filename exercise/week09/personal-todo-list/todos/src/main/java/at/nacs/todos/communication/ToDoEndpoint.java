package at.nacs.todos.communication;

import at.nacs.todos.business.ToDoManager;
import at.nacs.todos.persistence.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoEndpoint {

    private final ToDoManager manager;

    @GetMapping
    List<ToDo> getAll() {
        return manager.findAll();
    }

    @GetMapping("/{id}")
    ToDo ToDoWithId(@PathVariable String id) {
        return manager.find(id).orElse(null);
    }

    @PostMapping
    ToDo addToDo(@RequestBody ToDo newToDo) {
        return manager.save(newToDo);
    }

    @PutMapping("/{id}/done")
    ToDo putToDo(@PathVariable String id) {
        return manager.markAsDone(id).orElse(null);
    }

    @DeleteMapping("/todos/{id}")
    void deleteId(@PathVariable String id) {
        manager.delete(id);
    }
}
