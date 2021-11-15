package view;

import time.HangulTime;

import java.util.Arrays;
import java.util.StringTokenizer;

public class HangulClock {


    private static final char[][] HANGULS = {
            {'이', '삼', '십', '일', '이', '삼', '사', '오'},
            {'육', '칠', '팔', '구', '일', '오', '전', '후'},
            {'＃', '열', '한', '두', '세', '네', '다', '＃'},
            {'여', '섯', '일', '곱', '덟', '아', '홉', '시'},
            {'이', '삼', '사', '오', '십', '일', '이', '＃'},
            {'삼', '사', '오', '육', '칠', '팔', '구', '분'},
            {'이', '삼', '사', '오', '십', '일', '이', '＃'},
            {'삼', '사', '오', '육', '칠', '팔', '구', '초'}
    };

    private char[][] chars = {
            {'＃', '＃', '＃', '＃', '＃', '＃', '＃', '＃'},
            {'＃', '＃', '＃', '＃', '＃', '＃', '＃', '＃'},
            {'＃', '＃', '＃', '＃', '＃', '＃', '＃', '＃'},
            {'＃', '＃', '＃', '＃', '＃', '＃', '＃', '＃'},
            {'＃', '＃', '＃', '＃', '＃', '＃', '＃', '＃'},
            {'＃', '＃', '＃', '＃', '＃', '＃', '＃', '＃'},
            {'＃', '＃', '＃', '＃', '＃', '＃', '＃', '＃'},
            {'＃', '＃', '＃', '＃', '＃', '＃', '＃', '＃'},
    };

    private HangulTime hangulTime;

    public HangulClock(HangulTime hangulTime) {
        this.hangulTime = hangulTime;
        fillClock();
    }

    public static HangulClock now() {
        return new HangulClock(HangulTime.now());
    }

    private void fillClock() {
        String hangulTimeStr = this.hangulTime.toString();
        for (int i=0, k=0; i<chars.length; i++) {
            for (int j=0; j<chars[i].length && k<hangulTimeStr.length(); j++) {
                if (hangulTimeStr.charAt(k) == HANGULS[i][j]) {
                    chars[i][j] = HANGULS[i][j];
                    k++;
                }
            }
        }
        return;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("======================================\n");
        for (int i=0; i<chars.length; i++) {
            for (int j=0; j<chars[i].length; j++) {
                sb.append(chars[i][j]);
            }
            sb.append('\n');
        }
        sb.append("======================================");
        return sb.toString();
    }
}
