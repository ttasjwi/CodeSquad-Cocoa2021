package data;

import java.util.Objects;

public class Key {
    private String name;
    private String password;

    public Key(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    // Key의 동일성을 name으로 구분하기 위해 hashCode(), equals 오버라이드
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Key)) return false;
        Key other = (Key) o;
        return this.name.equals(other.name);
    }

}
