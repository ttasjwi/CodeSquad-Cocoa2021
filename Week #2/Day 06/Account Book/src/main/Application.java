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

    //TODO : Application 실행
    public void run() {
        System.out.println(START_MENU_MSG);
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
        System.out.println("뭔가 유효한 값이 제대로 넘어왔나보군! 예이~");
        }


    //TODO : 사용자로부터 명령을 입력받아 반환하도록 함.
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

    private void inputValidCheck(String input) {
        switch(input) {
            case "1" : case "2" : case "q" :
                return;
            default : break;
        }
        throw new IllegalArgumentException("홈화면 입력 오류 : 유효한 입력값은 1, 2, q 입니다.");
    }

}
