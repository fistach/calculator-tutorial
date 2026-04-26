package pl.fist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}
