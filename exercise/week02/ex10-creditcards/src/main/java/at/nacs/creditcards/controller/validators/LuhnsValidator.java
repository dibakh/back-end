package at.nacs.creditcards.controller.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LuhnsValidator {

    private final LuhnsAlgorithm algorithm;

    public boolean isValid(String cardNumber) {
        Integer checkSum = algorithm.calculate(cardNumber);
        int lastDigit = (int) getLast(cardNumber);
        return (checkSum - lastDigit) % 10 == 0;
    }

    private char getLast(String cardNumber) {
        return cardNumber.charAt(cardNumber.length() - 1);
    }
}
