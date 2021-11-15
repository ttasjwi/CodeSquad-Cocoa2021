package time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class HangulTime {

    //멤버변수
    private final LocalDateTime datetime;

    //생성자
    private HangulTime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    //현재 시각의 HangulTime 객체 반환
    public static HangulTime now() {
        return new HangulTime(LocalDateTime.now());
    }

    // 년
    private int yearValue() {
        return this.datetime.getYear();
    }

    // 월
    private int monthValue() {
        return this.datetime.getMonthValue();
    }

    // 일값
    private int dayValue() {
        return this.datetime.getDayOfMonth();
    }

    // 오전(AM)이면 0, 오후(PM)면 1을 반환
    private int amPm_Value() {
        return this.datetime.get(ChronoField.AMPM_OF_DAY);
    }

    //시간값 (0~23)
    private int hourValue() {
        return datetime.getHour();
    }

    //시간값 (1~12)
    private int clock_Hour_Of_AMPM_Value() {
        return this.datetime.get(ChronoField.CLOCK_HOUR_OF_AMPM);
    }

    //분값(0~59)
    private int minuteValue() {
        return this.datetime.getMinute();
    }

    //초값(0~59)
    private int secondValue() {
        return this.datetime.getSecond();
    }


    //한글 날짜
    public String getMonth() {
        return HangulNumber.hangulTime(dayValue())+"일";
    }

    //한글 오전? 오후?
    public String getAMPM() {
        return (amPm_Value() == 0) ? "오전" : "오후";
    }

    //한글 시각
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
        StringBuffer sb = new StringBuffer();
        sb.append(getMonth());

        if (hourValue()==0 && minuteValue()==0 && secondValue()==0) {
            sb.append("자정");
            return sb.toString();
        }
        if (hourValue() ==12 && minuteValue()==0 && secondValue()==0) {
            sb.append("정오");
            return sb.toString();
        }
        sb.append(getAMPM());
        sb.append(getClockHourOfAMPM());
        if (minuteValue()!=0) sb.append(getMinute());
        if (secondValue()!=0) sb.append(getSecond());
        return sb.toString();
    }

}
