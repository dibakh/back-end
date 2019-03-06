package at.nacs.creditcards.controller.validators;

import java.util.ArrayList;

public class RangeValidator extends Validator{

    private int min;
    private int max;
    private int length;

    public RangeValidator(int min, int max, int size) {
        super( new ArrayList<>());
        this.min = min;
        this.max = max;
        this.length = length;
    }

    @Override
    public boolean isValid(String cardNumber){
        String substring = cardNumber.substring(0, length);
        return min < Integer.valueOf(substring) && Integer.valueOf(substring) < max;
    }
}