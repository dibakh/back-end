package at.nacs.ex06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DaysOfWeekTest {

    @Autowired
    DaysOfWeek daysOfWeek;

    @Test
    void getDays() {
        String[] days = daysOfWeek.getDays();

        Assertions.assertEquals(7, days.length);


    }
}