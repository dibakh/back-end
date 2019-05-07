package at.nacs.codiattis.security;

import at.nacs.codiattis.persistence.domain.User;
import at.nacs.codiattis.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> oUser = userRepository.findOneByUsername(username);
    if (oUser.isEmpty()) {
      throw new UsernameNotFoundException("Could not find username: " + username);
    }
    User user = oUser.get();
    return new UserPrincipal(user);
  }
}
