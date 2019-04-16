package at.nacs.basketballtournament;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketBallTourApp {

    @Bean
    ApplicationRunner application(BasketballTournament basketballTournament) {
        return args -> basketballTournament.start();
    }
}
