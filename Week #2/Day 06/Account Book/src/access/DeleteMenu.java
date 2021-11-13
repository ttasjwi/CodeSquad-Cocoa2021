package access;

import personalData.AccountBook;
import util.Inputter;

import java.util.Scanner;

public class DeleteMenu {
    private static Scanner SC = Inputter.getResource();
    private AccountBook accountBook;

    private DeleteMenu(AccountBook accountBook) {
        this.accountBook = accountBook;
    }

    public static DeleteMenu of(AccountBook accountBook) {
        return new DeleteMenu(accountBook);
    }

    public void run() {

    }
}
