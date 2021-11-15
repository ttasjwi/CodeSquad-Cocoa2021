package time;

import javax.swing.*;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class HangulTime {

    //멤버변수
    private final LocalTime time;

    //생성자
    private HangulTime(LocalTime time) {
        this.time = time;
    }

    //현재 시각의 HangulTime 객체 반환
    public static HangulTime now() {
        return new HangulTime(LocalTime.now());
    }

    // 지정 시각의 HangulTime 객체 반환(시, 분)
    public static HangulTime of(int  hour, int min) {
        return new HangulTime(LocalTime.of(hour,min));
    }

    // 지정 시각의 HangulTime 객체 반환 (시, 분, 초)
    public static HangulTime of(int hour, int min, int sec) {
        return new HangulTime(LocalTime.of(hour,min,sec));
    }

    // 지정 시각의 HangulTime 객체 반환 (시, 분, 초, 나노초)
    public static HangulTime of(int hour, int min, int sec, int nanoOfSecond) {
        return new HangulTime(LocalTime.of(hour,min,sec,nanoOfSecond));
    }

    // 오전(AM)이면 0, 오후(PM)면 1을 반환
    private int amPm_Value() {
        return this.time.get(ChronoField.AMPM_OF_DAY);
    }

    //시간값 (0~23)
    private int hourValue() {
        return time.getHour();
    }

    //시간값 (1~12)
    private int clock_Hour_Of_AMPM_Value() {
        return this.time.get(ChronoField.CLOCK_HOUR_OF_AMPM);
    }

    //분값(0~59)
    private int minuteValue() {
        return this.time.getMinute();
    }

    //초값(0~59)
    private int secondValue() {
        return this.time.getSecond();
    }

    public String getAMPM() {
        return (amPm_Value() == 0) ? "오전" : "오후";
    }

    public String getClockHourOfAMPM() {
        return HangulHour.of(clock_Hour_Of_AMPM_Value()).name();
    }

    //한글 분을 반환받는다.
    public String getMinute() {
        return HangulNumber.hangulTime(minuteValue())+"분";
    }

    //한글 초를 반환받는다.
    public String getSecond() {
        if (this.secondValue() == 0) return "";
        return HangulNumber.hangulTime(secondValue())+"초";
    }

    @Override
    public String toString() {
        if (hourValue()==0 && minuteValue()==0 && secondValue()==0) {
            return "자정";
        }

        if (hourValue()==12 && minuteValue()==0 && secondValue()==0) {
            return "정오";
        }

        String am_pm = getAMPM();
        String hangulHour = getClockHourOfAMPM();
        String hangulMinute = (minuteValue()==0) ? "" : getMinute();
        String hangulSecond = (secondValue()==0) ? "" : getSecond();
        return am_pm + hangulHour + hangulMinute + hangulSecond;
    }

}