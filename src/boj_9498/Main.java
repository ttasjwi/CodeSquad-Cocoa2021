package boj_9498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Prompt p = new Prompt();
        p.run();
    }

}

class Prompt {
    void run() throws IOException {
        int score = inputScore();
        String grade = getGrade(score);
        System.out.println(grade);
    }

    private int inputScore() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        br.close();

        return score;
    }

    private String getGrade(int score) {
        String grade = "F";

        if (60<=score&&score<70) grade = "D";
        else if (70<=score&&score<80) grade = "C";
        else if (80<=score&&score<90) grade = "B";
        else if (90<=score&&score<=100) grade = "A";
        return grade;
    }
}