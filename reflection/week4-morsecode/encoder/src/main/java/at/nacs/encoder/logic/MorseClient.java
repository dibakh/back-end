package at.nacs.encoder.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MorseClient {

    private final RestTemplate restTemplate;

    @Value("{morse.server}")
    private String url;

    public String getMorseCode(String message) {
        return Arrays.stream(message.split(""))
                .filter(e -> !e.equalsIgnoreCase(" "))
                .map(String::toUpperCase)
                .map(letter -> restTemplate.postForObject(url, letter, String.class))
                .filter(Objects::nonNull)
                .collect(Collectors.joining());
    }
}
