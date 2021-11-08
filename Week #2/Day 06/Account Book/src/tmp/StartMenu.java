package tmp;

import data.AccountBook;
import data.AccountBooks;

public class StartMenu {
    private AccountBooks accounts;

    StartMenu(AccountBooks accounts) {
        this.accounts = accounts;
    }

    private static final String START_MENU_MSG =
            "==============\n" +
                    "1. 로그인\n" +
                    "2. 사용자 등록\n" +
                    "q. 프로그램 종료\n" +
                    "=============";

    void run() {

    }

    String inputOrder() {
        System.out.println(START_MENU_MSG);
        String input = Prompt.scanner.nextLine();

    }


    DataAccess login() {
        AccountBook
        return DataAccess(Account);
    }
}
