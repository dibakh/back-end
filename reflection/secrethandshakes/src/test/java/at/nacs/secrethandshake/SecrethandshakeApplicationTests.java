package at.nacs.secrethandshake;

import at.nacs.secrethandshake.logic.Secrethandshake;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SecrethandshakeApplicationTests {

    @Autowired
    Secrethandshake secrethandshake;


    @ParameterizedTest
    @CsvSource({
            "move1, 1",
            "move2, 2",
            "move1 - move2, 12",
            "move2 - move1, 21",
            "move2 - move1, 32313",
    })
    void move(String moves, Integer number) {
        List<String> actual = secrethandshake.perform(number);
        List<String> expected = List.of(moves.split(" - "));

        assertEquals(expected, actual);
    }

    @Test
    void noMove() {
        List<String> perform = secrethandshake.perform(8796587);

        assertTrue(perform.isEmpty());
    }
}
