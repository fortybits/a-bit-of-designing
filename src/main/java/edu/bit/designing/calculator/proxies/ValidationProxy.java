package training.patterns.calculator.proxies;

import training.patterns.calculator.Calculator;
import training.patterns.calculator.exceptions.InvalidInputException;

public class ValidationProxy implements Calculator {

    Calculator calculator;

    public ValidationProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    public int add(int a, int b) throws InvalidInputException {
        validate(a, b);
        int result = calculator.add(a, b);
        return result;
    }

    void validate(int a, int b) throws InvalidInputException {
        if (a < 0 || b < 0) {
            throw new InvalidInputException();
        }
    }
}