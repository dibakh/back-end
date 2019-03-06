package at.nacs.rocksicssorpaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovesTest {

    @Autowired
    Set<Move> moves;

    @Test
    void testMoves() {
        assertEquals(3, moves.size());
    }
}