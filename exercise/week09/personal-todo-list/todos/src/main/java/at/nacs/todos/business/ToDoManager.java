package at.nacs.todos.business;

import at.nacs.todos.persistence.ToDo;
import at.nacs.todos.persistence.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoManager {

    private final ToDoRepository repository;

    public List<ToDo> findAll() {
        return repository.findAll();
    }

    public Optional<ToDo> find(String id) {
        return repository.findById(id);
    }

    public ToDo save(ToDo newToDo) {
        return repository.save(newToDo);
    }

    public Optional<ToDo> markAsDone(String id) {
        Optional<ToDo> toDo = find(id);
        if (!toDo.isPresent()) {
            return Optional.empty();
        }

        ToDo currentToDo = toDo.get();
        currentToDo.setDone(true);
        repository.save(currentToDo);

        return Optional.of(currentToDo);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
