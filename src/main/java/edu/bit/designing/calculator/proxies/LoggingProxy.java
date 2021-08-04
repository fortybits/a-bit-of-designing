package training.patterns.calculator.proxies;

import training.patterns.calculator.Calculator;
import training.patterns.calculator.exceptions.InvalidInputException;

public class LoggingProxy implements Calculator {

    Calculator calculator;

    public LoggingProxy() {
    }

    public LoggingProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    public int add(int a, int b) throws InvalidInputException {
        log(a, b);
        int result = calculator.add(a, b);
        return result;
    }

    void log(int a, int b) {
        System.out.println("a : " + a + " b : " + b);
    }
}