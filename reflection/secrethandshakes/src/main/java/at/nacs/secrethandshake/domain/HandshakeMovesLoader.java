package at.nacs.secrethandshake.logic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Getter
@Setter
@ConfigurationProperties("secret")
public class HandshakeMovesLoader {
    private Map<Integer, String> handshake;

}
