package pl.fist;

public class CalculatorService {
    public double calculate(double a, double b, Operation operation) {
        switch (operation) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case DIVIDE:
                if (b == 0.0d) {
                    throw new ArithmeticException("Division by 0!");
                }
                return a / b;
            case MULTIPLY:
                return a * b;
            default:
                throw new IllegalStateException("unknown operation");
        }
    }
}
