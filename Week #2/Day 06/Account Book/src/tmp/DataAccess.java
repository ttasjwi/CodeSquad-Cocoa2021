package tmp;

import data.AccountBook;

import java.util.Arrays;
import java.util.List;

import static util.Resource.scanner;

public class DataAccess {

    enum Command {
        WRITE("1", );

        private String commandCode;
        private DataAccessCommand;

        void run() {

        }

    }

    private static final List<String> orders = Arrays.asList(new String[]{"1","2","3","4","q"});
    private static final String ACCESS_MSG =
                                            "=== 명령을 입력해주세요. ===\n" +
                                            "1. 데이터 입력 : 날짜, 적요, 수입, 지출\n" +
                                            "2. 데이터 삭제 : 지정 순번의 데이터를 삭제\n" +
                                            "3. 데이터 수정 : 지정 순번의 데이터를 수정\n" +
                                            "4. 데이터 출력 : 지출 내역을 화면에 출력\n"+
                                            "q. 로그아웃\n"+
                                            "==========================";

    private final AccountBook account;

    DataAccess(AccountBook account) {
        this.account = account;
    }

    void run() {
        DataAccessCommand order = inputOrder();

    }

    private DataAccessCommand inputOrder() {
        System.out.println(ACCESS_MSG);
        String input = scanner.nextLine().toLowerCase();
        try {
            inputValidation(input);
            DataAcceeCommand
            return input;
        } catch(IllegalArgumentException ie) {
            return inputOrder();
        }
    }

    void inputValidation(String input) {
        if (!orders.contains(input)) {
            throw new IllegalArgumentException("유효하지 않은 명령입니다.");
        }
    }
}
