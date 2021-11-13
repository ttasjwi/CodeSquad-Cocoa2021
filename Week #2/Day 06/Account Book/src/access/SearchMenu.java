package access;

import personalData.AccountBook;
import personalData.Record;
import util.Inputter;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

public class SearchMenu {
    private static Scanner SC = Inputter.getResource();
    private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

    private AccountBook accountBook;

    private SearchMenu(AccountBook accountBook) {
        this.accountBook = accountBook;
    }

    public static SearchMenu of(AccountBook accountBook) {
        return new SearchMenu(accountBook);
    }

    public void run() {
        // 시험삼아 전체출력 넣음
        searchAll();
    }

    public void searchAll() {
        Iterator<Record> ir = accountBook.iterator();
        System.out.printf("%15s %20s %20s %4s %50s%n", "날짜", "수입", "지출", "지불방식", "적요");
        while(ir.hasNext()) {
            Record record = ir.next();
            System.out.printf("%16s %21s %21s %5s %51s%n",
                    record.getLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                    DECIMAL_FORMAT.format(record.getIncome()),
                    DECIMAL_FORMAT.format(record.getExpense()),
                    record.getPaymentMethod().getNameKor(),
                    record.getMsg());
        }
    }

}
