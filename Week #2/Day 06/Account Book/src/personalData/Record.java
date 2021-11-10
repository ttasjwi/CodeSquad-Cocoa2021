package personalData;

import java.time.LocalDate;

public class Record {

    private LocalDate date;
    private String msg;
    private int income;
    private int expense;
    private PaymentMethod paymentMethod;

    public Record(LocalDate date, String mag, int income, int expense, PaymentMethod paymentMethod) {
        this.date = date;
        this.income = income;
        this.expense = expense;
        this.msg = msg;
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDate() {return date;}
    public int getIncome() {
        return income;
    }
    public int getExpense() {
        return expense;
    }
    public int getChange() {
        return income-expense;
    }
    public PaymentMethod getPaymentMethod() { return paymentMethod; }
}