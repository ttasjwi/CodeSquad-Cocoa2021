# Day 08

Date : 2021.11.10 (Wed)  
학습 내용 : 미션(가계부 기능 추가)

---

## 미션 : 가계부에 기능 추가하기
- 자동 저장 기능을 추가한다. 프로그램 종료 후 다시 시작해도 데이터가 보존되도록 구현해 보자.
  - FileWriter?
- 소비 유형을 추가한다. (현금 / 카드)
  - 생성자와 멤버변수에 현금, 카드의 유형을 추가해봐야겠군.
- 검색 기능을 구현한다. 적요, 날짜, 금액, 수입, 지출, 소비 유형별로 검색을 하고 결과를 표시할 수 있어야 한다.
- 정렬해서 보여주기 기능을 추가한다. 날짜 또는 금액의 오름차순 또는 내림차순으로 정렬해서 화면에 출력할 수 있어야 한다.
  - 어떻게 구현할까? : Comparator 구현을 해서 정렬을 해보자!


### 어떻게 할까?
- 일단, 가계부가 완성되지 않았으니 가계부 먼저 해보도록 하자.
- 사소한 기능부터 차근차근 완성해나가면 될거야. 아자아자!

## 홀짝 게임 : 홀짝 게임 / 행맨 요구사항 추가하기
- 게임 오버시 이름을 입력받고 랭킹을 출력해 준다. 랭킹은 소지금이 많을 수록, 턴이 작을수록 높아진다.
- 게임 종료후 재시작시 이어하기 기능을 구현해 본다.
- [선택] 홀짝 게임을 확장해서 123게임으로 변경해 본다. 플레이는 123 중 두 수를 선택할 수 있으며 첫 수의 배수가 나오면 플레이어의 승리 두번째 수의 배수가 나오면 비김 3번째 수가 나오면 딜러가 이긴다.