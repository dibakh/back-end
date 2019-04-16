package at.nacs.personaltodolist.view.controller;

import at.nacs.personaltodolist.communication.ToDoClient;
import at.nacs.personaltodolist.view.model.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ToDoController {

  private final ToDoClient client;

  @ModelAttribute("todo")
  ToDo toDo() {
    return new ToDo();
  }

  @ModelAttribute("todo")
  List<ToDo> toDos() {
    return client.getAll();
  }

  @GetMapping
  String page() {
    return "todos";
  }

  @PostMapping
  String post(@Valid ToDo toDo, BindingResult result, RedirectAttributesModelMap redirect) {
    if (result.hasErrors()) {
      return page();
    }
    save(toDo);
    redirect.addFlashAttribute("todo", toDo);
    return "redirect:/";
  }

  @PostMapping("/done")
  String markAsDone(@RequestParam String id) {
    client.markAsDone(id);
    return "redirect:/";
  }

  @PostMapping("/delete")
  void delete(@RequestParam String id) {
    client.delete(id);
  }

  private void save(@Valid ToDo toDo) {
    ToDo savedToDo = client.save(toDo);
    toDo.setTitle(savedToDo.getTitle());
    toDo.setId(savedToDo.getId());
    toDo.setDone(savedToDo.isDone());
  }
}
