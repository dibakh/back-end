package at.nacs.ex5thecalculator.model;

import at.nacs.ex5thecalculator.controller.Expression;
import org.springframework.stereotype.Component;

@Component
public interface Operation {

    boolean matches(Expression expression);

    double apply(Expression expression);

}
