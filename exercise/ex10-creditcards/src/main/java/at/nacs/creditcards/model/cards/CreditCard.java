package at.nacs.creditcards.model.cards;

import at.nacs.creditcards.controller.validators.Validator;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreditCard {

    @Getter
    private final String issuer;
    private final Set<Validator> validators;

    public CreditCard(String issuer, Validator... validators) {
        this.issuer = issuer;
        this.validators = Stream.of(validators)
                .collect(Collectors.toSet());
    }

    public boolean isValid(String cardNumber) {
        return validators.stream()
                .allMatch(e -> e.isValid(cardNumber));
    }

}
