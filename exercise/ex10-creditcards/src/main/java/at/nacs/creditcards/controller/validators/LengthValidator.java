package at.nacs.creditcards.controller.validators;

public class LengthValidator extends Validator {

    public LengthValidator(Integer... possibilities) {
        super(possibilities);
    }

    @Override
    public boolean isValid(String cardNumber) {
        String length = String.valueOf(cardNumber.length());
        return getPossibilities().contains(length);
    }
}
