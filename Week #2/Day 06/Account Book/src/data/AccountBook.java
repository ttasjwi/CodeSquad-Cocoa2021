package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountBook {

    private List<Record> records =  new ArrayList<>(); // 이 가계부의 기록들

    // 지정 인덱스 시점에서 남아있는 잔액을 반환한다.
    public int getBalance(int index) {
        List<Record> sublist = records.subList(0, index+1);
        Iterator<Record> ir = sublist.iterator();

        int balance = 0;
        while(ir.hasNext()) {
            Record r = ir.next();
            balance += r.getChange();
        }
        return balance;
    }

    // 레코드를 추가한다.
    void addRecord(Record record) {
        records.add(record);
    }

    // 지정 인덱스에 위치한 레코드를 삭제한다.
    void deleteRecord (int index) {
        records.remove(index);
    }

    // 지정 인덱스에 위치한 데이터를 변경한다.
    void replaceRecord(int index, Record replacement) {
        records.set(index, replacement);
    }

}
