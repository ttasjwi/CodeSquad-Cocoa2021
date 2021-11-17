import calendar.Calendar;
import clock.HangulClock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shell {

    private static final String PROMPT = ">";
    private static final Scanner SC = new Scanner(System.in);
    private String currentCommand;
    private List<String> args = new ArrayList<>();

    public boolean run() {
        try {
            input();
            if (isQuitCommand()) return true;
            execute();
        } catch (IllegalArgumentException ile) {
            System.out.println(ile.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return run();
    }

    private boolean isQuitCommand() {
        return currentCommand.equals("quit");
    }

    private void execute() {
        switch(currentCommand) {
            case "cal" :
                cal();
                break;
            case "clock" :
                clock();
                break;
            case "help" :
                help();
                break;
            default :
                throw new IllegalArgumentException("당신은 올바르지 않은 형태의 명령어 혹은 인자를 입력하셨다...");
        }
    }

    private void help() {
        if (args.size()==0) {
            System.out.println("cal : 이번달 달력 출력");
            System.out.println("cal yyyy MM : 지정 년월 달력 출력 (예) cal 2021 11");
            System.out.println("clock : 현재 한글시계 출력");
            System.out.println("quit : Shell 종료");
        }

    }

    private void input() {
        args.clear();
        System.out.print(PROMPT);
        String[] inputSplit = SC.nextLine().trim().split(" +");

        for (int i=0; i<inputSplit.length; i++) {
            if (i==0) {
                currentCommand = inputSplit[i].toLowerCase();
                continue;
            }
            args.add(inputSplit[i]);
        }
    }


    private void cal() {
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

    private static void clock() {
        System.out.println(HangulClock.now());
    }

}
