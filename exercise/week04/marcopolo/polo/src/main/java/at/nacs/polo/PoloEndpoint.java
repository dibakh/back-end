package at.nacs.polo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {

    @PostMapping
    String get(@RequestBody String message){
        if ("Marco".equalsIgnoreCase(message)){
            return "Polo";
        }
        return "what?";
    }
}

