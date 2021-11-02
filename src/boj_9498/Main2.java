package boj_9498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;

class Main2 {

    public static void main(String[] args) throws IOException {
        Prompt2 p = new Prompt2();
        p.run();
    }

}

class Prompt2 {
    void run() throws IOException {
        int score = inputScore(); // 점수 입력
        String grade = getGrade(score); // 등급 반환
        System.out.println(grade); // 등급 출력
    }

    // 사용자로부터 점수를 입력받아 int로 반환한다.
    private int inputScore() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        br.close();

        return score;
    }

    // 지정 점수를 등급(A,B,C,D,F)으로 반환함.
    private String getGrade(int score) {
        String pattern = "0#F|60#D|70#C|80#B|90#A";
        ChoiceFormat gradeForm = new ChoiceFormat(pattern);
        String grade = gradeForm.format(score);
        return grade;
    }
}