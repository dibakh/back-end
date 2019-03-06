package at.nacs.rocksicssorpaper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

@SpringBootTest
class HumanTest {

    @Autowired
    Human human;

    @Test
    void chooseMove() {
//        String data = "Rok";
//        InputStream stdin = System.in;
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        Scanner scanner = new Scanner(System.in);
//        System.setIn(stdin);

        Optional<Move> move = human.chooseMove();
        Assertions.assertTrue(move.isPresent());
    }
}