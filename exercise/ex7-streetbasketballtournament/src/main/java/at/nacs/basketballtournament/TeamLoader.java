package at.nacs.basketballtournament;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
@ConfigurationProperties("basketball")
@Setter
@Getter
public class TeamLoader {

    private LinkedList<BasketballTeam> teams;
}