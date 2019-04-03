package at.nacs.phonebook;

import at.nacs.phonebook.persistence.Contact;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("dataset")
public class ContactConfiguration {

//    @Setter
//    List<Contact> contacts;

    @Getter
    @Setter
    Contact contact;

//    @Bean
//    List<Contact> contacts() {
//        return contacts;
//    }

    @Bean
    Contact contact() {
        return contact;
    }
}