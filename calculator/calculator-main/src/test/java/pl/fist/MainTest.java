package pl.fist;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

class MainTest {

    @Test
    void shouldExitOnExitWord() {
        //given
        String input = "5\n6\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        Application.main(new String[]{});
    }

    @Test
    void shouldPassReadStringsToController() throws NoSuchFieldException, IllegalAccessException {
        //given
        String A = "5";
        String B = "6";
        String C = "+";

        String input = A+"\n"+B+"\n"+C+"\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);

        DefaultController mockController = mock(DefaultController.class);

        Field field = Application.class.getDeclaredField("controller");
        field.setAccessible(true);
        field.set(null, mockController);

        //when
        Application.main(new String[]{});

        //then
        verify(mockController).run(eq(A), eq(B), eq(C));
    }
}
