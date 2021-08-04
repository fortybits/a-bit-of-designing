package training.patterns.calculator;

import training.patterns.calculator.exceptions.InvalidInputException;

public interface Calculator {
    int add(int a, int b) throws InvalidInputException; // fedback: should be general exception like CalculatorException
}
