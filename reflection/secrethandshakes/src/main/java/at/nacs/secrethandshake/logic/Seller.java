package at.nacs.secrethandshake.logic;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Seller {
    public List<Integer> sayPrice(Integer originalPrice) {
        return Stream.of(originalPrice.toString())
                .map(e -> e.split(""))
                .flatMap(Stream::of)
                .map(e -> Integer.valueOf(e))
                .collect(Collectors.toList());
    }
}
