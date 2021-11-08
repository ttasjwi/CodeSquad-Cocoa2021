package data;

import java.util.HashMap;
import java.util.Map;

public class AccountBooks {

    private Map<Key, AccountBook> accountBooks = new HashMap<>();

    public void put(Key key, AccountBook account) {
        accountBooks.put(key, account);
    }

    public boolean containsKey(Key key) {
        return accountBooks.containsKey(key);
    }
}