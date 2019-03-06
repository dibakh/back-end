package at.nacs.creditcards.model.cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CardConfigurationTest {

    List<CreditCard> cards;

    @ParameterizedTest
    @CsvSource({
//            "true, 378282246310005, American Express",
//            "true, 371449635398431, American Express",
//            "true, 342291746420795, American Express", //the one from new website
//
//            "true, 6011111111111117, Discover",
//            "true, 6011000990139424, Discover",
//
//            "true, 6386957192835520, InstaPayment",
//            "true, 6386848360912268, InstaPayment",

            "true, 4844672813968011, Visa Electron",
            "true, 4026435033783861, Visa Electron",
            "true, 4508642756633796, Visa Electron",

            "true, 6759388106335812, Maestro",
            "true, 5893323330585485, Maestro",
            "true, 6759031230096112, Maestro",


//            "true, 2223016768739313, Master Card",
//            "true, 5555555555554444, Master Card",
//            "true, 5105105105105100, Master Card",
//
//            "true, 4111111111111111, Visa ",
//            "true, 4012888888881881, Visa ",
//            "true, 4222222222222, Visa ",
    })

    void visaElectron(Boolean expected, String cardNumber, String issuer) {

        boolean actual = cards.stream()
                .anyMatch(e -> e.isValid(cardNumber));

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void maestro() {
    }
}