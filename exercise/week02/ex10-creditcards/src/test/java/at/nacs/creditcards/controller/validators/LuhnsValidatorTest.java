package at.nacs.creditcards.controller.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LuhnsValidatorTest {

    @Autowired
    LuhnsValidator validator;

    @Test
    void testIsValid() {
        String number = "378281";

        boolean result = validator.isValid(number);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsInValid(){
        String number = "378282";

        boolean result = validator.isValid(number);

        Assertions.assertFalse(result);
    }
}