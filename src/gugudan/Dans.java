package gugudan;

import java.util.List;

public class Dans {

    private final int start;
    private final int end;

    public Dans(final List<Integer> input) {
        this.start = Math.min(input.get(0), input.get(1)); // 작은 값이 시작단
        this.end = Math.max(input.get(0), input.get(1)); // 큰 값이 끝 단
    }

    public static Dans of(final List<Integer> input) {
        return new Dans(input);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
