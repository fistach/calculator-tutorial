package pl.fist;

import java.util.Arrays;

public class DefaultController {

    private final CalculatorService service;

    public DefaultController(CalculatorService service) {
        this.service = service;
    }

    public void run(String aString, String bString, String opString) {
        double a = parseNumber(aString);
        double b = parseNumber(bString);

        if (!Arrays.asList("+", "-", "*", "/").contains(opString)) {
            throw new IllegalStateException(opString + " is not a valid operation");
        }

        Operation op = convertOperation(opString);

        service.calculate(a, b, op);
    }

    private Operation convertOperation(String opString) {
        switch (opString) {
            case "+":
                return Operation.ADD;
            case "-":
                return Operation.SUBTRACT;
            case "*":
                return Operation.MULTIPLY;
            default:
                return Operation.DIVIDE;
        }
    }

    private double parseNumber(String stringNumber) {
        try {
            return Double.parseDouble(stringNumber);
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException(stringNumber + " is not a number");
        }
    }
}
