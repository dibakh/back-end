package at.nacs.morse.logic;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties("morse")
public class EncoderClient {

    private Map<String, String> alphabet;

    public String encode(String letter) {
        return alphabet.get(letter);

//        return Stream.of(letter)
//                .map(morseCode::get)
//                .collect(Collectors.joining());
    }
}
