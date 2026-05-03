package pl.fist;

import java.util.Arrays;

public class DefaultController {

    public DefaultController() {}

    public void run(String a, String b, String c) {
        parseNumber(a);
        parseNumber(b);
        if (!Arrays.asList("+", "-", "*", "/").contains(c)) {
            throw new IllegalStateException(c + "is not a valid operation");
        }
    }

    private void parseNumber(String stringNumber) {
        try {
            Double.parseDouble(stringNumber);
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException(stringNumber + "is not stringNumber number");
        }
    }
}
