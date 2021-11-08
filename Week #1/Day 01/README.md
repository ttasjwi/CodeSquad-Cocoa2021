# Day 01

Date : 2021.11.01 (Mon)

---

## 코코아 과정의 목표
- 학습 방법을 익힌다. : 동료학습의 중요성?
- **코딩을 많이 한다.** : 그렇다... 호눅스의 말대로 코딩을 잘 하는 법은 코딩을 많이 하는 것이다. 이론적 지식의 학습도 중요하지만, 결국 내가 생각해서 내가 코드짜는 경험을 많이 쌓는게 제일 중요하다.
- 코딩하는 즐거움, 성장하는 즐거움을 익힌다. : 재미를 잃지 않는게 제일 중요해!

---

## 학습 방법 익히기
- 코딩으로 무엇을 만들 수 있을까?
- 나는 어떤 문제 해결을 하려고 하는가?
- 문제를 찾고, 문제를 해결하는 방법을 공부하기
- 더 나은 학습방법을 학습하기
- 좋은 질문하는 방법도 배우자
- 함께 자라기: 지식 및 경험 공유, 질문하는 습관 갖기

---

## 개발 환경 설정
- IntelliJ 사용 권장 (SW 라이센스 반드시 준수할 것!)
- JDK 설치: JDK는 11을 권장한다.
- git CLI / GUI 설치
---

## Git 및 GitHub 사용법 익히기
- README.md 생성 : Repository에 관한 정보를 기입할 수 있음. 마크다운 사용법도 지속적으로 익혀두면 좋음.
- 미션리스트 업로드
- 작성 코드는 github에 업로드 및 push
- 주의 사항 : 불필요한 파일들은 커밋에 포함하지 않는다. (.ignore 파일 적극 활용)
- Git, GitHub 초기 설정부분까지 블로그에 정리해뒀다. <a href="https://ttasjwi.tistory.com/5" target="_blank">정리 글</a>
- 필수 명령: clone, add, commit, push
- 저장소의 README를 잘 꾸미자.
- 마크다운 문법에 20분 정도 시간을 투자해서 익힌다.


---

## 마크다운(MarkDown)
- README.md 작성을 통해 내가 작성한 소스파일에 대한 설명을 전달하기 좋음
- 마크다운 문법을 통하여 내가 학습한 기록을 정리하도록 하자.
- 주의점 : md파일에서 새창 링크 기능을 작성하려고 몇 번 시도해봤지만, GitHub에서는 작동 안 됨. Github의 MarkDown->HTML번역 엔진이, anchor태그(a 태그)의 target="_blank" 속성을 추가하지 않았기 때문.
  <a href="https://stackoverflow.com/questions/41915571/open-link-in-new-tab-with-github-markdown-using-target-blank">stackOverflow 참조</a>,
  <a href="https://www.quora.com/Why-is-target-blank-not-working-in-a-GitHub-readme-file">quora 참조</a>
- 혹시나, 나중에 target="_blank" 속성을 추가할 때를 대비해서 \<a href="..." target="_blank"> 속성으로 링크를 계속 작성해보도록 할 것이다.

---

## 프로그래밍 복습
- 조건문
- 반복문
- 함수(메서드)

---

## 객체지향 생활 체조 원칙 지키기

원래보다 많이 가벼운 버전이다. 클린 코딩을 위해 연습해보자!

- 규칙 1: 한 메서드에는 가급적 두 단계 이내의 들여쓰기를 한다.
- 규칙 2: else 예약어를 지양한다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 메소드의 크기는 20줄 이내로 한다.
- 한 메소드는 한 가지 일을 하도록 구현한다.

---

## 미션 1 : 조건문, 반복문, 함수의 학습

---

## 미션 2 : GitHub 저장소 만들기

---

## 미션 3 : 구구단
- 사용자로부터 시작단, 끝단을 입력받아 구구단을 출력함
- 작성 코드 : <a href="https://github.com/ttasjwi/CodeSquad-Cocoa2021/tree/master/src/gugudan" target="_blank">링크</a>
- 막상 작성해 놓고보니, 입력을 받아 Dans를 출력하는 getDans() 메서드를 Dans에 정의했어야했는지, Prompt()에 정의해야했는지, 아니면 생성자로 다 퉁쳐야했는지 애매모호해짐. 이 부분에 대해서는 다른 분들과 의견을 교류하고 싶었는데 TA인 Dan이 피드백을 주셨다.
  -> <a href="https://github.com/ttasjwi/CodeSquad-Cocoa2021/tree/Dan/src/gugudan" target="_blank">Dan의 풀이</a>

---

## 미션 4 : 조건문 연습
- boj_1330 (Bronze4) : 두 수 비교해서 비교결과 부등호 출력하기 <a href="https://www.acmicpc.net/problem/1330" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_1330" target="_blank">[풀이]</a>
- boj_9498 (Bronze4) : 점수를 입력받아, 등급(F,D,C,B,A)을 출력 <a href="https://www.acmicpc.net/problem/9498" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_9498" target="_blank">[풀이]</a>
- boj_2753 (Bronze4) : 연도를 입력받아 윤년, 평년 여부를 문자 '1', '0'으로 반환 <a href="https://www.acmicpc.net/problem/2753" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_2753" target="_blank">[풀이]</a>
- boj_14681(Bronze4) : 점의 x,y 좌표를 입력받아 해당 점이 어느 사분면에 속하는지 문자로 반환 <a href="https://www.acmicpc.net/problem/14681" target="_blank">[문제]</a> <a href="https://github.com/ttasjwi/BOJ/tree/master/src/boj_14681" target="_blank">[풀이]</a>
- boj_2884 (Bronze3) : https://www.acmicpc.net/problem/2884

## 미션 5 : 별찍기
- 시간 관계상 아직 여기까진 못 함
- https://www.acmicpc.net/workbook/view/20

---

## 학습하기
- Git의 사용법에 대해 조금 더 공부해 보자.
- Java: IDE의 사용법, 조건문, 반복문

---

## 학습일지 기록하기
- 그날 그날 학습한 내용을 간단히 기록해 본다.
- GitHub Wiki 권장 (기타 플랫폼을 활용해도 무방) : 나는 GitHub의 README.md와, tistory 블로그를 활용하고 있다.

---

## 기존 기수 선배들의 조언
- 백엔드는 면접 때 CS 기초를 종종 물어본다. 꼭 공부해 놓자.
- 알고리즘도 일찍 시작하는 편이 좋다. 선택의 폭이 넓어진다.

---

## Reivew

<a href= "https://ttasjwi.tistory.com/2" target="_blank"> Tistory 블로그 글 </a>

---