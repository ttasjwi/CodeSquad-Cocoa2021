package access;

import personalData.AccountBook;
import util.Inputter;

import java.util.Scanner;

public class SearchMenu {
    private static Scanner SC = Inputter.getResource();
    private AccountBook accountBook;

    private SearchMenu(AccountBook accountBook) {
        this.accountBook = accountBook;
    }

    public static SearchMenu of(AccountBook accountBook) {
        return new SearchMenu(accountBook);
    }

    public void run() {
    }
}
