package at.nacs.encoder.communication;

import at.nacs.encoder.logic.MorseClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encode")
@RequiredArgsConstructor
public class EncodeEndpoint {

    private final MorseClient morseClient;

    @GetMapping("/{letter}")
    String getMorseCode(@PathVariable String letter){
        return morseClient.getMorseCode(letter);
    }

    @PostMapping
    String askMorseCode(@RequestBody String message){
        return morseClient.getMorseCode(message);

    }

}
