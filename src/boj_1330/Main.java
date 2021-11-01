package boj_1330;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        Prompt p = new Prompt();
        p.run();
    }
}

class Prompt {

    void run() throws IOException {
        String input = getInput();

        StringTokenizer st = new StringTokenizer(input, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String comparison = getComparison(a, b);
        System.out.println(comparison);

    }

    // 지정 int값들을 비교 후 비교 결과를 부등호 문자로 반환
    private String getComparison(int a, int b) {
        String result = "";
        if (a > b) result = ">";
        if (a == b) result = "==";
        if (a < b) result = "<";
        return result;
    }

    private String getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        return input;
    }
}
