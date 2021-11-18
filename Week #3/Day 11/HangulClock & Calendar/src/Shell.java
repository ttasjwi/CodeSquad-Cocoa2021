import calendar.CalApp;
import calendar.Calendar;
import clock.ClockApp;
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
                new CalApp(args).run();
                break;
            case "clock" :
                new ClockApp(args).run();
                break;
            case "help" :
                help();
                break;
            default :
                throw new IllegalArgumentException("유효하지 않은 명령어입니다.");
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

}
