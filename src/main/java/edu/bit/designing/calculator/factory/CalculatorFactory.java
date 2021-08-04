package training.patterns.calculator.factory;

import training.patterns.calculator.Calculator;

public class CalculatorFactory {

    public static Calculator get(String name) throws Exception {
        Class<?> claz = Class.forName(name);
        Calculator calculator = (Calculator) claz.newInstance();
        return calculator;
    }

}