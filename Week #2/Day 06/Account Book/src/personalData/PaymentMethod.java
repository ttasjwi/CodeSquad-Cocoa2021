package personalData;

import java.util.Arrays;
import java.util.List;

public enum PaymentMethod {
    CASH("현금", 1), CARD("카드", 2);
    private String nameKor;
    private int code; // 수입이면 true, 지출이면 false;

    PaymentMethod(String nameKor, int code) {
        this.nameKor = nameKor;
        this.code = code;
    }

    private static final List<PaymentMethod> PAYMENT_METHODS = Arrays.asList(PaymentMethod.values());

    public static final PaymentMethod of(int code) {
        return PAYMENT_METHODS.get(code-1);
    }

    public String getNameKor() {
        return this.nameKor;
    }

    public int getCode() {
        return this.code;
    }

}
