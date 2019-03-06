package at.nacs.rocksicssorpaper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoveConfiguration {

    @Bean
    Move scissors() {
        return new Move("scissors", "paper");
    }

    @Bean
    Move paper() {
        return new Move("paper", "rock ");
    }

    @Bean
    Move rock() {
        return new Move("rock", "scissors ");
    }

}
