package at.nacs.secrethandshake.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SellerTest {

    @Autowired
    Seller seller;

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2 - 0, 20",
            "9 - 0 - 0, 900",
            "2 - 1, 21",
            "3 - 2 - 3 - 1 - 3, 32313",
    })
    void move(String moves, Integer number) {
        List<Integer> actual = seller.sayPrice(number);
        List<String> splitedNumbers = List.of(moves.split(" - "));
        List<Integer> expected = splitedNumbers.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

}