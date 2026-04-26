package pl.fist;

public class CalculatorService {
    public double calculate(double a, double b, Operation operation) {
        if (operation == Operation.ADD) {
            return a + b;
        } else {
            return a - b;
        }
    }
}
