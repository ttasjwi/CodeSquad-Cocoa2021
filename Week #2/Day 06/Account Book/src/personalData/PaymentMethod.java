package personalData;

public enum PaymentMethod {
    CASH, CARD;
    private static final PaymentMethod[] PAYMENT_METHODS = PaymentMethod.values();

    public static PaymentMethod[] arrays() {
        return PAYMENT_METHODS;
    }
}
