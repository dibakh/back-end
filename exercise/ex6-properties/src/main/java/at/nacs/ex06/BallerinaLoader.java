package at.nacs.ex06;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@ConfigurationProperties("ballerina")
public class BallerinaLoader {

    private List<Ballerina> person;
}
