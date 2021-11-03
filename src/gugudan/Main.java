package gugudan;

import java.util.List;

public class Main {

    public static void main(final String[] args) {
        final List<Integer> input = Prompt.input();

        final Dans dans = Dans.of(input);
        Prompt.print(dans);
    }
}
