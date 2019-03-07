package at.nacs.secrethandshake.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Secrethandshake {

    private final Seller seller;
    private final HandshakeMovesLoader loader;

    public List<String> perform(Integer originalPrice) {
        List<Integer> price = seller.sayPrice(originalPrice);
        Map<Integer, String> handshakes = loader.getHandshake();

        return price.stream()
                .filter(handshakes::containsKey)
                .map(handshakes::get)
                .collect(Collectors.toList());
    }

}
