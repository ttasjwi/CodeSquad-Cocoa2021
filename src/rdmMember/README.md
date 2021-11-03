# 코코아 Day03 Mission : 랜덤 뽑기

지정한 숫자만큼 코코아 멤버들을 랜덤 출력한다.
````
몇 명인가요? 3
짱구, 아이유, 정우성
````

## Main
멤버의 수를 입력받고, 지정 숫자만큼 코코아 멤버들을 랜덤 출력

```
package rdmMember;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final int nmbOfMembers = Prompt.input(); // 사용자로부터 멤버의 수를 인원 받는다.
        final Set<Member> randomMembers = Member.randomSet(nmbOfMembers); // 인원수만큼 임의의 멤버들을 Set으로 반환한다.
        Prompt.print(randomMembers); // Set을 출력한다.
    }
}

```

## Prompt
- public static int input() : 사용자로부터 입력하고자 하는 인원수를 입력받음  
- private static void inputValidation (int input) : 입력 인원수의 유효성 확인
- static void print(Set<Member> memberSet) : 출력

## Member
- 멤버들을 정의한 열거형
- static final Member[] MEMBERS : 멤버들 전원을 배열로 반환
- static final int count() : 멤버들의 수를 반환
- static Member rdmMember() : 임의의 멤버를 반환
- static Set<Member> randomSet(final int nmbOfMember) : 지정 인원수만큼 임의의 멤버들을 Set으로 반환
