package at.nacs.creditcards.controller.validators;

import at.nacs.creditcards.controller.operators.MultiplyOperator;
import at.nacs.creditcards.controller.operators.Operator;
import at.nacs.creditcards.controller.operators.StayOperator;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LuhnsAlgorithm {

    public Integer calculate(String cardNumber) {
        String substring = cardNumber.substring(0, cardNumber.length() - 1);
        List<Integer> digits = getDigits(substring);
        Collections.reverse(digits);
        return accumulate(digits);
    }

    private List<Integer> getDigits(String cardNumber) {
        return Arrays.stream(cardNumber.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private Integer accumulate(List<Integer> digits) {
        List<Operator> operators = Arrays.asList(new StayOperator(), new MultiplyOperator());
        return digits.stream()
                .map(e -> operators.get(1).operate(e))
                .peek(e -> Collections.rotate(operators, -1))
                .reduce(0, (e1, e2) -> e1 + e2);
    }
}
