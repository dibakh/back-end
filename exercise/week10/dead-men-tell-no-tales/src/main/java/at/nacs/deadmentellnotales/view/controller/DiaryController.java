package at.nacs.deadmentellnotales.view.controller;

import at.nacs.deadmentellnotales.logic.Trident;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

  private final Trident trident;

  @ModelAttribute("trident")
  Trident trident() {
    return trident;
  }

  @GetMapping
  String get() {
    return "diary";
  }

  @PostMapping
  String post() {
    trident.setStatus(true);
    return "redirect:/";
  }
}
