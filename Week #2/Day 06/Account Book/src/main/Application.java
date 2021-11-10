package main;

public class Application {

    //TODO : Application 생성자 : 초기화 역할
    public Application() {
        //* 경로에 위치한 개별 AccountBook들을 순서대로 읽어온다.
        //* Record들을 읽어오고, AccountBooks에 추가한다.
    }

    //TODO : Application 실행
    public void run() {
        System.out.println("명령을 입력해주세요.");
        System.out.println("1. 로그인(미구현)");
        System.out.println("2. 회원가입(미구현)");
        System.out.println("q. 종료");

        String command = inputCommand();
        if (command.equals("q")) {
            System.out.println("가계부 어플리케이션을 종료합니다. 바이바이~");
            return;
        }

        /*
        0. 홈 화면을 띄운다.
        1. 사용자로부터 입력을 받는다. (로그인, 회원가입, 종료)
        2. 사용자로부터 입력을 받은 명령을 수행한다.
            만약 명령이 정해진 명령이 유효하지 않으면 다시 입력받도록 돌아간다.
         */
        System.out.println("하와와. 뭔가가 잘못된것이에요");
        }


    //TODO : 사용자로부터 명령을 입력받아 반환하도록 함.
    private String inputCommand() {
        return "q";
    }

}
