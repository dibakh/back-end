package at.nacs.rocksicssorpaper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class Human implements Player {
    private final List<Move> moves;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Optional<Move> chooseMove() {
        System.out.println("before recording user input started\n");
        String userInput = scanner.nextLine();
        System.out.println("\nafter recording user input started");
        return moves.stream()
                .filter(e -> e.getName().equalsIgnoreCase(userInput))
                .peek(e -> System.out.println("if there is a matching move here is it's name "
    + e.getName()))
                .findFirst();
    }

    @Override
    public boolean playAgain() {
        return false;
    }
}
