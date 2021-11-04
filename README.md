
# 개발환경
 - jdk 11 [설치](https://www.oracle.com/java/technologies/downloads/#java11, "go to java Downloads")
 - \#\#\#시험용 jdk 11 [[설치]](https://www.oracle.com/java/technologies/downloads/#java11){:target="_blank"}
 - IntelliJ IDEA Community Edition [toolboxApp을 통해서 설치](https://www.jetbrains.com/ko-kr/toolbox-app, "go to Toolbox App Download")
 - 인텔리제이 단축키를 새로 잘 익혀두는게 중요! 이건 블로그에 일단 임시로 정리하고 있다.

# Day 1 미션

 ## Git 및 GitHub 사용법 익히기
 - README.md 생성 : Repository에 관한 정보를 기입할 수 있음. 마크다운 사용법도 지속적으로 익혀두면 좋음.
 - 미션리스트 업로드
 - 작성 코드는 github에 업로드 및 push
 - 주의 사항 : 불필요한 파일들은 커밋에 포함하지 않는다 <- .ignore을 통해 건들여야할듯...
 - Git, GitHub 초기 설정부분까지 정리해뒀다. [링크](https://ttasjwi.tistory.com/5?category=895784)

 ## 구구단
  - 사용자로부터 시작단, 끝단을 입력받아 구구단을 출력함
  - 작성 코드 : [링크](https://github.com/ttasjwi/CodeSquad-Cocoa2021/tree/master/src/gugudan "작성 코드 확인하기")
  - 막상 작성해 놓고보니, 입력을 받아 Dans를 출력하는 getDans() 메서드를 Dans에 정의했어야했는지, Prompt()에 정의해야했는지, 아니면 생성자로 다 퉁쳐야했는지 애매모호해짐. 이 부분에 대해서는 다른 분들과 의견을 교류하고 싶다. -> [Dan의 풀이](https://github.com/ttasjwi/CodeSquad-Cocoa2021/tree/Dan/src/gugudan)

 ## 백준 - 조건문 연습
   - boj_1330 (Bronze4) : 두 수 비교해서 비교결과 부등호 출력하기 <a href="https://www.acmicpc.net/problem/1330" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_1330" target="_blank">[풀이]</a>
   - boj_9498 (Bronze4) : 점수를 입력받아, 등급(F,D,C,B,A)을 출력 <a href="https://www.acmicpc.net/problem/9498" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_9498" target="_blank">[풀이]</a>
   - boj_2753 (Bronze4) : 연도를 입력받아 윤년, 평년 여부를 문자 '1', '0'으로 반환 <a href="https://www.acmicpc.net/problem/2753" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_2753" target="_blank">[풀이]</a>
   - boj_14681(Bronze4) : 점의 x,y 좌표를 입력받아 해당 점이 어느 사분면에 속하는지 문자로 반환 <a href="https://www.acmicpc.net/problem/14681" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_14681" target="_blank">[풀이]</a>

# Day 3 미션

## 랜덤 뽑기

- <a href="https://github.com/ttasjwi/CodeSquad-Cocoa2021/tree/master/src/rdmMember" target="_blank">[풀이]</a>
- 멤버들을 이어 붙일 때 Stream에 대한 지식이 좀 더 있었으면 StringBuilder 대신 이를 이용해 출력하기 좋았을텐데 이 부분이 아쉽다. Stream을 공부해야겠다는 생각이 들었다.

## 인디언 이름 짓기

- <a href="https://github.com/ttasjwi/CodeSquad-Cocoa2021/tree/master/src/indianName" target="_blank">[[풀이]]</a>
- 후기 : 생년월일의 각 성분과, 인디언 이름의 매칭을 배열로 해놨지만, 이보다는 열거형을 통해 정의하는게 더 나을 것 같다.

# Day 4 수업

## Git 관리

- 불필요한 파일 올리지 않기. (git ignore 적극 활용)
- .ignore의 활용법을 대강 취합해봤다. : <a href="https://ttasjwi.tistory.com/8" target="_blank">[블로그 글]</a>
- 

