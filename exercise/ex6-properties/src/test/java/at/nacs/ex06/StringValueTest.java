package at.nacs.ex06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StringValueTest {

    @Autowired
    StringValue stringValue;

    @Test
    void getWord() {
        String actual = stringValue.getWord();
        String expect = "fantastic";

        assertEquals(expect, actual);
    }
}