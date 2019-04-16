package at.nacs.creditcards.controller.operators;

public class MultiplyOperator implements Operator {

    @Override
    public Integer operate(Integer number) {
        number *= 2;
        if (number < 10) {
            return number;
        }
        return number - 9;
    }
}
