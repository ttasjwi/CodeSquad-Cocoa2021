
public class Species {

    private String name; // 종족명
    private int hp; // hp
    private int attack; // 공격
    private int block; // 방어
    private int contact; // 특공
    private int defense; // 특방
    private int speed; // 스피드

    public Species(String name, int hp, int attack, int block, int contact, int defense, int speed) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.block = block;
        this.contact = contact;
        this.defense = defense;
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getBlock() {
        return block;
    }

    public int getContact() {
        return contact;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getTotal() {
        return hp + attack + block + contact + defense + speed;
    }

}
