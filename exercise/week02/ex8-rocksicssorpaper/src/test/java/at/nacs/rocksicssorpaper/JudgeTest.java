package at.nacs.rocksicssorpaper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JudgeTest {

    @Autowired
    Judge judge;

    @Autowired
    Set<Move> moves;

    @ParameterizedTest
    @CsvSource({
            "It's draw!, scissors, scissors",
            "It's draw!, rock, rock",
            "It's draw!, paper, paper",
            "Player 1 wins!, scissors, paper",
            "Player 1 wins!, rock, scissors",
            "Player 2 wins!, rock, paper"
    })
    void decide(String expected, String move1Name, String move2Name) {
        Move move1 = toMove(move1Name);
        Move move2 = toMove(move2Name);

        String actual = judge.decide(move1, move2);

        assertEquals(expected, actual);
    }

    private Move toMove(String move1Name) {
        return moves.stream()
                .filter(e -> e.getName().equalsIgnoreCase(move1Name))
                .findFirst().get();
    }

}