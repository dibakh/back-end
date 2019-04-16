package at.nacs.ex06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IntegerValueTest {

    @Autowired
    IntegerValue integerValue;

    @Test
    void getNumber() {
        Integer actual = integerValue.getNumber();
        Integer expected = 365;
        Assertions.assertEquals(expected, actual);
    }
}