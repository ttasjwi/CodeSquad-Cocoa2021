package util;

import java.util.Scanner;

public class Inputter {
    private final static Scanner SC = new Scanner(System.in);

    public static Scanner getInstance() {
        return SC;
    }
}
