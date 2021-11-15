package form;

public enum HangulHour {
    한(1), 두(2), 세(3), 네(4), 다섯(5), 여섯(6),
    일곱(7), 여덟(8), 아홉(9), 열(10), 열한(11), 열두(12);

    // 멤버변수
    private int hourValue;

    // 생성자
    HangulHour(int hourValue) {
        this.hourValue = hourValue;
    }

    // 열거형 상수들의 배열
    private static final HangulHour[] HANGUL_HOURS = HangulHour.values();

    //TODO : 시간(1~12)을 입력받았을 때 한글 시간을 반환 (예 : 9 -> 아홉시)
    public static HangulHour of(int hour) {
        return null;
    }

}