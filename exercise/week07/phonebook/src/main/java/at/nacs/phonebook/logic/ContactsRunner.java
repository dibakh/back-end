//package at.nacs.phonebook.logic;
//
//import at.nacs.phonebook.configuration.ContactRepository;
//import at.nacs.phonebook.persistence.Address;
//import at.nacs.phonebook.persistence.Contact;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ContactsRunner {
//
//    @Bean
//    ApplicationRunner runner(ContactRepository repository) {
//        return args -> {
//            repository.deleteAll();
//
//            Contact contact = new Contact();
//            contact.setName("Diba");
//
//            repository.save(contact);
//
//            Address address = new Address();
//            address.setName("NBH");
//            contact.setAddress(address);
//
//            repository.save(contact);
//        };
//    }
//}
