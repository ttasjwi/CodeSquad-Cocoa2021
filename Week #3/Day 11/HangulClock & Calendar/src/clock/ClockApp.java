package clock;

import java.util.List;

public class ClockApp {

    private final List<String> args;

    public ClockApp(List<String> args) {
        this.args = args;
    }

    public void run() {
        if (args.size()==0) {
            System.out.println(HangulClock.now());
            return;
        }
        throw new IllegalArgumentException("clock 오류 : 인자의 갯수가 유효하지 않습니다.");
    }
}
