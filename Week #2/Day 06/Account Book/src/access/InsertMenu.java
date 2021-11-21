package access;

import personalData.AccountBook;
import personalData.PaymentMethod;
import personalData.Record;
import util.Inputter;

import java.time.LocalDate;
import java.util.Scanner;

public class InsertMenu {
    private static final String INSERT_MENU =
            "=============================\n"
            + "1. 입금\n"
            + "2. 이체\n"
            + "q. 나가기\n"
            + "=============================";


    private static Scanner SC = Inputter.getResource();
    private AccountBook accountBook;

    private InsertMenu(AccountBook accountBook) {
        this.accountBook = accountBook;
    }
    public static InsertMenu of(AccountBook accountBook) {
        return new InsertMenu(accountBook);
    }

    public boolean run() {
        String command = inputCommand();
        if(command.equals("q")) return true;
        boolean isIncomeRecord = Boolean.parseBoolean(command);

        Record record = inputRecord(isIncomeRecord);
        accountBook.add(record); // 작성 레코드를 accountBook에 추가한다.
        return run();
    }

    private void showMenu(String menu) {
        System.out.println(menu);
    }

    private String inputCommand() {
        showMenu(INSERT_MENU);
        String command = SC.nextLine().trim().toLowerCase();
        switch(command) {
            case "1" : return "true";
            case "2" : return "false";
            case "q" : return command;
            default :
                System.out.println("input : 1, 2, q");
                return inputCommand();
        }
    }

    // 레코드 작성
    private Record inputRecord(boolean isIncomeRecord) {
        long income = (isIncomeRecord)? inputBalance(true) : 0;
        long expense = (isIncomeRecord)? 0 : inputBalance(false);
        PaymentMethod paymentMethod = inputPaymentMethod();
        LocalDate localDate = inputLocalDate(); // 날짜
        String msg = inputMsg(); // 적요

        Record record = new Record(income, expense, paymentMethod, localDate, msg);
        return record;
    }

    private PaymentMethod inputPaymentMethod() {
        System.out.println("지불 방식을 입력해주세요.");
        System.out.println("1. 현금 2. 카드");
        System.out.print("PayMentMethod > ");
        String input = SC.nextLine();

        try {
            int code = Integer.parseInt(input);
            inputPaymentMethodCode_Validation(code);
            PaymentMethod paymentMethod = PaymentMethod.of(code);
            return paymentMethod;
        } catch (NumberFormatException e) {
            System.out.println("1 또는 2를 입력해주세요.");
            return inputPaymentMethod();
        } catch (IllegalArgumentException ile) {
            System.out.println(ile.getMessage());
            return inputPaymentMethod();
        }

    }

    private void inputPaymentMethodCode_Validation(int code) {
        if (code ==1 || code ==2) return;
        throw new IllegalArgumentException("1 또는 2의 값을 입력해주세요.");
    }

    private long inputBalance(boolean isIncome) {

        String balanceCategory = (isIncome)? "수입금" : "지출금";

        System.out.println( balanceCategory +"을 입력해주세요.");
        System.out.print(balanceCategory +">");
        String input = SC.nextLine();
        try {
            long parseLong = Long.parseLong(input);
            inputBalanceValidCheck(parseLong);
            return parseLong;
        } catch (NumberFormatException ne) {
            System.out.println("0보다 큰 정숫값을 입력해주세요.");
            return inputBalance(isIncome);
        } catch (IllegalArgumentException ile) {
            System.out.println(ile.getMessage());
            return inputBalance(isIncome);
        }
    }

    private void inputBalanceValidCheck(long balance) {
        if (balance <=0) throw new IllegalArgumentException("0보다 큰 정숫값을 입력해주세요.");
    }

    private LocalDate inputLocalDate() {
        System.out.println("날짜를 입력해주세요. 예)2021-11-12");
        System.out.print("LocalDate > ");
        String input = SC.nextLine();
        try {
            LocalDate parseDate = LocalDate.parse(input);
            return parseDate;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("날짜를 잘못 입력하셨습니다. 지정 형식에 맞게 입력해주세요.");
            return inputLocalDate();
        }
    }

    private String inputMsg() {
        System.out.println("적요를 입력해주세요. 예) 호눅스한테 돈을 빼앗겼다.");
        String input = SC.nextLine();
        return input;
    }

}
