package training.patterns.calculator.proxies;

import training.patterns.calculator.Calculator;

public class SimpleCalculator implements Calculator {

    public int add(int a, int b) {
        return a + b;
    }
}