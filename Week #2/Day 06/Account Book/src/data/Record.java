package data;

import java.time.LocalDate;

public class Record {

    private LocalDate date;
    private int income;
    private int expense;
    private String msg;

    public Record(LocalDate date, int income, int expense, String msg) {
        this.date = date;
        this.income = income;
        this.expense = expense;
        this.msg = msg;
    }

    public int getIncome() {
        return income;
    }

    public int getExpense() {
        return expense;
    }

    public int getChange() {
        return income-expense;
    }
}
