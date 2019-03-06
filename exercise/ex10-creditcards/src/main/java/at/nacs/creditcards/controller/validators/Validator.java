package at.nacs.creditcards.controller.validators;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Validator {

    private List<String> possibilities;

    public Validator(Integer... possibilities) {
        this.possibilities = Stream.of(possibilities)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    protected List<String> getPossibilities() {
        return possibilities;
    }

    public abstract boolean isValid(String cardNumber);
}
