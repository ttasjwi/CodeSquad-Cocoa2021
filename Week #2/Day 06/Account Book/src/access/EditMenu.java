package access;

import personalData.AccountBook;
import util.Inputter;

import java.util.Scanner;

public class EditMenu {

    private static Scanner SC = Inputter.getResource();
    private AccountBook accountBook;

    private EditMenu(AccountBook accountBook) {
        this.accountBook = accountBook;
    }

    public static EditMenu of(AccountBook accountBook) {
        return new EditMenu(accountBook);
    }

    public void run() {
    }
}
