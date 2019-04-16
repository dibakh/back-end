package at.nacs.ex06;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IntegerValue {

    @Getter
    @Value("${number.value}")
    private Integer number;
}
