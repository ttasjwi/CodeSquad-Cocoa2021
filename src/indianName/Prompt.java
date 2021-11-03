package indianName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Prompt {
    final static String INPUT_MSG = "생년월일을 입력해주세요 (예 : 2020 11 03) >>> ";
    final static Scanner scanner = new Scanner(System.in);
    final static DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy MM dd");

    static LocalDate input() {
        System.out.print(INPUT_MSG);
        final String input = scanner.nextLine();
        try {
            LocalDate parseDate = LocalDate.parse(input, DATE_PATTERN);
            return parseDate;
        } catch (Exception e) {
            return input();
        }
    }
    
    // 지정 indian의 fullName을 출력
    static void print(final Indian indian) {
        String fullName = indian.fullname();
        System.out.printf("당신의 이름은 %s입니다.",fullName);
    }
}
