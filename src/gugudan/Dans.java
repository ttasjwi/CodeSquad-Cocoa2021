package gugudan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dans {
    private int startDan;
    private int endDan;

    Dans(int startDan, int endDan) {
        this.startDan = Math.min(startDan, endDan); // 작은 값이 시작단
        this.endDan = Math.max(startDan, endDan); // 큰 값이 끝 단
        return;
    }

    // 사용자로부터 입력을 받아 Dans를 반환
    static Dans getDans()  {

        int startDan = 0;
        int endDan = 0;
        while (true) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                System.out.print("몇 단부터 몇 단까지? ex) 2 7 : ");
                String input = br.readLine();
                StringTokenizer st = new StringTokenizer(input, " ");
                startDan = Integer.parseInt(st.nextToken());
                endDan = Integer.parseInt(st.nextToken());
            } catch (Exception e) {
                continue;
            }
            break;
        }

        Dans dans = new Dans(startDan, endDan);
        return dans;
    }

    @Override
    // 단들을 문자열로 반환
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=startDan; i<=endDan; i++) {
            for (int j=1; j<=9; j++) {
                sb.append(i).append(" * ").append(j).append(" = ").append(i*j).append('\n');
            }
        }
        return sb.toString();
    }
}