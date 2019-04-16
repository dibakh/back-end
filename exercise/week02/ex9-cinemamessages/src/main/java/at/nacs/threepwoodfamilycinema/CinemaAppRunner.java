package at.nacs.threepwoodfamilycinema;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CinemaAppRunner {
    @Bean
    ApplicationRunner application(CinemaMessageSender cinemaMessageSender) {

        return args -> cinemaMessageSender.start();
    }
}
