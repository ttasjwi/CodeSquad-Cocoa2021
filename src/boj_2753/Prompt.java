package boj_2753;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Prompt {
    void run() {
        int year = inputYear();
        char leapYearCode = getLeapYearCode(year);
        System.out.println(leapYearCode);
    }

    // 사용자로부터 연도를 입력받는다.
    private int inputYear() {
        int year = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            year = Integer.parseInt(br.readLine());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return year;
    }

    // 지정 연도가 윤년이면 '1', 평년이면 '0'을 반환한다.
    private char getLeapYearCode(int year) {
        char leapYearCode = '0';
        if (isLeapYear(year)) {
            leapYearCode = '1';
        }
        return leapYearCode;
    }

    // 지정 연도가 윤년이면 true, 평년이면 false 를 반환
    private boolean isLeapYear(int year) {
        return (year%4==0 && year%100 !=0)||year%400==0;
    }
}