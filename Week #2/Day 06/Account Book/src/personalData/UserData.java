package personalData;

public class UserData {
    private String id;
    private String passWord;
    private String name;

    // 생성자
    public UserData (String id, String passWord, String name) {
        this.id = id;
        this.passWord = passWord;
        this.name = name;
    }

    public String getID() {
        return this.id;
    }

    // 지정 passWord가 이 UserKey에 저장된 PassWord와 일치하는지 여부를 반환
    public boolean hasSamePassWord (String passWord) {
        return this.passWord.equals(passWord);
    }
}
