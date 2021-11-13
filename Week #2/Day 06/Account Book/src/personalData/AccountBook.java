package personalData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountBook {

    private final List<Record> records = new ArrayList<>(); // 이 가계부의 기록들
    private UserData userData;

    public AccountBook(UserData userData) {
        this.userData = userData;
    }

    public String getID() {
        return this.userData.getID();
    }

    public boolean hasSamePassWord(String passWord) {
        return this.userData.hasSamePassWord(passWord);
    }

    // 레코드를 추가한다.
    public boolean add(Record record) {
        return records.add(record);
    }

    // 지정 인덱스에 저장된 레코드를 삭제한다.
    public Record remove(int index) {
        return records.remove(index);
    }

    // 지정 인덱스에 저장된 레코드를 변경한다.
    public void set(int index, Record replacement) {
        records.set(index, replacement);
    }

    // 잔액을 반환한다.
    public long balance() {
        long balance = 0;

        Iterator<Record> ir = records.iterator();
        while(ir.hasNext()) {
            balance += ir.next().recordBalance();
        }
        return balance;
    }

    // Iterator를 반환한다.
    public Iterator<Record> iterator() {
        return this.records.iterator();
    }
}
