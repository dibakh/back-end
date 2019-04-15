package at.nacs.magic8ball.view.controller;

import at.nacs.magic8ball.logic.MessageRandomizer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class Show8BallMessages {

  private final MessageRandomizer randomizer;

  @ModelAttribute("message")
  String message() {
    return randomizer.getMessage();
  }

  @GetMapping
  String page() {
    return "magic-8-ball-message";
  }
}
