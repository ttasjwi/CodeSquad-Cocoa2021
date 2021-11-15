import view.HangulClock;

public class Main {

    public static void main(String[] args) {
        while (true) {
            HangulClock nowClock = HangulClock.now();
            System.out.println(nowClock);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
