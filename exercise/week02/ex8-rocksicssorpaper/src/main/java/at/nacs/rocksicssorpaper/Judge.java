package at.nacs.rocksicssorpaper;

import org.springframework.stereotype.Component;

@Component
public class Judge {

    public String decide(Move move1, Move move2) {
        if (isDraw(move1, move2)) {
            return "It's draw!";
        }
        return (defeats(move1, move2)) ? "Player 1 wins!" : "Player 2 wins!";
    }

    private boolean isDraw(Move move1, Move move2) {
        return move1.getName().equals(move2.getName());
    }


    private boolean defeats(Move move1, Move move2) {
        return move1.getDefeat().contains(move2.getName());
    }
}
