# 코코아 Day03 Mission : 인디언 이름 짓기

입력한 날짜에 대응하는 인디언식 이름을 반환하기  

참조 : [[인디언식 이름 짓기, 당신의 이름은?]](https://news.mt.co.kr/mtview.php?no=2012011010541914553)

````
생년월일을 입력해 주세요>
1999 12 9
당신의 이름은 용감한 황소의 노래입니다. 
````

## Main
- 생년월일을 입력하여, LocalDate 클래스의 birthDate 생성.
- 이를 통해 Indian 객체를 생성
- 인디언식 이름 출력

```
package indianName;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate birthDate = Prompt.input(); // 사용자로부터 날짜를 입력받아 LocalDate를 반환받는다.
        Indian indian = new Indian(birthDate); // LocalDate로 Indian 객체 생성
        Prompt.print(indian); // indian의 인디언식 이름을 출력한다.
    }
}
```

## Prompt
- static LocalDate input() : 사용자로부터 생년월일을 입력받아, LocalDate를 반환받음
- static void print(final Indian indian) : indian의 인디언식 이름을 출력

## Member
- 멤버들을 정의한 열거형
- static final Member[] MEMBERS : 멤버들 전원을 배열로 반환
- static final int count() : 멤버들의 수를 반환
- static Member rdmMember() : 임의의 멤버를 반환
- static Set<Member> randomSet(final int nmbOfMember) : 지정 인원수만큼 임의의 멤버들을 Set으로 반환

## Indian
- 생성자 : Indian(LocalDate birthDate)
- 클래스 변수 : private static final String[] FIRST_NAMES, MIDDLE_NAMES, LAST_NAMES
- 인스턴스 변수(생일) : private final LocalDate birthDate
- int getBirthYear() : 태어난 연도 반환
- int getBirthMonth() : 태어난 월 반환
- int getBirthDay() : 태어난 일 반환
- String firstName() : 첫번째 인디언식 이름 반환
- String middleName() : 가운데 인디언식 이름 반환
- String lastName() : 마지막 인디언식 이름 반환
- String fullname() : 인디언식 풀네임 반환

# 회고
- 배열로 인디언식 이름 템플릿을 작성하는데 실수의 여지가 매우 강해보인다.
- 다음에는 열거형으로 작성해봐야지.