package ivcal;

import resource.Nature;
import resource.Species;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IvCalculator {

    // 상수
    private static final int MIN_IV = 0; // 개체값의 최솟값
    private static final int MAX_IV = 31; // 개체값의 최댓값

    private static final int LEVEL_MIN = 1; // 레벨의 최솟값
    private static final int LEVEL_MAX = 100; // 레벨의 최댓값

    private static final int EFFORT_MIN = 0; // 노력치의 최솟값
    private static final int EFFORT_MAX = 255; // 노력치의 최댓값
    private static final int EFFORT_SUM_MIN = 0;
    private static final int EFFORT_SUM_MAX = 510;

    private int level; // 레벨
    private Species species; // 종
    private Nature nature; // 성격

    private int hpStat, attackStat, blockStat, contactStat, defenseStat, speedStat; // 스탯 실수치
    private int hpEffort, attackEffort, blockEffort, contactEffort, defenseEffort, speedEffort; // 노력치

    private Map<String,String> results;
    private List<String> exceptionLogs = new ArrayList<>(); // 예외들

    private IvCalculator (Map<String, String> args) {
        init(args);
        effortSumValidation();
        calculate();
    }

    public static IvCalculator of(Map<String, String> args) {
        return new IvCalculator(args);
    }

    private void init(Map<String, String> args) {
        this.level = parseLevel(args.get("Level"));
        this.species = parseSpecies(args.get("Species"));
        this.nature = parseNature(args.get("Nature"));

        this.hpStat = parseStat(args.get("HpStat"));
        this.attackStat = parseStat(args.get("AttackStat"));
        this.blockStat = parseStat(args.get("BlockStat"));
        this.contactStat = parseStat(args.get("ContactStat"));
        this.defenseStat = parseStat(args.get("DefenseStat"));
        this.speedStat = parseStat(args.get("SpeedStat"));

        this.hpEffort = parseEffort(args.get("HpEffort"));
        this.attackEffort = parseEffort(args.get("AttackEffort"));
        this.blockEffort = parseEffort(args.get("BlockEffort"));
        this.contactEffort = parseEffort(args.get("ContactEffort"));
        this.defenseEffort = parseEffort(args.get("DefenseEffort"));
        this.speedEffort = parseEffort(args.get("SpeedEffort"));
    }


    // 입력 문자 레벨을 읽어와서, 이를 level 값으로 파싱
    private int parseLevel(String levelStr) {
        try {
            int parseLevel = Integer.parseInt(levelStr);
            levelValidation(parseLevel);
            return parseLevel;
        } catch(Exception e) {
            this.exceptionLogs.add(e.getMessage());
            return 0;
        }
    }

    // 레벨값의 유효성 검사. 유효하지 않으면 예외를 throw한다.
    private static void levelValidation(int parseLevel) {
        if (!(LEVEL_MIN<=parseLevel && parseLevel<=LEVEL_MAX)) throw new IllegalArgumentException("Level Range Error (Level Range : 1~100)");
    }

    // 입력 args로부터 Nature 문자열을 읽어와서, 이를 Species 객체로 파싱
    private static Species parseSpecies(String speciesStr) {
        Species species = Species.of(speciesStr);
        return species;
    }

    //입력 args로부터 Nature 문자열을 읽어와서, 이를 Nature 객체로 파싱
    private static Nature parseNature(String natureStr) {
        Nature nature = Nature.of(natureStr);
        return nature;
    }

    //스탯 실수치 입력값을 파싱한다. 숫자가 아닐 경우 0을 반환.
    private int parseStat(String statStr) {
        try {
            int parseStat = Integer.parseInt(statStr);
            return parseStat;
        } catch(Exception e) {
            this.exceptionLogs.add(e.getMessage());
            return 0;
        }
    }

    //노력치 입력값을 파싱한다. 숫자가 아니거나 유효값이 아닌 경우 0을 반환.
    private int parseEffort(String effortStr) {
        try {
            int parseEffort = Integer.parseInt(effortStr);
            effortValidation(parseEffort);
            return parseEffort;
        } catch(Exception e) {
            this.exceptionLogs.add(e.getMessage());
            return 0;
        }
    }

    // 노력치의 유효성검사
    private static void effortValidation(int parseEffort) {
        if (!(EFFORT_MIN<=parseEffort&&parseEffort<=EFFORT_MAX)) throw new IllegalArgumentException("Effort Range Error [Effort Range : 0~255]");
    }

    // 노력치 총합의 유효성 검사
    private void effortSumValidation() {
        int effortSum = hpEffort+attackEffort+blockEffort+contactEffort+defenseEffort+speedEffort;
        if(!(EFFORT_SUM_MIN<= effortSum && effortSum <=EFFORT_SUM_MAX)) {
            this.exceptionLogs.add("Effort Sum Range Error (Effort Sum Range : 0~510)");
        }
    }

    private void calculate() {
        Map<String,String> results = new HashMap<>();

        results.put("Level", String.valueOf(this.level));
        results.put("Species", this.species.getName());
        results.put("HpBaseStat", String.valueOf(this.species.getHp()));
        results.put("AttackBaseStat", String.valueOf(this.species.getAttack()));
        results.put("BlockBaseStat", String.valueOf(this.species.getBlock()));
        results.put("ContactBaseStat", String.valueOf(this.species.getContact()));
        results.put("DefenseBaseStat", String.valueOf(this.species.getDefense()));
        results.put("SpeedBaseStat", String.valueOf(this.species.getSpeed()));
        results.put("TotalBaseStat", String.valueOf(this.species.getTotalStat()));

        this.results = results;
    }

    // HP 실수치 계산식
    private static int getRealHP(int baseStat_Hp, int iv, int effortValue, int level) {
        return (baseStat_Hp*2 + iv + effortValue/4) * (level/100) + 10 + level;
    }

    // HP를 제외한 실수치 계산
    private static int getRealStat(int baseStat, int iv, int effortValue, int level, double scale) {
        return (int)(((baseStat*2 + iv + effortValue/4) * (level/100) + 5) * scale);
    }


    // 종족값, 노력치, 레벨을 읽어와, hp실수치의 예상 범위의 최소, 최대를 구하고 이를 List에 저장해 반환한다.
    private static List<Integer> predictHPRange (int baseStat_Hp, int effortValue, int level) {
        List<Integer> hps = new ArrayList<>();
        Integer minHP = getRealHP(baseStat_Hp, MIN_IV, effortValue, level);
        Integer maxHP = getRealHP(baseStat_Hp, MAX_IV, effortValue, level);
        hps.add(minHP);
        hps.add(maxHP);
        return hps;
    }

    // 종족값, 노력치, 레벨, 배율을 읽어와 stat 실수치의 예상범위의 최소, 최대를 구하고 이를 List에 저장해 반환한다.
    private static List<Integer> predictStatRange (int baseStat, int effortValue, int level, double scale) {
        List<Integer> stats = new ArrayList<>();
        Integer minStat = getRealStat(baseStat, MIN_IV, effortValue, level, scale);
        Integer maxStat = getRealStat(baseStat, MAX_IV, effortValue, level, scale);
        stats.add(minStat);
        stats.add(maxStat);
        return stats;
    }

    public Map<String,String> getResults() {
        return this.results;
    }

    public List<String> getExceptionLogs() {
        return this.exceptionLogs;
    }
}