
## data
- Key : id, password를 저장한 객체
- Record : 날짜, 적요, 수입, 지출을 기록한 저장
- AccountBook : List<Record>를 감싼 클래스
- AccountBooks : Map<Key, Account>를 감싼 클래스

## 로그인을 어떻게 할까?
- 아이디, 패스워드를 입력받아 Key 객체를 생성.
- AccountBooks에서 동일한 Key가 존재하는지 확인하고, 존재한다면 연결된 AccountBook을 반환받아 접근한다.

## 회원 가입을 어떻게 할까?
- 아이디, 패스워드를 입력하여 Key 객체를 생성
- AccountBooks에서 동일한 Key가 존재하는지 확인하고, 존재한다면 실패 메시지를 던지고 AccountBooks에 put하지 않는다.
- 동일한 Key가 존재하지 않는다면 AccountBooks에 (Key, new AccountBook())을 put한다.

- 그런데 이렇게 짜보니 문제점이 생긴다. Key의 동일성을 어떻게 처리하냐의 문제이다. hashCode()와 equals()를 어떻게 해야할 것인가?
name, password 두 값이 모두 같은 상황을 기준으로 동일성을 처리해버리면 로그인 문제는 smooth하게 처리할 수 있지만,
회원가입 시 같은 name, 다른 password를 가진 Key를 생성하여 Map에서 조회했을 때 다른 것으로 간주되어 그냥 회원가입이 가능해진다. 이를 필터링할 다른 수단이 필요하다.

## AccountBook을 반환받았다고 치자.
- 이제 이 AccountBook의 각 데이터를 조회, 수정, 삭제, 변경하는 작업을 어떻게 처리할까. 이것도 문제이다.
- 이 작업에 대한 메뉴를 어떻게 띄울 것이고 어떻게 예외를 처리할 것이며, 어떻게 작업을 수행할지...
- 각 클래스를 어떻게 분리하고 어떻게 메서드를 분리할 지
- 각 객체들은 어떻게 상호작용해야할지

온갖 요소들을 생각하자니 머리 아프다 으아아아아아악 내일 생각해보자.