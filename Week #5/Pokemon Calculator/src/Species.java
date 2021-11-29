import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Species {

    private static final Map<String, Species> SPECIES_MAP = initSpeciesMap();

    private static Map<String, Species> initSpeciesMap() {
        List<String> lines = inputData();

        HashMap<String, Species> speciesMap = new HashMap<>();
        for (String line : lines) {
            String[] lineSplit = line.split("\t");
            Species species = getSpecies(lineSplit);
            speciesMap.put(species.getName(), species);
        }
        return speciesMap;
    }

    private static Species getSpecies(String[] lineSplit) {
        String name = lineSplit[0];
        int hp = Integer.parseInt(lineSplit[1]);
        int attack = Integer.parseInt(lineSplit[2]);
        int block = Integer.parseInt(lineSplit[3]);
        int contact = Integer.parseInt(lineSplit[4]);
        int defense = Integer.parseInt(lineSplit[5]);
        int speed = Integer.parseInt(lineSplit[6]);

        Species species = new Species(name, hp, attack, block, contact, defense, speed);
        return species;
    }

    public static Species of(String name) {
        return SPECIES_MAP.get(name);
    }

    private static List<String> inputData() {
        List<String> lines = new ArrayList<>();
        final Path DATA_SRC = Paths.get("./src/Stat_table.txt");
        try {
            Files.lines(DATA_SRC, Charset.defaultCharset()).forEach(lines::add);
        } catch(IOException ie) {
            System.out.println("종족데이터 로딩 실패!");
        }
        return lines;
    }

    private String name; // 종족명
    private int hp; // hp
    private int attack; // 공격
    private int block; // 방어
    private int contact; // 특공
    private int defense; // 특방
    private int speed; // 스피드

    private Species(String name, int hp, int attack, int block, int contact, int defense, int speed) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.block = block;
        this.contact = contact;
        this.defense = defense;
        this.speed = speed;
    }

    public String getName() {
        return name;
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
