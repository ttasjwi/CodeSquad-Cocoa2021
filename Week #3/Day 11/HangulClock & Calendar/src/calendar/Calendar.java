package calendar;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Calendar {

    private LocalDate standardDate;

    // 생성자
    private Calendar(LocalDate date) {
        this.standardDate = date;
    }

    private Calendar(int year, int month, int dayOfMonth) {
        this.standardDate = LocalDate.of(year, month, dayOfMonth);
    }

    // 지정 연월의 Calendar을 받아온다.
    public static Calendar of(int year, int month) {
        LocalDate firstDateOfMonth = LocalDate.of(year,month,1);
        return new Calendar(firstDateOfMonth);
    }

    // 이번 달 Calendar를 받아온다.
    public static Calendar thisMonth() {
        final LocalDate now = LocalDate.now();
        return new Calendar(now);
    }

    // 년도를 int로 반환
    public int year() {
        return standardDate.getYear();
    }

    // 월을 int로 반환
    public int month() {
        return standardDate.getMonthValue();
    }

    // 이 달의 최대일수
    public int lengthOfMonth() {
        return standardDate.lengthOfMonth();
    }

    // 이 달의 첫번째 날을 LocalDate로 가져옴
    public LocalDate firstDayOfMonth() {
        return standardDate.with(TemporalAdjusters.firstDayOfMonth());
    }


    private void print() {
        System.out.println("===========================");
        System.out.printf("　　　　<<%4d년 %2d월>>%n",year(),month());
        System.out.println("===========================");
        System.out.printf("%3s %3s %3s %3s %3s %3s %3s%n", "SUN", "MON", "TUE", "WED", "WED", "THU", "SAT");
        System.out.println("===========================");

        LocalDate firstDate = firstDayOfMonth();
        int dayOfweekOfFirstDate = firstDate.getDayOfWeek().getValue();
        for (int i=0; i<dayOfweekOfFirstDate; i++) {
            System.out.print("    ");
        }
        for (int i=1 ; i <= lengthOfMonth(); i++) {
            LocalDate date = LocalDate.of(year(),month(), i);
            System.out.printf("%3d ", date.getDayOfMonth());
            if (date.getDayOfWeek().getValue()%7 == 6) System.out.println();
        }
        System.out.println("\n===========================");
    }

    public static void printThisMonth() {
        Calendar thisMonth = Calendar.thisMonth();
        thisMonth.print();
    }

    public static void print(int year, int month) {
        Calendar monthCal = Calendar.of(year, month);
        monthCal.print();
    }

}
