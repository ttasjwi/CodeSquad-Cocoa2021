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
            default :
                throw new IllegalArgumentException("당신은 올바르지 않은 형태의 명령어 혹은 인자를 입력하셨다...");
        }
    }

    private void input() {
        args.clear();
        System.out.print(PROMPT);
        String[] inputSplit = SC.nextLine().trim().split(" +");

        for (int i=0; i<inputSplit.length; i++) {
            if (i==0) {
                currentCommand = inputSplit[i];
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

        if (args.size() ==2) {
            int year = Integer.parseInt(args.get(0));
            int month = Integer.parseInt(args.get(1));
            calValidation(year, month);
            Calendar.print(year, month);
        }

    }

    private void calValidation(int year, int month) {
        if (!(1<=month && month<=12)) throw new IllegalArgumentException("올바르지 않은 월입니다. input : 1~12");
    }

    private static void clock() {
        System.out.println(HangulClock.now());
    }

}
