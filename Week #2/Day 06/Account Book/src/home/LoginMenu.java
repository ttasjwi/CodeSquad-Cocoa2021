package home;

import appDB.AccountBookDB;
import personalData.AccountBook;
import util.Inputter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginMenu {

    private final Scanner SC = Inputter.getResource();
    private final AccountBookDB accountBookDB;

    // 생성자
    private LoginMenu(AccountBookDB accountBookDB) {
        this.accountBookDB = accountBookDB;
    }

    public static LoginMenu of(AccountBookDB accountBookDB) {
        return new LoginMenu(accountBookDB);
    }

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

    // 메뉴를 출력한다
    private void showMenu() {
        System.out.println("===============================");
        System.out.println("1. 로그인");
        System.out.println("q. 홈메뉴로 돌아가기");
        System.out.println("===============================");
    }

    // 사용자에게 1 또는 q를 입력하게 한다.
    private String inputCommand() {
        System.out.print("InputCommand >");
        try {
            String input = SC.nextLine().trim().toLowerCase();
            commandValidation(input);
            return input;
        } catch (IllegalArgumentException ile) {
            System.out.println(ile.getMessage());
            return inputCommand();
        } catch (Exception e) {
            e.printStackTrace();
            return inputCommand();
        }
    }

    // 입력한 명령이 유효한가?
    private void commandValidation(String input) {
        switch (input) {
            case "1" :
            case "q" : return;
            default : break;
        }
        throw new IllegalArgumentException("※ 명령 입력 오류 : 1 또는 q를 입력해주세요.");
    }

    private List<String> inputUserData() {
        List<String> inputValues = new ArrayList<>();
        inputValues.add(inputID());
        inputValues.add(inputPassWord());
        return inputValues;
    }


    // id 입력
    private String inputID() {
        System.out.println("(로그인) 사용자 ID를 입력해주세요.");
        System.out.print("ID >");
        try {
            String input = SC.nextLine();
            return input;
        } catch (Exception e) {
            e.printStackTrace();
            return inputID();
        }
    }

    // passWord를 기입
    private String inputPassWord() {
        System.out.println("(로그인) 사용자 패스워드를 입력해주세요.");
        System.out.print("PW >");
        try {
            String input = SC.nextLine();
            return input;
        } catch (Exception e) {
            e.printStackTrace();
            return inputPassWord();
        }
    }


    private void loginCheck(AccountBook accountBook) {
        if (accountBook == null) throw new IllegalArgumentException("잘못 입력하셨습니다.");
        System.out.println(accountBook.getID()+"님 로그인에 성공하셨습니다.");
    }
}
