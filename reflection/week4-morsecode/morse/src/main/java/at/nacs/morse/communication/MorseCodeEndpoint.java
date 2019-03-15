package at.nacs.morse.communication;

import at.nacs.morse.logic.EncoderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
@RequiredArgsConstructor
public class MorseCodeEndpoint {

    private final EncoderClient encoderClient;

    @PostMapping
    String postEncodedLetter(@RequestBody String letter) {

        return encoderClient.encode(letter);
    }

}
