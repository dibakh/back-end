package at.nacs.ex06;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DaysOfWeek {

    @Getter
    @Value("${daysofweek.names}")
    private String[] days;
}
