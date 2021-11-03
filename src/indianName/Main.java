package indianName;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate birthDate = Prompt.input(); // 사용자로부터 날짜를 입력받아 LocalDate를 반환받는다.
        Indian indian = new Indian(birthDate); // LocalDate로 Indian 객체 생성
        Prompt.print(indian); // indian의 인디언식 이름을 출력한다.
    }
}
