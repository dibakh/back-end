package at.nacs.magic8ball.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("dataset")
public class AnswerConfiguration {

  @Getter
  @Setter
  List<String> answers;

  @Bean
  public List<String> answers() {
    return answers;
  }
}

