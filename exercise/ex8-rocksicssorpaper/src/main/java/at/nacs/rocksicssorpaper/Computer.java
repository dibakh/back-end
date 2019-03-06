package at.nacs.rocksicssorpaper;

import java.util.Optional;
import java.util.Random;

public class Computer implements Player {

    private Random random = new Random();

    @Override
    public Optional<Move> chooseMove() {
        return Optional.empty();
    }

    @Override
    public boolean playAgain() {
        return true;
    }
}
