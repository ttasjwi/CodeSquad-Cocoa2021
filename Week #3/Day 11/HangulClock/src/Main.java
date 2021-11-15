import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh시 mm분 ss초");
        String timeStr = timeFormatter.format(now);
        System.out.println("현재 시각은 "+timeStr+"입니다.");
    }
}
