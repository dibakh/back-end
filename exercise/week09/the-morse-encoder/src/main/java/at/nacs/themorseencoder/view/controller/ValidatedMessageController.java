package at.nacs.themorseencoder.view.controller;

import at.nacs.themorseencoder.view.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/message/validated")
public class ValidatedMessageController {

  private Message message = new Message();

  @ModelAttribute("validatedMessage")
  Message validatedMessage() {
    return message;
  }

  @GetMapping
  String page() {
    return "messages/validated-message";
  }

  @PostMapping
  String post(@Valid Message message, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    this.message = message;
    return "redirect:/message/validated";
  }

}
