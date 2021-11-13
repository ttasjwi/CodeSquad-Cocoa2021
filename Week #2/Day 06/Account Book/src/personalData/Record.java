package personalData;

import java.time.LocalDate;

public class Record {
    private long income; // 수입
    private long expense; // 지출
    private PaymentMethod paymentMethod;  // 지불방식
    private LocalDate localDate; // 날짜
    private String msg; // 적요

    public Record (long income, long expense, PaymentMethod paymentMethod, LocalDate localDate, String msg) {
        this.income = income;
        this.expense = expense;
        this.paymentMethod = paymentMethod;
        this.localDate = localDate;
        this.msg = msg;
    }

    public int getYear() {
        return this.localDate.getYear();
    }

    public int getMonth() {
        return this.localDate.getMonthValue();
    }

    public int getDay() {
        return this.localDate.getDayOfMonth();
    }

    public LocalDate getLocalDate() {
        return this.localDate;
    }

    public String getMsg() {
        return this.msg;
    }

    public long getIncome() {
        return this.income;
    }

    public long getExpense() {
        return this.expense;
    }

    public long recordBalance() {
        return this.income-this.expense;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getPaymentMethodStr() {
        return this.paymentMethod.name();
    }


}