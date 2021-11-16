package time;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HangulNumber {

    private static final String[] NUMBERS = {"","일","이","삼","사","오","육","칠","팔","구"};
    private static String[] SMALL_UNITS = {"십",""};
    private static DecimalFormat UNIT_FORMAT = new DecimalFormat("00");

    public static String hangulTime(int value) {
        if (value==0) return "영";
        // 입력한 값을 00형식으로 포맷 후, 한글자씩 배열로 쪼갠다.
        String[] splits = UNIT_FORMAT.format(value).split("");

        StringBuffer sb = new StringBuffer();
        for (int i=0 ; i<splits.length; i++) {
            int parseInt = Integer.parseInt(splits[i]);
            if (parseInt==0) {continue;}
            if ((parseInt==1&&i==1)||(parseInt!=1)) {
                sb.append(NUMBERS[parseInt]);
            }
            sb.append(SMALL_UNITS[i]);
        }
        return sb.toString();
    }


}
