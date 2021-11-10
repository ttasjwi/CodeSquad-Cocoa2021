package home;

import appDB.AccountBookDB;
import personalData.AccountBook;
import personalData.UserData;
import util.Inputter;

import java.util.Scanner;

public class RegisterMenu {

    private final Scanner SC = Inputter.getResource();
    private final AccountBookDB accountBookDB;

    // 생성자
    public RegisterMenu(AccountBookDB accountBookDB) {
        this.accountBookDB = accountBookDB;
    }

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
    
    // 메뉴를 출력한다
    private void showMenu() {
        System.out.println("===============================");
        System.out.println("1. 사용자 등록");
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

    // passWord를 기입
    private String inputPassWord() {
        System.out.println("(사용자 등록) 사용하실 PW를 입력해주세요.");
        System.out.print("PW >");
        try {
            String input = SC.nextLine();
            return input;
        } catch (Exception e) {
            e.printStackTrace();
            return inputPassWord();
        }
    }

    // 이름을 기입
    private String inputName() {
        System.out.println("(사용자 등록) 사용자분의 성함을 입력해주세요.");
        System.out.print("Name >");
        try {
            String input = SC.nextLine();
            return input;
        } catch (Exception e) {
            e.printStackTrace();
            return inputName();
        }
    }

    // DB에서 동일한 id가 존재하는지 조회하고, 존재하면 예외를 throw 한다.
    private void idValidCheck(String input) {
        if (accountBookDB.containsID(input)) {
            throw new IllegalArgumentException("※ 중복 오류 : 이미 존재하는 id입니다. 다른 id를 사용해주십시오.");
        }
    }

}
