package pl.fist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void shouldAddTwoNumbers() {
        //when
        double result = calculatorService.calculate(2.0d, 3.0d, Operation.ADD);

        //then
        assertEquals(5.0, result);
    }

    @Test
    void shouldSubtractTwoNumbers() {
        //when
        double result = calculatorService.calculate(5, 3, Operation.SUBTRACT);

        //then
        assertEquals(2.0, result);
    }

    @Test
    void shouldMultiplyTwoNumbers() {
        //when
        double result = calculatorService.calculate(4, 3, Operation.MULTIPLY);

        //then
        assertEquals(12.0, result);
    }

    @Test
    void shouldDivideTwoNumbers() {
        //when
        double result = calculatorService.calculate(10, 2, Operation.DIVIDE);

        //then
        assertEquals(5.0, result);
    }
}
