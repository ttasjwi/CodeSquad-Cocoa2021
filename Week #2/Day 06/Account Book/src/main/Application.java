package main;

import util.Inputter;

import java.util.Scanner;

public class Application {

    private final Scanner SC = Inputter.getInstance();
    private static final String START_MENU_MSG =
            "==============\n" +
                    "1. 로그인\n" +
                    "2. 사용자 등록\n" +
                    "q. 프로그램 종료\n" +
                    "=============";

    //TODO : Application 생성자 : 초기화 역할
    public Application() {
        //* 경로에 위치한 개별 AccountBook들을 순서대로 읽어온다.
        //* Record들을 읽어오고, AccountBooks에 추가한다.
    }

    // 홈화면. 다음 창의 작업이 끝나면, 종료 명령어를 제외한 상황일 때 다시 run() 메서드를 호출함.
    public boolean run() {
        System.out.print(START_MENU_MSG);
        String command = inputCommand();
        switch (command) {
            case "1":
                System.out.println("로그인창으로 갈거야");
                break;
            case "2":
                System.out.println("회원가입 창으로 갈거야");
                break;
            case "q":
                System.out.println("가계부 어플리케이션을 종료합니다. 바이바이~");
                return true;
        }
        return run();
    }

    // 사용자로부터 명령을 입력받아 반환하도록 한다.
    private String inputCommand() {

        System.out.println("값을 입력해주세요... (1, 2, q) >  ");
        String input = SC.nextLine().trim().toLowerCase();
        try {
            inputValidCheck(input);
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
            return inputCommand();
        } catch (Exception e) {
            e.printStackTrace();
            return inputCommand();
        }
        return input;
    }

    // 사용자로부터 입력받은 홈화면 메뉴 선택의 유효성 체크
    private void inputValidCheck(String input) {
        switch (input) {
            case "1":
            case "2":
            case "q":
                return;
            default:
                break;
        }
        throw new IllegalArgumentException("홈화면 입력 오류 : 유효한 입력값은 1, 2, q 입니다.");
    }

}
