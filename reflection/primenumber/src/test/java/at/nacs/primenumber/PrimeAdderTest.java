package at.nacs.primenumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrimeAdderTest {

    @Autowired
    PrimeAdder primeAdder;

    @Test
    void getNumbers() {
        int actual = primeAdder.getSum(100);
        Assertions.assertEquals(24133, actual);
    }



}