package pl.fist;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultControllerTest {

    @Test
    void shouldThrowExceptionAtIncorrectInput() {
        //given
        String a = "foo";
        String b = "bar";
        String c = "foobar";
        DefaultController controller = new DefaultController();

        //then
        assertThrows(IllegalStateException.class, () -> controller.run(a, b, c));
    }
}
