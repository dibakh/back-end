package at.nacs.codiattis.logic;

import at.nacs.codiattis.persistence.domain.User;
import at.nacs.codiattis.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @RolesAllowed("ROLE_ADMIN")
  public void create(User user) {
    user.setId(null);
    String plainPassword = user.getPassword();
    String encodedPassword = passwordEncoder.encode(plainPassword);
    user.setPassword(encodedPassword);
    user.setAuthorities(Set.of("ROLE_USER"));
    userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }
}
