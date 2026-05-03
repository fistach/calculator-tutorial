package pl.fist;

import java.util.Scanner;

public class Application {

    private static CalculatorService service = new CalculatorService();
    private static DefaultController controller = new DefaultController(service);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        String[] strings = new String[3];

        while (true) {
            String line = scanner.nextLine();

            if ("exit".equalsIgnoreCase(line)) {
                break;
            }
            strings[i] = line;
            i++;

            if (i == 3) {
                controller.run(strings[0], strings[1], strings[2]);
                i = 0;
            }
        }
    }
}
