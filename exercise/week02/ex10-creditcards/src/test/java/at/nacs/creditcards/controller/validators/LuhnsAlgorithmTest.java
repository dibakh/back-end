package at.nacs.creditcards.controller.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LuhnsAlgorithmTest {

    @Autowired
    LuhnsAlgorithm algorithm;

    @Test
    void testCalculate() {
        String number = "4556737586899855";

        int checkSum = algorithm.calculate(number);

        Assertions.assertEquals(85, checkSum);
    }

    @Test
    void testCalculateVisaElectron() {
        String number = "4917587081671091";

        int checkSum = algorithm.calculate(number);
        char character = number.charAt(number.length() - 1);
        boolean value = (checkSum - (int) character) % 10 == 0;
        Assertions.assertTrue(value);
//        Assertions.assertEquals(85, checkSum);
    }
}
