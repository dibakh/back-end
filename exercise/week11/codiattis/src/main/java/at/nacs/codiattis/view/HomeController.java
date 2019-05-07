package at.nacs.codiattis.view;

import at.nacs.codiattis.logic.UserService;
import at.nacs.codiattis.persistence.domain.User;
import at.nacs.codiattis.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

  private final UserService userService;


  @ModelAttribute("loggedUserName")
  String loggedUserName(@AuthenticationPrincipal UserPrincipal principal) {
    return principal.getUser().getName();
  }

  @ModelAttribute("isAdmin")
  boolean isLoggedUserAnAdmin(@AuthenticationPrincipal UserPrincipal principal) {
    return principal.getUser().getAuthorities().contains("ROLE_ADMIN");
  }

  @ModelAttribute("users")
  List<User> users() {
    return userService.findAll();
  }

  @ModelAttribute("user")
  User user() {
    return new User();
  }

  @GetMapping
  String page() {
    return "home";
  }


  @PostMapping
  @RolesAllowed("ROLE_ADMIN")
  String post(@Valid User user, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    userService.create(user);
    return "redirect:/";
  }

}
