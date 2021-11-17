package calendar;

import java.util.List;

public class CalApp {

    private final List<String> args;

    public CalApp(List<String> args) {
        this.args = args;
    }

    public void run() {
        if (args.size() ==0) {
            Calendar.printThisMonth();
            return;
        }

        if (args.size() == 1) {
            System.out.println("지정 년도 달력 출력은 현재 구현되지 않은 기능입니다.");
            return;
        }

        if (args.size() ==2) {
            int year = Integer.parseInt(args.get(0));
            int month = Integer.parseInt(args.get(1));
            calValidation(year, month);
            Calendar.print(year, month);
            return;
        }
        throw new IllegalArgumentException("cal 오류 : 인자의 갯수가 유효하지 않습니다.");
    }

    private void calValidation(int year, int month) {
        if (!(1<=month && month<=12)) throw new IllegalArgumentException("올바르지 않은 월입니다. input : 1~12");
    }
}
