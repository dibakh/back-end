package at.nacs.creditcards.model.cards;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class CreditCards {


    public static String xcv(String cardNumber) {
        Optional<CreditCard> card = creditCards.stream()
                .filter(e -> e.isValid(cardNumber))
                .findFirst();
        return card.map(CreditCard::getName).orElse("invalid");
    }
}
