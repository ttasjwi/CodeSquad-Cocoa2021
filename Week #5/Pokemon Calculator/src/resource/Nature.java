package resource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Nature {

    private static final Map<String, Nature> NATURE_MAP = initNatureMap();

    //NATURE_MAP을 초기화한다.
    private static Map<String,Nature> initNatureMap() {
        List<String> lines = inputDataSrc();
        HashMap<String, Nature> natureMap = new HashMap<>();
        for (String line : lines) {
            Nature nature = createNature(line);
            natureMap.put(nature.getNatureName(), nature);
        }
        return natureMap;
    }

    //경로로부터 Nature 테이블 데이터를 가져온다.
    private static List<String> inputDataSrc() {
        List<String> lines = new ArrayList<>();
        final Path DATA_SRC = Paths.get("./src/resource/Nature_Table.txt");
        try {
            Files.lines(DATA_SRC, Charset.defaultCharset()).forEach(lines::add);
        } catch(IOException ie) {
            System.out.println("성격데이터 로딩 실패!");
        }
        return lines;
    }

    // 읽은 라인으로부터 성격 데이터를 생성한다.
    private static Nature createNature(String line) {
        String[] lineSplit = line.split("\t");

        String natureName = lineSplit[0];
        double scale_Attack = Double.parseDouble(lineSplit[1]);
        double scale_Block = Double.parseDouble(lineSplit[2]);
        double scale_Contact = Double.parseDouble(lineSplit[3]);
        double scale_Defense = Double.parseDouble(lineSplit[4]);
        double scale_Speed = Double.parseDouble(lineSplit[5]);

        return new Nature(natureName, scale_Attack, scale_Block, scale_Contact, scale_Defense, scale_Speed);
    }

    private String natureName; // 성격명
    private double attackScale; // 공격 배율
    private double blockScale; // 방어 배율
    private double contactScale; // 특수공격 배율
    private double defenseScale; // 특수방어 배율
    private double speedScale; // 스피드 배율

    private Nature(String natureName, double attackScale, double blockScale, double contactScale, double defenseScale, double speedScale) {
        this.natureName = natureName;
        this.attackScale = attackScale;
        this.blockScale = blockScale;
        this.contactScale = contactScale;
        this.defenseScale = defenseScale;
        this.speedScale = speedScale;
    }

    public static Nature of(String natureName) {
        return NATURE_MAP.get(natureName);
    }

    public static Set<String> nameSet() {
        return NATURE_MAP.keySet();
    }

    public String getNatureName() {
        return natureName;
    }

    public double getAttackScale() {
        return attackScale;
    }

    public double getBlockScale() {
        return blockScale;
    }

    public double getContactScale() {
        return contactScale;
    }

    public double getDefenseScale() {
        return defenseScale;
    }

    public double getSpeedScale() {
        return speedScale;
    }

    public static void main(String[] args) {
    }
}
