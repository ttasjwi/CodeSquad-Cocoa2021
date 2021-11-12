package access;

import personalData.AccountBook;
import util.Inputter;

import java.util.Scanner;

public class AccessMenu {
    private static Scanner SC = Inputter.getResource();
    private AccountBook accountBook;

    private AccessMenu(AccountBook accountBook) {
        this.accountBook = accountBook;
    }

    public static AccessMenu of(AccountBook accountBook) {
        return new AccessMenu(accountBook);
    }

    private static final String ACCESS_MENU =
            "==============\n" +
                    "1. 데이터 추가\n" +
                    "2. 데이터 삭제\n" +
                    "3. 데이터 변경\n" +
                    "4. 데이터 조회\n" + // 전체출력, 조건 출력, 오름차순/내림차순
                    "q. 로그아웃\n" +
                    "=============";

    // Menu를 실행한다.
    public boolean run() {
        showMenu();
        String command = inputCommand();

        switch (command) {
            case "1":
                InsertMenu insertMenu = InsertMenu.of(accountBook);
                insertMenu.run();
                break;
            case "2":
                DeleteMenu deleteMenu = DeleteMenu.of(accountBook);
                deleteMenu.run();
                break;
            case "3":
                EditMenu editMenu = EditMenu.of(accountBook);
                editMenu.run();
                break;
            case "4":
                SearchMenu searchMenu = SearchMenu.of(accountBook);
                searchMenu.run();
                break;
            case "q":
                System.out.println("로그아웃 처리 되었습니다.");
                return true;
        }
        return run();
    }

    private void showMenu() {
        System.out.println(ACCESS_MENU);
    }

    // 사용자로부터 명령을 입력받아 반환하도록 한다.
    private String inputCommand() {
        System.out.print("값을 입력해주세요... (1, 2, 3, 4, q) >  ");
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
            case "3":
            case "4":
            case "q":
                return;
            default:
                break;
        }
        throw new IllegalArgumentException("홈화면 입력 오류 : 유효한 입력값은 1, 2, q 입니다.");
    }
}
