package at.nacs.todos.Business;

import at.nacs.todos.persistence.ToDo;
import at.nacs.todos.persistence.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ToDoEndpoint {

        private final ToDoRepository repository;

        @GetMapping("/todos")
        List<ToDo> allToDos(){
             return repository.findAll();
        }

        @GetMapping("/todos/{id}")
        ToDo ToDoWithId(@PathVariable String id){
             return repository.findById(id).orElse(null);
        }

        @PostMapping("/todos")
        ToDo insertNewToDo(@RequestBody ToDo newToDo){
            return repository.save(newToDo);
        }

        @PutMapping("/todos/{id}/done")
        ToDo putToDo(@PathVariable String id){
            Optional<ToDo> byId = repository.findById(id);
            if (byId.isPresent()){
                repository.save(byId.get()).setDone(true);
            }
            return byId.orElse(null);
        }

        @DeleteMapping("/todos/{id}")
        void deleteId(@PathVariable String id){
            repository.deleteById(id);
        }
}
