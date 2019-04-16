package at.nacs.ex06;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("sauna")
public class Sauna {

    private int availableSeats;
    private int temperature;

}

