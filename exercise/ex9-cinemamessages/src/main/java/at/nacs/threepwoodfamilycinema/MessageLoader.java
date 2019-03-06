package at.nacs.threepwoodfamilycinema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("cinema")
@Setter
@Getter
public class MessageLoader {
    private Map<String,String> template;
}
