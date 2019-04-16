package at.nacs.ex06;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


@Configuration
public class PresentBooksConfiguration {

    @Bean
    ApplicationRunner presentBooks(Book book) {
        return args -> {
            Map<String, Integer> presentBooks = book.getPresent();
            System.out.println(presentBooks);
        };
    }

}
