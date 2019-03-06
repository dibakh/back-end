package at.nacs.threepwoodfamilycinema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("cinema.customer")
@Setter
@Getter
public class CustomerLoader {

    private List<String> name;
}
