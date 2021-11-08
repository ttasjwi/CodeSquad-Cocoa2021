package tmp;

import data.AccountBooks;

public class Prompt {
    final AccountBooks accountBooks = new AccountBooks();
    StartMenu startMenu = new StartMenu(accounts);

    void run() {

    }

    String inputOrder() {
        System.out.println(START_MSG);
        try {
            String input = scanner.nextLine();

        } catch(IllegalArgumentException ie) {
            ie.printStackTrace();
        }
    }

    // 입력한 명령의 유효성 체크
    private void orderValidation(String inputOrder) {
        if (inputOrder)
    }


    private void orderValidation(String order) {
        if (order.equals)
    }

    // 사용자로부터 입력을 받아 Key를 생성한다.
    static final Key createKey() {
        System.out.print("name > ");
        String name = scanner.nextLine();
        System.out.print("pw > ");
        String password = scanner.nextLine();

        return new Key(name, password);
    }

}
