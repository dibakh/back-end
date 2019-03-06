package at.nacs.primenumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrimesTest {

    @Autowired
    Primes primes;

    @ParameterizedTest
    @CsvSource({
            "false , -10",
            "false , 0",
            "false , 1",
            "true , 2",
            "true , 3",
            "true , 179",
            "false , 100",
    })
    void testCounterBorad(boolean expected, int number) {
        boolean actual = primes.isPrime(number);
        Assertions.assertEquals(expected, actual);
    }
}