package at.nacs.creditcards.model.cards;

import at.nacs.creditcards.controller.validators.LengthValidator;
import at.nacs.creditcards.controller.validators.StartsWithValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardConfiguration {

// Amex
//    new LengthValidator(Collections.singletonList("15")),
//                new StartsWithValidator(Arrays.asList("34", "37"))));

    @Bean
    CreditCard visaElectron() {
        return new CreditCard("VisaElectron",
                new LengthValidator(16),
                new StartsWithValidator(4026, 417500, 4508, 4844, 4913, 4917));
    }


    @Bean
    CreditCard maestro() {
        return new CreditCard("Maestro",
                new LengthValidator(16, 17, 18, 19),
                new StartsWithValidator(5018, 5020, 5038, 5893, 6304, 6759, 6761, 6762, 6763));
    }


//    Discover
//    new LengthValidator(Arrays.asList("16", "17", "18", "19")),
//            new StartsWithValidator(Arrays.asList("6011", "644", "645", "646", "647", "648", "649", "65")),
//            new RangeValidator(622126, 622925, 5)));

//    instapayment
//    new LengthValidator(Collections.singletonList("16")),
//                new StartsWithValidator(Arrays.asList("637", "638", "639"))));

}
