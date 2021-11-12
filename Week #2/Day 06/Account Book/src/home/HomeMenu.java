package home;

import appDB.AccountBookDB;
import util.Inputter;

import java.util.Scanner;

public class HomeMenu {

    private static Scanner SC = Inputter.getResource();
    private AccountBookDB accountBookDB;

    private static final String HOME_MENU =
            "==============\n" +
                    "1. 로그인\n" +
                    "2. 사용자 등록\n" +
                    "q. 프로그램 종료\n" +
                    "=============";

    // 생성자
    public HomeMenu (AccountBookDB accountBookDB) {
        this.accountBookDB = accountBookDB;
    }

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

    // 홈메뉴 창을 보인다.
    private void showHomeMenu() {
        System.out.println(HOME_MENU);
    }

    // 사용자로부터 명령을 입력받아 반환하도록 한다.
    private String inputCommand() {
        System.out.print("값을 입력해주세요... (1, 2, q) >  ");
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
