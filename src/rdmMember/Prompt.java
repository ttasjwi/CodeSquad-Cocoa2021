package rdmMember;

import java.util.Scanner;
import java.util.Set;

public class Prompt {

    static Scanner scanner = new Scanner(System.in);

    // 사용자로부터 출력하고자 하는 인원수를 입력받음
    public static int input() {
        System.out.print("몇 명인가요? > ");
        final String input = scanner.nextLine();
        try {
            final int parseInt = Integer.parseInt(input);
            inputValidation(parseInt);
            return parseInt;
        } catch (final Exception e) {
            return input();
        }
    }
    
    // 입력값이 유효한지 확인
    private static void inputValidation (int input) {
        if (input<0||input>Member.count()) {
            throw new IllegalArgumentException();
        }
    }
    
    // 출력
    static void print(Set<Member> memberSet) {
        final StringBuilder members = new StringBuilder();
        for (Member member : memberSet) {
            String memberName = member.name();
            members.append(memberName).append(',');
        }
        members.deleteCharAt(members.length()-1);
        System.out.println(members);
    }

}