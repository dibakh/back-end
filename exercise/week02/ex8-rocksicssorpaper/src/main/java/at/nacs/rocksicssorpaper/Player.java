package at.nacs.rocksicssorpaper;

import java.util.Optional;

public interface Player {
    Optional<Move> chooseMove();
    boolean playAgain();
}
