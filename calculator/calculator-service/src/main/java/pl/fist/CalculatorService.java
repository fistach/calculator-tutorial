package pl.fist;

public class CalculatorService {
    public double calculate(double a, double b, Operation operation) {
        switch (operation) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case DIVIDE:
                return a / b;
            default:
                return a * b;
        }
    }
}
