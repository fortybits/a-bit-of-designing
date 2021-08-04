package training.patterns.calculator.app;

import training.patterns.calculator.Calculator;
import training.patterns.calculator.factory.CalculatorFactory;

public class CalculatorApp {

    public static void main(String[] args) throws Exception {
        Calculator calculator = CalculatorFactory.get("");
    }
}
