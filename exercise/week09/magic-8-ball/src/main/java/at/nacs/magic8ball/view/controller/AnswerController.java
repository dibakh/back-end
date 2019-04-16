package at.nacs.magic8ball.view.controller;

import at.nacs.magic8ball.logic.AnswerRandomizer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AnswerController {

  private final AnswerRandomizer answerRandomizer;

  @ModelAttribute("answer")
  String answers() {
    return answerRandomizer.getAnswer();
  }

  @GetMapping
  String page() {
    return "magic-8-ball-answers";
  }
}
