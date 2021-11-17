package clock;

public enum HangulHour {
    한시(1), 두시(2), 세시(3), 네시(4), 다섯시(5), 여섯시(6),
    일곱시(7), 여덟시(8), 아홉시(9), 열시(10), 열한시(11), 열두시(12);

    // 멤버변수
    private int hourValue;

    // 생성자
    HangulHour(int hourValue) {
        this.hourValue = hourValue;
    }

    // 열거형 상수들의 배열
    private static final HangulHour[] HANGUL_HOURS = HangulHour.values();

    //지정 시간값(1~12)에 해당하는 HangulHour 반환
    public static HangulHour of(int ClockHourValueOfAmPm) {
        return HANGUL_HOURS[ClockHourValueOfAmPm-1];
    }
}