package at.nacs.ex06;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("books")
public class Book {

    @Getter
    @Setter
    private Map<String, Integer> present;
}
