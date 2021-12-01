package ivcal;

import java.util.HashMap;
import java.util.Map;

public class IvCalculator {

    private Map<String, String> args;

    private IvCalculator(Map<String, String> args) {
        this.args = args;
    }

    public static IvCalculator of(Map<String, String> args) {
        return new IvCalculator(args);
    }

    //TODO : 계산결과 결과들을 List<String>에 담아 반환한다.
    public Map<String,String> cal() {
        return new HashMap<>();
    }
}