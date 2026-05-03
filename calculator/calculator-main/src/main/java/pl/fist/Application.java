package pl.fist;

import java.util.Scanner;

public class Application {

    private static final String END = "koniec";
    private static CalculatorService service = new CalculatorService();
    private static DefaultController controller = new DefaultController(service);

    public static void main(String[] args) {
        System.out.println("Napisz \"" + END + "\" żeby zakończyć");

        Scanner scanner = new Scanner(System.in);
        String[] questions = {"Podaj a: ", "Podaj b: ", "Podaj działanie: "};

        int i = 0;

        String[] strings = new String[questions.length];

        while (true) {
            System.out.print(questions[i]);
            String line = scanner.nextLine();

            if (END.equalsIgnoreCase(line)) {
                break;
            }
            strings[i] = line;
            i++;

            if (i == 3) {
                System.out.println("Wynik: " + controller.run(strings[0], strings[1], strings[2]));
                i = 0;
            }
        }
    }
}
