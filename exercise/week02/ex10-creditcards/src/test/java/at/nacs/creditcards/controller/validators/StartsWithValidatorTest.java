package at.nacs.creditcards.controller.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
class StartsWithValidatorTest {

    @Autowired
    StartsWithValidator validator;

    @Test
    void testWithOneNumber() {
        StartsWithValidator validator = new StartsWithValidator(Arrays.asList("4"));

        boolean result = validator.isValid("4321");

        Assertions.assertTrue(result);
    }

    @Test
    void testWithManyNumbers() {
        StartsWithValidator validator = new StartsWithValidator(Arrays.asList("34", "37"));

        boolean result = validator.isValid("374321");

        Assertions.assertTrue(result);
    }

    @Test
    void testWithNoNumbers() {
        StartsWithValidator validator = new StartsWithValidator(new ArrayList<>());

        boolean result = validator.isValid("374321");

        Assertions.assertFalse(result);
    }
}