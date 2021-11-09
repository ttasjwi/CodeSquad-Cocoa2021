# Day 07

Date : 2021.11.09 (Tue)  
학습 내용 : 리뷰 및 수업

---

## 조건문, 반복문 이해하기
- 왜 필요한가?
  - 조건문 : 조건에 부합한 경우에만 특정 작업을 수행하도록 하기 위해.
  - 반복문 : 구조적으로 동일한 작업을, 반복적으로 수행하도록 하게 하기 위해. 코드를 간단히 하기 위해.
- 백준의 조건문, 반복문 문제를 풀면서 익혀보자.
  - Day01에서 문제를 푼 기록이 있으므로 <a href="https://github.com/ttasjwi/CodeSquad-Cocoa2021/tree/master/Week%20%231/Day%2001" target="_blank">GitHub 링크</a>로 대체
---

## 함수 복습
- Call by Value, Call by Reference
  - 어떤 함수를 호출하는 과정에서 인자(Argument)를 함수의 매개변수(Parameter)에 넘기게 되는 과정에서 어떤 방식으로 넘기느냐를 설명하는 문장
  - Call by Value : argument를 복제하여, Parameter에 대입함
  - Call by Reference : Parameter가 원본 argumnet를 직접 참조함. 따라서 함수의 작업과정에서 parameter의 변화는 argument에 영향을 미친다.
- Java에서는 Call by Value만 존재한다.
  - 기본형 : argument를 복제하여 Parameter에 대입함. 따라서 argument에 영향을 미치지 않는다.
  - 참조형 : argument의 value가 객체의 주소참조값이다. parameter에 주소참조값을 복사하여 넘김. argument를 복사하여 전달한다는 점에서는 Call by Value의 원칙은 그대로. 하지만, Heap에 위치한 객체의 주소참조값을 넘기므로, 작업 과정에서 객체 그 자체에 영향을 미친다. 
- return 명령어가 가지는 두 가지 의미
  - 호출한 위치로 돌아간다.
  - 반환값이 있는 경우, 호출한 위치에 값을 반환한다.
- return을 사용해야 하는 이유
  - 메서드의 역할수행을 끝마치고 종료하기 위해
  - 호출한 측에 결과값을 반환하기 위해
---

## 재귀의 기초
- 재귀 호출(recursion, recursive call) : 메서드 내부에서 메서드 자신을 다시 호출하는 것.
  - 자기 자신을 호출하는 메서드를 재귀 메서드라고 한다.
- 호출된 메서드는 원래 값이 아닌, '값에 의한 참조(Call by Value)'를 통해, 원래 값(Argument)이 아닌 복사된 값(Parameter)으로 작업하기 때문에 호출한 메서드와 관계 없이 독립적인 작업 수행이 가능.

### 재귀 사용에 있어서 주의할 점
- 특별한 조건이 주어지지 않고 단순히 재귀를 반복하게 되면 무한 반복에 빠지게 되고, StackOverFlow가 발생할 수 있음. 조건에 주의해야한다.
  - 종료시점을 우선적으로 고려해서 작성하는 것이 중요.
- 매개변수를 감소하는 쪽으로 짜도록 하는게 초보한테 유리하다고 함.

### 재귀호출 vs 반복문
- 반복문은 그저 같은 문장을 반복하여 수행
- 재귀호출은 반복 외에도 몇 가지 추가 작업을 진행함
  - 매개변수 복사 및 종료, 복귀할 주소 저장, ...
  - 따라서 반복문과 구조적으로 동일한 작업을 수행하더라도 수행시간이 더 오래 걸림
- 왜 재귀를 쓰는가?
  - 논리적 간결함 -> 경우에 따라 보다 더 가독성이 좋은 코드가 될 수 있음 -> 수정 및 유지,보수에 유리

---

## 재귀 연습
- 카운트 다운을 재귀로 구현하기
- 팩토리얼을 재귀로 구현하기
- 피보나치 수열을 재귀로 구현하기
- 하노이 타워를 재귀로 구현하기
- 백준 알고리즘 문제 2630 구현하기 https://www.acmicpc.net/problem/2630

정리하느라 손 못 댔다... 주말이든 언제든 빨리 이 부분은 해야한다!!!

---

## 클래스와 객체
- 객체지향 프로그래밍(OOP, Object-Oriented Programming) 이란?  
: 프로그램의 여러 요소를 객체(object)라는 기본 단위로 나누고 이들의 상호작용으로 서술하는 방식
- 객체지향 프로그래밍의 장점
  1. 코드의 재사용성이 좋다. 
  2. 중복코드를 제거함으로서 코드의 길이를 줄일 수 있다. 
  3. 유지보수에 용이하다.
- 객체지향 프로그래밍의 특징
1. 다형성
2. 캡슐화(정보 은닉)
3. 추상화
4. 상속
- 객체지향 프로그래밍에서 가장 중요한 것 : 객체, 객체의 행동

---

## 클래스
- 클래스 : 객체를 정의한 것. (상태 : 멤버변수, 행동 : 메서드)
- 객체 : 클래스에 정의된 것을 바탕으로 만들어진, 실제로 존재하는 것.
- 객체 vs 인스턴스 : 거의 구분할 필요는 없음.
  - 객체 : 모든 인스턴스를 대표하는 포괄적 의미
  - 인스턴스 : 어떤 클래스로부터 만들어진 것인지를 보다 강조하는 의미

---

## 객체의 상호작용
- 객체는 메서드를 통하여 상호작용을 한다.
- 객체들은 메서드의 매개변수(parameter), return문을 거쳐서 서로 메시지를 전달한다. (행동, 상호작용)
```
  Person honux = new Person("호눅스", 60);
  Animal rabbit = new Rabbit();
  honux.eat(rabbit);
  
  // 예를 들면 이 상황에서 eat 메서드를 통하여, honux 객체와, rabbit 객체는 서로 eat메서드에 정의된 상호작용을 한다.
  void eat(Animal animal) {
    System.out.println(name+"가 "+animal.toString()+"을 먹습니다. 냠냠 맛있엉");
    this.weight += animal.getWeight();;
    return;
  }
```
---

## 선언 위치에 따른 변수의 종류
### 1) 멤버 변수
클래스 내부에 선언된 변수
1. static 변수(cv)
  - 객체를 생성하지 않고 사용할 수 있음
  - 실행 후, 클래스가 JVM의 클래스로더에 의해 메모리의 메서드 영역(method area)에 올라갈 때 자동으로 초기화 (참조형 : null, boolean : false, char : '\u0000', byte/short/int : 0, long : 0L, float : 0.0f, double : 0.0d 또는 0.0)
2. 인스턴스 변수(iv)
  - 인스턴스가 힙(Heap)에 생성된 순간부터 사용할 수 있음.
  - 객체가 생성된 순간 자동으로 초기화됨. (참조형 : null, boolean : false, char : '\u0000', byte/short/int : 0, long : 0L, float : 0.0f, double : 0.0d 또는 0.0)

### 2) 지역 변수(Local Variable)
- 메서드 내부(매개변수 포함)에 선언된 변수
- 자동으로 초기화되지 않기 때문에 수동으로 초기화 코드를 작성해야 호출해서 사용할 수 있다.

* 참조 : 자바의 정석 3판(남 궁성 저)
---

# 운영체제  
## 운영체제는 왜 학습해야하는가  
백엔드 개발자에게 운영체제 지식은 매우 중요하다.  
기존에 학습경험이 없었다면 꼭 학습하자.  
추천도서 : http://www.yes24.com/Product/Goods/90124877  
추천강의 : http://www.kocw.net/home/search/kemView.do?kemId=1046323

일단 지금 자바 공부하기 및 문제 풀기 벅차서 여기까진 손 못 댐...

--- 

## 파일 IO
- IO란 무엇인가?
- 파일이란 무엇인가?
- 시스템 콜이란?
- 표준 입출력
- 파일 입출력

여기는 따로 정리할 틈이 없었다.

---

### Scanner를 통한 File 읽어오기
1. File 객체 생성
   - import : java.io.File;
   - 생성자
     - File(String source) : 파일 경로는 IntelliJ 기준으로 프로젝트 폴더가 기준점이 된다. 파일의 경로 및 이름에 해당하는 문자열을 삽입하면 됨.
     - 이 생성자는 FileNotFoundException을 throw함. try-catch로 처리하거나 호출한 측으로 throws를 시켜서 처리하면 됨
2. Scanner 생성
   - 생성자
     - Scanner(File source)
3. 생성 후 Scanner 사용은 별도 문서로 작성해둠.
  - Tistory 정리글 : <a href="https://ttasjwi.tistory.com/10" target="_blank"> 티스토리 포스팅 </a>

--- 

## DAN이 추천한 책 + 호눅스 추천 책 적당 취합

- 처음엔 평이 좋은 두껍고 어려운 책으로 입문하기보다, 쉽고 얇은 책으로 입문하는 것을 권장
- 책을 읽을 때도 소단원 단위로 깊게 파고들기보다 전체적으로 빠르게 읽으면서 흐름을 읽고, 머릿속에 카테고리화 한뒤 반복해서 보는 것을 추천

1. 우선순위 높음 (토끼책, JPA, Spring)
- 객체지향의 사실과 오해(토끼책) : <a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=60550259" target="_blank"> 알라딘</a>
- 자바 ORM 표준 JPA 프로그래밍 : <a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=62681446" target="_blank"> 알라딘</a>
- 토비의 스프링 3.1 (난이도 높음) : <a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=19505747" target="_blank"> 알라딘</a>
- 처음 배우는 스프링 부트 2 (난이도 쉬움. 입문시 훑는 용도로 추천) : <a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=168752840" target="_blank"> 알라딘</a>

2. 데이터 베이스
- REAL MYSQL 8.0 (매우 두꺼움) : <a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=278488709" target="_blank"> 1권 </a> <a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=278489401" target="_blank">2권</a>
- 호눅스 추천
  - SQL첫걸음 : <a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=69025381" target="_blank">알라딘</a>
  - 데이터베이스 첫걸음 : <a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=94059951" target="_blank">알라딘</a>

3. 네트워크
- 그림으로 배우는 HTTP & Network Basic : <a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=51908132" target="_blank"> 알라딘</a>
- 김영한 http : <a href="https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC" target="_blank"> 인프런</a>
