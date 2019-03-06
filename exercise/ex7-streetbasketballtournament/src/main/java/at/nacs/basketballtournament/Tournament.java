package at.nacs.basketballtournament;

import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class Tournament {

    private Random random = new Random();

    public void play(Queue<BasketballTeam> teams) {

        IntStream.generate(()-> 0)
                .takeWhile(n-> teams.size()>1)
                .forEach(n-> playOneRound(teams));

//        while (teams.size() > 1) {
//            playOneRound(teams);
//        }
//        BasketballTeam winner = teams.poll();
//        System.out.println(winner.getName() + " wins this match!");
    }

    private void playOneRound(Queue<BasketballTeam> teams) {
        BasketballTeam winner = getWinner(teams);
        System.out.println(winner.getName() + " wins this match!");
        teams.offer(winner);
    }

    private BasketballTeam getWinner(Queue<BasketballTeam> teams) {
        BasketballTeam team1 = teams.poll();
        BasketballTeam team2 = teams.poll();
        System.out.println(team1.getName() + " plays vs " + team2.getPlayers());
        return winner(team1, team2);
    }

    private BasketballTeam winner(BasketballTeam team1, BasketballTeam team2) {
        boolean winner = random.nextBoolean();
        return winner ? team1 : team2;
    }
}

//BasketballTeam team1 = teams.poll();
//        BasketballTeam team2 = teams.poll();
//        BasketballTeam winner = team1;
//        boolean team2Wins = random.nextBoolean();
//        if (team2Wins) {
//            winner = team2;
//        }
//        teams.offer(winner);