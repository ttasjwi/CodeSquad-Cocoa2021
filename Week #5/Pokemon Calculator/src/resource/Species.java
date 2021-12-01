package resource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Species {

    private static final String DATA_SRC_DIR = "./src/resource/Species_Table.txt";

    private static final Map<String, Species> SPECIES_MAP = initSpeciesMap();

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

    //SPECIES_MAP을 초기화 : 소스파일을 읽어와서, 내용을 기반으로 SPECIES_MAP을 생성함.
    private static Map<String, Species> initSpeciesMap() {
        List<String> lines = fileToLines(DATA_SRC_DIR); // DATA_SRC을 읽어와서 라인단위 분리한다.

        Map<String, Species> speciesMap = new HashMap<>();
        for (String line : lines) {
            Species species = createSpecies(line); // 각 라인별 데이터를 기반으로 species 객체를 정의, 생성
            speciesMap.put(species.getName(), species); // 정의된 species마다 Map에 put
        }
        return speciesMap;
    }

    //파일를 읽어와서, 라인단위로 분리한다.
    private static List<String> fileToLines(String fileDir) {
        List<String> tableSplits = new ArrayList<>();

        try {
            final Path DATA_SRC = Paths.get(fileDir);
            Files.lines(DATA_SRC, Charset.defaultCharset())
                    .forEach(tableSplits::add);
        } catch(IOException ie) {
            System.out.println("데이터 가져오기 실패!");
        }
        return tableSplits;
    }

    //분리 문자열배열을 기반으로, Species 객체를 생성한다.
    private static Species createSpecies(String line) {
        String[] lineSplit = line.split("\t"); // 라인별로 '\t'단위로 문자열 분리한다.

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

    // 문자를 인자로하여, SPECIES_MAP에서 Species 객체를 찾아온다.
    public static Species of(String name) {
        return SPECIES_MAP.get(name);
    }

    // 모든 Speciese 객체명이 담긴 Set을 반환한다.
    public static Set<String> nameSet() {
        return SPECIES_MAP.keySet();
    }

    // 객체명 반환
    public String getName() {
        return name;
    }

    // HP 종족값 반환
    public int getHp() {
        return hp;
    }

    // 공격 종족값 반환
    public int getAttack() {
        return attack;
    }

    // 방어 종족값 반환
    public int getBlock() {
        return block;
    }

    // 특수공격 종족값 반환
    public int getContact() {
        return contact;
    }

    // 특수방어 종족값 반환
    public int getDefense() {
        return defense;
    }

    // 스피드 종족값 반환
    public int getSpeed() {
        return speed;
    }

    // 종족값 총합 반환
    public int getTotalStat() {
        return hp + attack + block + contact + defense + speed;
    }

}
