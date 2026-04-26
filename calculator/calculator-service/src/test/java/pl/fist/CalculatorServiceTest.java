package pl.fist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @ParameterizedTest
    @CsvSource({
            "2.0d, 3.0d, ADD, 5.0",
            "5.0d, 3.0d, SUBTRACT, 2.0d",
            "4.0d, 3.0d, MULTIPLY, 12.0d",
            "10.0, 2.0d, DIVIDE, 5.0d"
    })
    void shouldCalculate(double a, double b, Operation op, double expectedResult) {
        //when
        double result = calculatorService.calculate(a, b, op);

        //then
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldHandleDivisionByZero() {
        assertThrows(ArithmeticException.class, () ->
                calculatorService.calculate(10, 0, Operation.DIVIDE)
        );
    }
}
