package at.nacs.phonebook;

import at.nacs.phonebook.persistence.Contact;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("dataset")
public class ContactConfiguration {

    @Getter
    @Setter
    Contact contact;

    @Bean
    Contact contact() {
        return contact;
    }
}