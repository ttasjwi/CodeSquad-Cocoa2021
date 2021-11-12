
## personalData
- UserData: id, password, name을 저장
- Record : 날짜, 적요, 수입, 지출, 지출방식을 기록한 저장
- AccountBook : List<Record>, userData로 구성된 클래스. 개별 가계부를 정의함.
- AccountBooks : Map<String, Account>를 감싼 클래스. id를 Key로 하였다.


## 실행 과정


### 0. util.Inputter
```
    public class Inputter {
    
        private static final Scanner SC = new Scanner(System.in);
        public static Scanner getResource() {
            return SC;
        }
    }
```
- 화면 입력으로 사용할 Scanner를 여러곳에서 공유하다보니 그냥 아얘 상수로 생성해버렸다.
- 이건 뭔가 아니다 싶었는데, 당장 구현이 급급해서 이런 방법을 쓸 수밖에 없었다.

### 1. main.Main
```
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
```
- Application 객체 app을 생성
- app의 run() 메서드를 호출하고 작업이 끝나면 종료된다.

### 2. main.Application
```
    private static final Scanner SC = Inputter.getResource();
    private final AccountBookDB accountBookDB = new AccountBookDB();

    public Application() {
        putFileData();
    }

    // TODO : 프로젝트 폴더의 텍스트 파일들을 읽어와서, DB에 추가한다.
    void putFileData() {

    }
```
- 명시적 초기화 : 객체 생성 시 accountDB에 새로운 AccountDB를 생성해서 입력한다.
- 구현하지 못 한 것 : 객체 생성 과정에서 디렉토리에 위치한 데이터베이스 파일들을 가져오는 기능이 필요하다.
```
    // 홈화면을 호출한다. 홈화면의 작업을 마치면 종료하면서 true를 반환한다.
    public boolean run() {
        HomeMenu homeMenu = new HomeMenu(accountBookDB);
        homeMenu.run();
        return true;
    }
```
- run() 메서드는 accountBookDB 정보를 가진 HomeMenu 객체를 생성한다.
- HomeMenu에게 run()메서드를 실행하도록 한다. 이때 홈메뉴가 종료되면 메서드가 종료된다. 
- homeMenu.run() 메서드는 후술하겠지만 별도의 탈출명령어를 입력하기 전까지 재귀를 계속하는 boolean 타입의 재귀메서드다.

### 3. home.HomeMenu
```
    // HomeMenu를 실행한다.
    public boolean run() {
        showHomeMenu();
        String command = inputCommand();

        switch (command) {
            case "1":
                LoginMenu loginMenu = LoginMenu.of(accountBookDB);
                loginMenu.run();
                break;
            case "2":
                RegisterMenu registerMenu = new RegisterMenu(accountBookDB);
                registerMenu.run();
                break;
            case "q":
                System.out.println("가계부 어플리케이션을 종료합니다. 바이바이~");
                return true;
        }
        return run();
    }
```
- run() 메서드는 재귀 메서드이다.
- inputCommand() 메서드를 통해, 사용자로부터 command를 입력받는다. 이는 1 또는 2 또는 q만을 입력받게한다.
- command값이 1이면 로그인 창으로 이동
- command값이 2이면 회원가입 창으로 이동
- command값이 q이면 run()메서드가 true를 반환하도록 한다.
  - 반환된 위치(application.run()로 돌아가면, 다음줄에서 return문을 만나 어플리케이션이 종료된다.
- 로그인 또는 회원가입 작업을 마치고 돌아오면, 다시 return run()메서드를 만나 처음으로 돌아온다.

### 3-1. home.LoginMenu

```
    // 실행
    public boolean run() {
        showMenu();
        String quitCommand = inputCommand();
        if (quitCommand.equals("q")) return true; // q를 입력하면 종료

        List<String> inputValues = inputUserData();
        AccountBook accountBook = accountBookDB.login(inputValues);

        try {
            loginCheck(accountBook);
        } catch (IllegalArgumentException ile) {
            System.out.println(ile.getMessage());
            return this.run();
        }

        // 반환되었으면 accessMenu를 실행한다.

        //TODO : AccessMenu 구현하기
//        AccessMenu accessMenu = accessMenu.of(accountBook);
//        accessMenu.run();
        return this.run();
    }
```
- showMenu()를 통해 메뉴창을 띄운다. 이 상태에서 inputCommand()를 받고, 입력값이 q이면 메서드를 종료하여 메인메뉴로 돌아간다. (탈출조건)
- 사용자로부터 id, passWord를 입력받는다.
- 입력값으로부터 accountBookDB.login() 메서드를 호출하고, accountBook을 반환받는다.
  - 아이디, 패스워드가 일치하지 않으면 null을 반환받고, loginCheck() 메서드는 accounbBook이 null일경우 IllegalArgumentException을 throws한다.
  - IllegalArgumentException이 throw 되면, catch되고 다시 run() 메서드를 재귀호출한다.
- 정상적으로 accountBook이 반환되면, AccessMenu 객체를 생성하고 run()을 호출하여 AccessMenu로 이동한다.
- AccessMenu의 작업이 완료되면, 다시 재귀호출되어 처음으로 돌아온다.

### 3-2. home.RegisterMenu
```
    // 실행
    public void run() {
        showMenu();
        String quitCommand = inputCommand();
        if (quitCommand.equals("q")) return;

        UserData userData = inputUserData();
        AccountBook accountBook = new AccountBook(userData);
        accountBookDB.register(accountBook);
        System.out.println(userData.getID()+"님 등록에 성공하셨습니다.");
        return;
    }
```
- showMenu()를 통해 메뉴창을 띄운다. 이 상태에서 inputCommand()를 받고, 입력값이 q이면 메서드를 종료하여 메인메뉴로 돌아간다.
  ```
      // id, pw, name 을 입력하여 userData를 생성
      private UserData inputUserData() {
          String id = inputID();
          String passWord = inputPassWord();
          String name = inputName();
  
          return new UserData(id, passWord, name);
      }
      
      // id 입력
      private String inputID() {
          System.out.println("(사용자 등록) 사용하실 ID를 입력해주세요.");
          System.out.print("ID >");
          try {
              String input = SC.nextLine();
              idValidCheck(input);
              return input;
          } catch (IllegalArgumentException ile) {
              System.out.println(ile.getMessage());
              return inputID();
          } catch (Exception e) {
              e.printStackTrace();
              return inputID();
          }
      }  
  ```
- inputUserData()를 통해 사용자 정보를 입력받고, userData 객체를 생성한다.
  - 사용자로부터 아이디를 입력받는다. accountBookDB에 저장되어 있는 아이디이면, 다시 입력하도록 재귀호출된다.
  - 패스워드를 입력받는다.
- userData를 기반으로 accountBook을 생성
- accountBookDB에 accountBook을 register한다.
- 메인메뉴로 반환된다.
- **다시 코드를 보니, 회원가입에 성공하지 않으면 run() 메서드를 탈출할 수 없는 구조다. 개선이 필요함.**
- 
---

### 구현 초기단계에서의 고찰 (Day 06 시점)

- 아이디, 패스워드를 입력하여 Key 객체를 생성
- AccountBooks에서 동일한 Key가 존재하는지 확인하고, 존재한다면 실패 메시지를 던지고 AccountBooks에 put하지 않는다.
- 동일한 Key가 존재하지 않는다면 AccountBooks에 (Key, new AccountBook())을 put한다.

- 그런데 이렇게 짜보니 문제점이 생긴다. Key의 동일성을 어떻게 처리하냐의 문제이다. hashCode()와 equals()를 어떻게 해야할 것인가?
- name, password 두 값이 모두 같은 상황을 기준으로 동일성을 처리해버리면 로그인 문제는 smooth하게 처리할 수 있지만, 회원가입 시 같은 name, 다른 password를 가진 Key를 생성하여 Map에서 조회했을 때 다른 것으로 간주되어 그냥 회원가입이 가능해진다.
- name이 같은 상황을 기준으로 Key의 동일성을 처리해버리면, 회원 가입문제를 smooth하게 처리할 수 있지만, 로그인 시 같은 name, 다른 password를 입력하더라도 동일한 Key로 간주하여 AccountBook에 접근하는 문제가 발생함.
- 이를 필터링할 다른 수단이 필요하다.

## AccountBook을 반환받았다고 치자.
- 이제 이 AccountBook의 각 데이터를 조회, 수정, 삭제, 변경하는 작업을 어떻게 처리할까. 이것도 문제이다.
- 이 작업에 대한 메뉴를 어떻게 띄울 것이고 어떻게 예외를 처리할 것이며, 어떻게 작업을 수행할지...
- 각 클래스를 어떻게 분리하고 어떻게 메서드를 분리할 지
- 각 객체들은 어떻게 상호작용해야할지

온갖 요소들을 생각하자니 머리 아프다 으아아아아아악 내일 생각해보자.