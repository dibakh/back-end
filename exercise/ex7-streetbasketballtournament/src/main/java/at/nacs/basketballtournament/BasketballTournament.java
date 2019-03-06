package at.nacs.basketballtournament;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Queue;

import static java.lang.System.*;

@Component
@RequiredArgsConstructor
public class BasketballTournament {

    private final TeamLoader loader;
    private final Tournament tournament;

    public void start() {
        out.println("--------------------------------------");
        out.println("Welcome to the street basketball tournament! ");
        out.println("These are the teams who signed up: ");
        Queue<BasketballTeam> teams = loader.getTeams();
        teams.forEach(e ->
                        out.println("TeamLoader: " + e.getName()
                                + " | Players: " + e.getPlayers()));
        out.println("-------------------------------------");
        tournament.play(teams);

        // tournament play
    }

}
