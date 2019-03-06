package at.nacs.threepwoodfamilycinema;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CinemaMessageSender {

    private final CustomerLoader customer;
    private final TemplateEngine templateEngine;

    public void start() {
        List<String> customers = customer.getName();
        customers.stream()
                .forEach(templateEngine::provideMessage);
    }
}