package resource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Nature {

    // NATURE_MAP의 데이터 소스 경로
    private static final String DATA_SRC_DIR = "./src/resource/Nature_Table.txt";

    // 모든 성격데이터 Map
    private static final Map<String, Nature> NATURE_MAP = initNatureMap();

    private String natureName; // 성격명
    private double attackScale; // 공격 배율
    private double blockScale; // 방어 배율
    private double contactScale; // 특수공격 배율
    private double defenseScale; // 특수방어 배율
    private double speedScale; // 스피드 배율

    // 성격 생성자
    private Nature(String natureName, double attackScale, double blockScale, double contactScale, double defenseScale, double speedScale) {
        this.natureName = natureName;
        this.attackScale = attackScale;
        this.blockScale = blockScale;
        this.contactScale = contactScale;
        this.defenseScale = defenseScale;
        this.speedScale = speedScale;
    }

    //NATURE_MAP을 초기화 : 소스파일을 읽어와서, 내용을 기반으로 NATURE_MAP을 생성함.
    private static Map<String,Nature> initNatureMap() {
        List<String> lines = fileToLines(DATA_SRC_DIR);

        Map<String, Nature> natureMap = new HashMap<>();
        for (String line : lines) {
            Nature nature = createNature(line);
            natureMap.put(nature.getNatureName(), nature);
        }
        return natureMap;
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

    // 읽은 라인으로부터 성격 데이터를 생성한다.
    private static Nature createNature(String line) {
        String[] lineSplit = line.split("\t"); // 라인을 '\t'로 분리

        String natureName = lineSplit[0];
        double attackScale = Double.parseDouble(lineSplit[1]);
        double blockScale = Double.parseDouble(lineSplit[2]);
        double contactScale = Double.parseDouble(lineSplit[3]);
        double defenseScale = Double.parseDouble(lineSplit[4]);
        double speedScale = Double.parseDouble(lineSplit[5]);

        return new Nature(natureName, attackScale, blockScale, contactScale, defenseScale, speedScale);
    }

    // 성격 문자열을 인자로 하여, NATURE_MAP에서 Nature 객체를 찾아온다.
    public static Nature of(String natureName) {
        return NATURE_MAP.get(natureName);
    }

    // 모든 Nature 객체명이 담긴 Set을 반환한다.
    public static Set<String> nameSet() {
        return NATURE_MAP.keySet();
    }

    // 성격명 반환
    public String getNatureName() {
        return natureName;
    }

    // 공격 배율 반환
    public double getAttackScale() {
        return attackScale;
    }

    // 방어 배율 반환
    public double getBlockScale() {
        return blockScale;
    }

    // 특수공격 배율 반환
    public double getContactScale() {
        return contactScale;
    }

    // 특수방어 배율 반환
    public double getDefenseScale() {
        return defenseScale;
    }

    // 스피드 배율 반환
    public double getSpeedScale() {
        return speedScale;
    }

}
