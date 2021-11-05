
# 개발환경
 - jdk 11 <a href="https://www.oracle.com/java/technologies/downloads/#java11" target="_blank">설치</a>
 - IntelliJ IDEA Community Edition <a href="https://www.jetbrains.com/ko-kr/toolbox-app" target="_blank">toolbox-app을 통해 설치</a>
 - 인텔리제이 단축키를 새로 잘 익혀두는게 중요! 이건 블로그에 일단 임시로 정리하고 있다.

# Day 1 미션

 ## 마크다운(MarkDown)
 - README.md 작성을 통해 내가 작성한 소스파일에 대한 설명을 전달하기 좋음
 - 마크다운 문법을 통하여 내가 학습한 기록을 정리하도록 하자.
 - 주의점 : md파일에서 새창 링크 기능을 작성하려고 몇 번 시도해봤지만, GitHub에서는 작동 안 됨. Github의 MarkDown->HTML번역 엔진이, anchor태그(a 태그)의 target="_blank" 속성을 추가하지 않았기 때문.
   <a href="https://stackoverflow.com/questions/41915571/open-link-in-new-tab-with-github-markdown-using-target-blank">stackOverflow 참조</a>,
   <a href="https://www.quora.com/Why-is-target-blank-not-working-in-a-GitHub-readme-file">quora 참조</a>
 - 혹시나, 나중에 target="_blank" 속성을 추가할 때를 대비해서 \<a href="..." target="_blank"> 속성으로 링크를 계속 작성해보도록 할 것이다.

 ## Git 및 GitHub 사용법 익히기
 - README.md 생성 : Repository에 관한 정보를 기입할 수 있음. 마크다운 사용법도 지속적으로 익혀두면 좋음.
 - 미션리스트 업로드
 - 작성 코드는 github에 업로드 및 push
 - 주의 사항 : 불필요한 파일들은 커밋에 포함하지 않는다. (.ignore 파일 적극 활용)
 - Git, GitHub 초기 설정부분까지 블로그에 정리해뒀다. <a href="https://ttasjwi.tistory.com/5" target="_blank">정리 글</a>

 ## 구구단
  - 사용자로부터 시작단, 끝단을 입력받아 구구단을 출력함
  - 작성 코드 : <a href="https://github.com/ttasjwi/CodeSquad-Cocoa2021/tree/master/src/gugudan" target="_blank">링크</a>
  - 막상 작성해 놓고보니, 입력을 받아 Dans를 출력하는 getDans() 메서드를 Dans에 정의했어야했는지, Prompt()에 정의해야했는지, 아니면 생성자로 다 퉁쳐야했는지 애매모호해짐. 이 부분에 대해서는 다른 분들과 의견을 교류하고 싶었는데 TA인 Dan이 피드백을 주셨다.
    -> <a href="https://github.com/ttasjwi/CodeSquad-Cocoa2021/tree/Dan/src/gugudan" target="_blank">Dan의 풀이</a>

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

- <a href="https://github.com/ttasjwi/CodeSquad-Cocoa2021/tree/master/src/indianName" target="_blank">[풀이]</a>
- 후기 : 생년월일의 각 성분과, 인디언 이름의 매칭을 배열로 해놨지만, 이보다는 열거형을 통해 정의하는게 더 나을 것 같다.

# Day 4 수업

## Git 관리

- 불필요한 파일 올리지 않기. (git ignore 적극 활용)
- .ignore의 활용법을 대강 취합해봤다. <a href="https://ttasjwi.tistory.com/8" target="_blank">[블로그 글]</a>

## 자바의 타입
- 변수의 선언과 초기화 정리 : <a href="https://ttasjwi.tistory.com/9" target="_blank">[블로그 글]</a>

# Day 5 알고리즘 풀기
### 알고리즘 풀면서 든 생각
- 알고리즘 문제 푸는 것은 속도 빠르게, 작동 잘 되면 장땡이긴 함.
- 근데 이렇게 하려면 메서드 분리 같은거 안 하고, 메인 메서드에 다 때려박아야함
- 클린코드 실천 노력과 멀어지는게 뭔가 불.편.하.다.
- 
### 알고리즘 풀이 (Level 1)
- boj_1000 (Bronze5) : 입력으로 정수 2개를 입력받고, 이들의 합을 반환하기(A+B) <a href="https://www.acmicpc.net/problem/1000" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_1000" target="_blank">[풀이]</a>
- boj_1008 (Bronze4) : 두 정수 A,B를 입력받은 다음 A/B를 출력하는 프로그램 작성(A/B) <a href="https://www.acmicpc.net/problem/1008" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_1008" target="_blank">[풀이]</a>
- boj_2438 (Bronze3) : 각 줄마다 N개 별찍기 <a href="https://www.acmicpc.net/problem/2438" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_2438" target="_blank">[풀이]</a>
- boj_2920 (Bronze2) : 입력한 나열된 음계(숫자)의 증감 여부를 출력하기 <a href="https://www.acmicpc.net/problem/2920" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_2920" target="_blank">[풀이]</a>
- boj_8958 (Bronze2) : <a href="https://www.acmicpc.net/problem/8958" target="_blank">[문제]</a>
- boj_11654 (Bronze5) : <a href="https://www.acmicpc.net/problem/11654" target="_blank">[문제]</a>