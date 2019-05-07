package at.nacs.codiattis.initialize;


import at.nacs.codiattis.persistence.domain.User;
import at.nacs.codiattis.persistence.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserInitializer {

  @Bean
  ApplicationRunner initializeAdmin(UserRepository repository, PasswordEncoder encoder) {
    return args -> {
      User admin = createAdmin(encoder);
      if(repository.existsByUsername(admin.getUsername())){
        return;
      }
      repository.save(admin);
    };
  }

  private User createAdmin(PasswordEncoder encoder) {
    return User.builder()
               .name("Chief")
               .username("chief")
               .password(encoder.encode("chief"))
               .authorities(Set.of("ROLE_ADMIN"))
               .build();
  }

}
