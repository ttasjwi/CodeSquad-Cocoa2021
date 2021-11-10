package appDB;

import personalData.AccountBook;
import personalData.UserData;

import java.util.HashMap;
import java.util.Map;

public class AccountBookDB {

    private Map<String, AccountBook> map;

    public AccountBookDB() {
        this.map = new HashMap<>();
    }

    // DB의 사용자들 중 지정 id의 존재성을 확인하여 반환
    public boolean containsID(String id) {
        return this.map.containsKey(id);
    }

    // 지정 accountBook을 map에 등록시킴
    public boolean register(AccountBook accountBook) {
        String id = accountBook.getID();
        if (this.containsID(id)) return false;
        map.put(id, accountBook);
        return true;
    }

}


