package ivcal;

import resource.Nature;
import resource.Species;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IvCalculator {

    // 상수
    private static final int IV_MIN = 0; // 개체값의 최솟값
    private static final int IV_MAX = 31; // 개체값의 최댓값

    private static final int LEVEL_MIN = 1; // 레벨의 최솟값
    private static final int LEVEL_MAX = 100; // 레벨의 최댓값

    private static final int EFFORT_MIN = 0; // 노력치의 최솟값
    private static final int EFFORT_MAX = 255; // 노력치의 최댓값
    private static final int EFFORT_SUM_MIN = 0; // 노력치 총합의 최솟값
    private static final int EFFORT_SUM_MAX = 510; // 노력치 총합의 최댓값

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

    // 인자로 받은 값들을 파싱하여 필드에 저장한다.
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

    // 결과를 계산하여 results에 문자열로 저장
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

        results.put("AttackScale", getStatScaleStr(nature.getAttackScale()));
        results.put("BlockScale", getStatScaleStr(nature.getBlockScale()));
        results.put("ContactScale", getStatScaleStr(nature.getContactScale()));
        results.put("DefenseScale", getStatScaleStr(nature.getDefenseScale()));
        results.put("SpeedScale", getStatScaleStr(nature.getSpeedScale()));

        results.put("ValidHpRange", getValidHpRangeStr());
        results.put("ValidAttackRange", getValidAttackRangeStr());
        results.put("ValidBlockRange", getValidBlockRangeStr());
        results.put("ValidContactRange", getValidContactRangeStr());
        results.put("ValidDefenseRange", getValidDefenseRangeStr());
        results.put("ValidSpeedRange", getValidSpeedRangeStr());

        this.results = results;
    }

    //statScale을 인자로 하여, 출력할 배율을 반환한다.
    private String getStatScaleStr(double statScale) {
        double upScale = 1.1;
        double downScale = 0.9;

        if (statScale==upScale) return "*"+upScale;
        if (statScale==downScale) return "*"+downScale;
        return "";
    }

    // HP 실수치 계산식
    private static int getRealHP(int level, int hpBaseStat, int iv, int hpEffort) {
        return (int) (((hpBaseStat * 2) + iv + (hpEffort/4)) * (level/100.0)) + 10 + level;
    }

    // hp 실수치의 최소유효값
    private int getValidHpMin() {
        return getRealHP(this.level, this.species.getHp(), IV_MIN, this.hpEffort);
    }

    // hp 실수치의 최대유효값
    private int getValidHpMax() {
        return getRealHP(this.level, this.species.getHp(), IV_MAX, this.hpEffort);
    }

    // hp 실수치의 유효값의 범위를 문자열(min~max)로 반환
    private String getValidHpRangeStr() {
        int validHpMin = getValidHpMin();
        int validHpMax = getValidHpMax();
        return validHpMin+"~"+validHpMax;
    }

    // HP를 제외한 스탯 실수치 계산
    private static int getRealStat(int level, int baseStat, int iv, int effort, double scale) {
        return (int)(((int)(((baseStat * 2) + iv + (effort/4)) * (level/100.0)) + 5 ) * scale);
    }

    // HP를 제외한 스탯 실수치의 최소유효값
    private int getValidStatMin(int baseStat, int effort, double scale) {
        return getRealStat(this.level, baseStat, IV_MIN, effort, scale);
    }

    // HP를 제외한 스탯 실수치의 최대유효값
    private int getValidStatMax(int baseStat, int effort, double scale) {
        return getRealStat(this.level, baseStat, IV_MAX, effort, scale);
    }

    // 공격 실수치의 유효값의 범위를 문자열(min~max)로 반환
    private String getValidAttackRangeStr() {
        int validAttackMin = getValidStatMin(this.species.getAttack(),this.attackEffort,this.nature.getAttackScale());
        int validAttackMax = getValidStatMax(this.species.getAttack(),this.attackEffort,this.nature.getAttackScale());
        return validAttackMin+"~"+validAttackMax;
    }

    // 방어 실수치의 유효값의 범위를 문자열(min~max)로 반환
    private String getValidBlockRangeStr() {
        int validBlockMin = getValidStatMin(this.species.getBlock(),this.blockEffort,this.nature.getBlockScale());
        int validBlockMax = getValidStatMax(this.species.getBlock(),this.blockEffort,this.nature.getBlockScale());
        return validBlockMin+"~"+validBlockMax;
    }

    // 특수공격 실수치의 유효값의 범위를 문자열(min~max)로 반환
    private String getValidContactRangeStr() {
        int validContactMin = getValidStatMin(this.species.getContact(),this.contactEffort,this.nature.getContactScale());
        int validContactMax = getValidStatMax(this.species.getContact(),this.contactEffort,this.nature.getContactScale());
        return validContactMin+"~"+validContactMax;
    }

    // 특수방어 실수치의 유효값의 범위를 문자열(min~max)로 반환
    private String getValidDefenseRangeStr() {
        int validDefenseMin = getValidStatMin(this.species.getDefense(),this.defenseEffort,this.nature.getDefenseScale());
        int validDefenseMax = getValidStatMax(this.species.getDefense(),this.defenseEffort,this.nature.getDefenseScale());
        return validDefenseMin+"~"+validDefenseMax;
    }

    // 스피드 실수치의 유효값의 범위를 문자열(min~max)로 반환
    private String getValidSpeedRangeStr() {
        int validSpeedMin = getValidStatMin(this.species.getSpeed(),this.speedEffort,this.nature.getSpeedScale());
        int validSpeedMax = getValidStatMax(this.species.getSpeed(),this.speedEffort,this.nature.getSpeedScale());
        return validSpeedMin+"~"+validSpeedMax;
    }

    // 결과 반환
    public Map<String,String> getResults() {
        return this.results;
    }

    // 예외 로그들 반환
    public List<String> getExceptionLogs() {
        return this.exceptionLogs;
    }

}