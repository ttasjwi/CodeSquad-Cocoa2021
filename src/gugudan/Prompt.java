package gugudan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prompt {

    private static final int MIN = 1;
    private static final int MAX = 9;

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> input() {
        System.out.print("몇 단부터 몇 단까지? ex) 2 7 : ");
        final String input = scanner.nextLine();
        final String[] s = input.split(" ");
        final List<Integer> list = new ArrayList<>();
        for (final String e : s) {
            final Integer parseInt = Integer.parseInt(e);
            list.add(parseInt);
        }

        try {
            inputValidation(list);
        } catch (final Exception e) {
            return input();
        }

        return list;
    }

    private static void inputValidation(final List<Integer> list) {
        for (final Integer e : list) {
            if (e < MIN || e > MAX) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void print(final Dans dans) {
        for (int i = dans.getStart(); i <= dans.getEnd(); i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %d\n", i, j, i * j);
            }
        }
    }
}
