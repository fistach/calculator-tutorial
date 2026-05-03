package pl.fist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultControllerTest {

    @Mock
    private CalculatorService service;

    @Test
    void shouldThrowExceptionAtIncorrectInput() {
        //given
        String a = "foo";
        String b = "bar";
        String c = "foobar";
        DefaultController controller = new DefaultController(service);

        //then
        assertThrows(IllegalStateException.class, () -> controller.run(a, b, c));
    }

    @Test
    void shouldPassValidInputToService() {
        //given
        String a = "5";
        String b = "3";
        String c = "+";
        DefaultController controller = new DefaultController(service);

        //when
        controller.run(a, b, c);

        //then
        ArgumentCaptor<Double> aCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<Double> bCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<Operation> opCaptor = ArgumentCaptor.forClass(Operation.class);

        verify(service).calculate(aCaptor.capture(), bCaptor.capture(), opCaptor.capture());
        assertEquals(5.0d, aCaptor.getValue());
        assertEquals(3.0d, bCaptor.getValue());
        assertEquals(Operation.ADD, opCaptor.getValue());
    }

    @Test
    void shouldReturnTheResultOfOperation() {
        //given
        String a = "3.5";
        String b = "4";
        String c = "*";
        DefaultController controller = new DefaultController(service);

        //and
        when(service.calculate(eq(3.5d), eq(4.0d), eq(Operation.MULTIPLY))).thenReturn(14.0d);

        //when
        double result = controller.run(a, b, c);

        //then
        assertEquals(14.0d, result);
    }

}
