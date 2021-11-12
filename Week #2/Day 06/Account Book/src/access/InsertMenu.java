package access;

import personalData.AccountBook;
import util.Inputter;

import java.util.Scanner;

public class InsertMenu {
    private static Scanner SC = Inputter.getResource();
    private AccountBook accountBook;

    private InsertMenu(AccountBook accountBook) {
        this.accountBook = accountBook;
    }

    public static InsertMenu of(AccountBook accountBook) {
        return new InsertMenu(accountBook);
    }

    public void run() {
    }
}
