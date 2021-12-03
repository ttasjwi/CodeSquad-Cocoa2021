package ivcal;

import resource.Nature;
import resource.Species;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

class IvCalFrame extends Frame {
    private static final String TITLE = "IVCalculator";
    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 600;
    private static final Font LABEL_FONT = new Font("SanSerif",Font.BOLD, 15);
    private static final Font CHOICE_FONT = new Font("SanSerif", Font.PLAIN,15);
    private static final Color FRAME_COLOR = new Color(46,171,254);

    // 입력 필드
    private Choice speciesChoice = makeChoice(Species.nameSet()); // 종족
    private TextField levelField = new TextField("1",3); // 레벨
    private Choice natureChoice = makeChoice(Nature.nameSet()); // 성격

    private TextField hpStatField = new TextField("0", 3); // hp 실수치
    private TextField attackStatField = new TextField("0", 3); // 공격 실수치
    private TextField blockStatField = new TextField("0", 3); // 방어 실수치
    private TextField contactStatField = new TextField("0", 3); // 특수공격 실수치
    private TextField defenseStatField = new TextField("0", 3); // 특수방어 실수치
    private TextField speedStatField = new TextField("0", 3); // 스피드 실수치

    private TextField hpEffortField = new TextField("0", 3); // hp 노력치
    private TextField attackEffortField = new TextField("0", 3); // 공격 노력치
    private TextField blockEffortField = new TextField("0", 3); // 방어 노력치
    private TextField contactEffortField = new TextField("0", 3); // 특수공격 노력치
    private TextField defenseEffortField = new TextField("0", 3); // 특수방어 노력치
    private TextField speedEffortField = new TextField("0", 3); // 스피드 노력치

    private Button calButton = makeCalButton(); // 계산 명령 버튼

    private Label levelOutputLabel = makeLabel("1",40,30);
    private Label speciesOutputLabel = makeLabel("???", 250,30);

    private Label hpBaseStatOutputLabel = makeLabel(" ",100, 30);
    private Label attackBaseStatOutputLabel = makeLabel("",100, 30);
    private Label blockBaseStatOutputLabel = makeLabel("",100, 30);
    private Label contactBaseStatOutputLabel = makeLabel("",100, 30);
    private Label defenseBaseStatOutputLabel = makeLabel("",100, 30);
    private Label speedBaseStatOutputLabel = makeLabel("",100, 30);
    private Label totalBaseStatOutputLabel = makeLabel("",100, 30);

    private Label attackScaleOutputLabel = makeLabel("",100, 30);
    private Label blockScaleOutputLabel = makeLabel("",100, 30);
    private Label contactScaleOutputLabel = makeLabel("",100, 30);
    private Label defenseScaleOutputLabel = makeLabel("",100, 30);
    private Label speedScaleOutputLabel = makeLabel("",100, 30);

    private Label validHpRangeOutputLabel = makeLabel(" ",200, 30);
    private Label validAttackRangeOutputLabel = makeLabel("",200, 30);
    private Label validBlockRangeOutputLabel = makeLabel("",200, 30);
    private Label validContactRangeOutputLabel = makeLabel("",200, 30);
    private Label validDefenseRangeOutputLabel = makeLabel("",200, 30);
    private Label validSpeedRangeOutputLabel = makeLabel("",200, 30);

    private Label hpIVRangeOutputLabel = makeLabel(" ",200, 30);
    private Label attackIVRangeOutputLabel = makeLabel("",200, 30);
    private Label blockIVRangeOutputLabel = makeLabel("",200, 30);
    private Label contactIVRangeOutputLabel = makeLabel("",200, 30);
    private Label defenseIVRangeOutputLabel = makeLabel("",200, 30);
    private Label speedIVRangeOutputLabel = makeLabel("",200, 30);

    public IvCalFrame() {
        init();
    }

    // 지정 Collection<String>에서 item들을 긁어와, Choice에 저장해 반환
    private static Choice makeChoice(Collection<String> src) {
        Choice items = new Choice();
        src.stream()
                .sorted()
                .forEach(items::add);
        items.setSize(100,30);
        items.setFont(CHOICE_FONT);
        return items;
    }

    //버튼을 생성
    private Button makeCalButton() {
        Button button = new Button("Calculate");
        button.setSize(100, 30);
        button.addActionListener(e -> {
            Map<String, String> args = getArgs(); // 입력값들을 리스트에 담는다.

            IvCalculator ivCal = IvCalculator.of(args);
            Map<String, String> results = ivCal.getResults();
            List<Exception> exceptions = ivCal.getExceptions();

            printResult(results); // TODO : 결과를 화면에 출력한다.
            printExceptionLogs(exceptions);
        });
        return button;
    }

    private Label makeLabel(String text, int width, int height) {
        Label label = new Label(text, Label.CENTER);
        label.setSize(width, height);
        return label;
    }

    //창을 초기화
    private void init() {
        initFrame();
        addMarginTop(); // 상단 여백
        addInputPanel(); // TODO : 입력판넬 생성 및 추가
        addOutputPanel(); //TODO : 결과 출력창 생성 및 추가
    }

    //Frame 맞추기
    private void initFrame() {
        setTitle(TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setBackground(FRAME_COLOR);
        addWindowListener(new WindowAdapter() { // 마우스 클릭 시 창을 안 보이게 한다. -> 더 이상 이 창에 접근할 방법이 없어짐.
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
        setLayout(null);
        setResizable(false); // 창의 크기를 변경할 수 없게 한다.
    }

    // 상단 여백 추가
    private void addMarginTop() {
        Panel marginTop = new Panel();
        marginTop.setBounds(0,0,FRAME_WIDTH,50);
        add(marginTop);
    }

    // 입력 판넬 생성 및 추가
    private void addInputPanel() {
        Panel inputPanel = new Panel();
        inputPanel.setBounds(0,50,FRAME_WIDTH,190);
        inputPanel.setLayout(null);

        Panel inputTop = makeInputTop(); // 종족선택 라벨, 레벨입력 라벨, 성격선택 라벨이 있는 곳
        inputPanel.add(inputTop);

        Panel inputLine1 = makeInputLine1(); // 종족선택 Choice, 레벨입력필드, 성격선택 Choice가 있는 곳
        inputPanel.add(inputLine1);

        Panel inputLine2 = makeInputLine2(); // hp, 공격, 방어, 특공, 특방, 스피드 라벨이 소속된 판넬
        inputPanel.add(inputLine2);

        Panel inputLine3 = makeInputLine3(); // hp, 공격, 방어, 특공, 특방, 스피드 실수치 입력부
        inputPanel.add(inputLine3);

        Panel inputLine4 = makeInputLine4(); // hp, 공격, 방어 ,특공, 특방, 스피드 노력치 입력부
        inputPanel.add(inputLine4);

        Panel buttonPanel = makeButtonPanel(); // 버튼이 속한 판넬
        inputPanel.add(buttonPanel);

        add(inputPanel);
    }

    private static Panel makeInputTop() {
        Panel inputTop = new Panel();
        inputTop.setBounds(0,0,FRAME_WIDTH,30);
        inputTop.setLayout(null);

        // 종 라벨
        Label speciesLabel = new Label("Pokemon : ");
        speciesLabel.setBounds(0,0,300,inputTop.getHeight());
        speciesLabel.setFont(LABEL_FONT);
        speciesLabel.setAlignment(Label.CENTER);
        inputTop.add(speciesLabel);

        // 레벨 라벨
        Label levelLabel = new Label("Level : ");
        levelLabel.setBounds(300,0,200,inputTop.getHeight());
        levelLabel.setFont(LABEL_FONT);
        levelLabel.setAlignment(Label.CENTER);
        inputTop.add(levelLabel);

        // 성격 라벨
        Label natureLabel = new Label("Nature : ");
        natureLabel.setBounds(500,0,200,inputTop.getHeight());
        natureLabel.setFont(LABEL_FONT);
        natureLabel.setAlignment(Label.CENTER);
        inputTop.add(natureLabel);
        return inputTop;
    }

    // 종족선택, 레벨입력, 성격선택 필드가 있는 곳
    private Panel makeInputLine1() {
        Panel inputLine1 = new Panel();
        inputLine1.setBounds(0,30,FRAME_WIDTH,35);
        inputLine1.setLayout(null);

        Panel speciesChoicePanel = new Panel();
        speciesChoicePanel.setBounds(0,0,300,inputLine1.getHeight());
        speciesChoicePanel.setLayout(new FlowLayout());
        speciesChoicePanel.add(this.speciesChoice);
        inputLine1.add(speciesChoicePanel);

        Panel levelInputFieldPanel = new Panel();
        levelInputFieldPanel.setBounds(300,0,200, inputLine1.getHeight());
        levelInputFieldPanel.setLayout(new FlowLayout());
        levelInputFieldPanel.add(this.levelField);
        inputLine1.add(levelInputFieldPanel);

        Panel natureChoicePanel = new Panel();
        natureChoicePanel.setBounds(500,0,200, inputLine1.getHeight());
        natureChoicePanel.setLayout(new FlowLayout());
        natureChoicePanel.add(this.natureChoice);
        inputLine1.add(natureChoicePanel);

        return inputLine1;
    }

    // hp, 공격, 방어, 특공, 특방, 스피드 라벨이 소속된 판넬
    private Panel makeInputLine2() {
        Panel inputLine2 = new Panel();
        inputLine2.setBounds(0,65,FRAME_WIDTH,30);
        inputLine2.setLayout(null);

        Label hpStatLabel = new Label("HP");
        hpStatLabel.setFont(LABEL_FONT);
        hpStatLabel.setBounds(100,0,100,inputLine2.getHeight());
        hpStatLabel.setAlignment(Label.CENTER);
        inputLine2.add(hpStatLabel);

        Label attackStatLabel = new Label("Attack");
        attackStatLabel.setFont(LABEL_FONT);
        attackStatLabel.setBounds(200,0,100,inputLine2.getHeight());
        attackStatLabel.setAlignment(Label.CENTER);
        inputLine2.add(attackStatLabel);

        Label blockStatLabel = new Label("Block");
        blockStatLabel.setFont(LABEL_FONT);
        blockStatLabel.setBounds(300,0,100,inputLine2.getHeight());
        blockStatLabel.setAlignment(Label.CENTER);
        inputLine2.add(blockStatLabel);

        Label contactStatLabel = new Label("Contact");
        contactStatLabel.setFont(LABEL_FONT);
        contactStatLabel.setBounds(400,0,100,inputLine2.getHeight());
        contactStatLabel.setAlignment(Label.CENTER);
        inputLine2.add(contactStatLabel);

        Label defenseStatLabel = new Label("Defense");
        defenseStatLabel.setFont(LABEL_FONT);
        defenseStatLabel.setBounds(500,0,100,inputLine2.getHeight());
        defenseStatLabel.setAlignment(Label.CENTER);
        inputLine2.add(defenseStatLabel);

        Label speedStatLabel = new Label("Speed");
        speedStatLabel.setFont(LABEL_FONT);
        speedStatLabel.setBounds(600,0,100,inputLine2.getHeight());
        speedStatLabel.setAlignment(Label.CENTER);
        inputLine2.add(speedStatLabel);

        return inputLine2;
    }

    // hp, 공격, 방어, 특공, 특방, 스피드 실수치 입력부
    private Panel makeInputLine3() {
        Panel inputLine3 = new Panel();
        inputLine3.setBounds(0,95,FRAME_WIDTH,30);
        inputLine3.setLayout(null);

        Label statInputLabel = new Label("Stats : ");
        statInputLabel.setFont(LABEL_FONT);
        statInputLabel.setBounds(0,0,100,inputLine3.getHeight());
        statInputLabel.setAlignment(Label.CENTER);
        inputLine3.add(statInputLabel);

        Panel hpStatInputPanel = new Panel();
        hpStatInputPanel.setBounds(100,0,100,inputLine3.getHeight());
        hpStatInputPanel.setLayout(new FlowLayout());
        hpStatInputPanel.add(this.hpStatField);
        inputLine3.add(hpStatInputPanel);

        Panel attackStatInputPanel = new Panel();
        attackStatInputPanel.setBounds(200,0,100,inputLine3.getHeight());
        attackStatInputPanel.setLayout(new FlowLayout());
        attackStatInputPanel.add(this.attackStatField);
        inputLine3.add(attackStatInputPanel);

        Panel blockStatInputPanel = new Panel();
        blockStatInputPanel.setBounds(300,0,100,inputLine3.getHeight());
        blockStatInputPanel.setLayout(new FlowLayout());
        blockStatInputPanel.add(this.blockStatField);
        inputLine3.add(blockStatInputPanel);

        Panel contactStatInputPanel = new Panel();
        contactStatInputPanel.setBounds(400,0,100,inputLine3.getHeight());
        contactStatInputPanel.setLayout(new FlowLayout());
        contactStatInputPanel.add(this.contactStatField);
        inputLine3.add(contactStatInputPanel);

        Panel defenseStatInputPanel = new Panel();
        defenseStatInputPanel.setBounds(500,0,100,inputLine3.getHeight());
        defenseStatInputPanel.setLayout(new FlowLayout());
        defenseStatInputPanel.add(this.defenseStatField);
        inputLine3.add(defenseStatInputPanel);

        Panel speedStatInputPanel = new Panel();
        speedStatInputPanel.setBounds(600,0,100,inputLine3.getHeight());
        speedStatInputPanel.setLayout(new FlowLayout());
        speedStatInputPanel.add(this.speedStatField);
        inputLine3.add(speedStatInputPanel);

        return inputLine3;
    }

    // hp, 공격, 방어 ,특공, 특방, 스피드 노력치 입력부
    private Panel makeInputLine4() {
        Panel inputLine4 = new Panel();
        inputLine4.setBounds(0,125,FRAME_WIDTH,30);
        inputLine4.setLayout(null);

        Label effortInputLabel = new Label("Efforts : ");
        effortInputLabel.setFont(LABEL_FONT);
        effortInputLabel.setBounds(0,0,100,inputLine4.getHeight());
        effortInputLabel.setAlignment(Label.CENTER);
        inputLine4.add(effortInputLabel);

        Panel hpEffortInputPanel = new Panel();
        hpEffortInputPanel.setBounds(100,0,100,inputLine4.getHeight());
        hpEffortInputPanel.setLayout(new FlowLayout());
        hpEffortInputPanel.add(this.hpEffortField);
        inputLine4.add(hpEffortInputPanel);

        Panel attackEffortInputPanel = new Panel();
        attackEffortInputPanel.setBounds(200,0,100,inputLine4.getHeight());
        attackEffortInputPanel.setLayout(new FlowLayout());
        attackEffortInputPanel.add(this.attackEffortField);
        inputLine4.add(attackEffortInputPanel);

        Panel blockEffortInputPanel = new Panel();
        blockEffortInputPanel.setBounds(300,0,100,inputLine4.getHeight());
        blockEffortInputPanel.setLayout(new FlowLayout());
        blockEffortInputPanel.add(this.blockEffortField);
        inputLine4.add(blockEffortInputPanel);

        Panel contactEffortInputPanel = new Panel();
        contactEffortInputPanel.setBounds(400,0,100,inputLine4.getHeight());
        contactEffortInputPanel.setLayout(new FlowLayout());
        contactEffortInputPanel.add(this.contactEffortField);
        inputLine4.add(contactEffortInputPanel);

        Panel defenseEffortInputPanel = new Panel();
        defenseEffortInputPanel.setBounds(500,0,100,inputLine4.getHeight());
        defenseEffortInputPanel.setLayout(new FlowLayout());
        defenseEffortInputPanel.add(this.defenseEffortField);
        inputLine4.add(defenseEffortInputPanel);

        Panel speedEffortInputPanel = new Panel();
        speedEffortInputPanel.setBounds(600,0,100,inputLine4.getHeight());
        speedEffortInputPanel.setLayout(new FlowLayout());
        speedEffortInputPanel.add(this.speedEffortField);
        inputLine4.add(speedEffortInputPanel);

        return inputLine4;
    }

    // 버튼이 속한 판넬
    private Panel makeButtonPanel() {
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBounds(0,155,FRAME_WIDTH,35);
        buttonPanel.add(this.calButton);
        return buttonPanel;
    }



    // 각 필드로부터 인자들을 읽어온다.
    private Map<String, String> getArgs() {
        Map<String,String> args = new HashMap<>();

        args.put("Species", speciesChoice.getSelectedItem());
        args.put("Level", levelField.getText());
        args.put("Nature", natureChoice.getSelectedItem());

        args.put("HpStat", hpStatField.getText());
        args.put("AttackStat",attackStatField.getText());
        args.put("BlockStat",blockStatField.getText());
        args.put("ContactStat",contactStatField.getText());
        args.put("DefenseStat",defenseStatField.getText());
        args.put("SpeedStat",speedStatField.getText());

        args.put("HpEffort",hpEffortField.getText());
        args.put("AttackEffort", attackEffortField.getText());
        args.put("BlockEffort", blockEffortField.getText());
        args.put("ContactEffort",contactEffortField.getText());
        args.put("DefenseEffort",defenseEffortField.getText());
        args.put("SpeedEffort",speedEffortField.getText());
        return args;
    }

    //TODO : 결과 출력창 생성 및 추가
    private void addOutputPanel() {
        Panel outPutPanel = new Panel();
        outPutPanel.setBounds(0,240,FRAME_WIDTH,300);
        outPutPanel.setLayout(null);

        //TODO : 출력부1 : 레벨 및 종족 출력부
        Panel outputTop = makeOutputTop();
        outPutPanel.add(outputTop);

        //TODO : 출력부2 : 라벨(종족값 라벨, 범위, 가능 범위)
        Panel outputLine1 = makeOutputLine1();
        outPutPanel.add(outputLine1);

        //TODO : 출력부3 :  HP
        Panel outputLine2 = makeOutputLine2();
        outPutPanel.add(outputLine2);

        //TODO : 출력부4 : 공격
        Panel outputLine3 = makeOutputLine3();
        outPutPanel.add(outputLine3);

        //TODO : 출력부5 : 방어
        Panel outputLine4 = makeOutputLine4();
        outPutPanel.add(outputLine4);

        //TODO : 출력부6 : 특수공격
        Panel outputLine5 = makeOutputLine5();
        outPutPanel.add(outputLine5);

        //TODO : 출력부7 : 특수방어
        Panel outputLine6 = makeOutputLine6();
        outPutPanel.add(outputLine6);

        //TODO : 출력부8 : 스피드
        Panel outputLine7 = makeOutputLine7();
        outPutPanel.add(outputLine7);

        //TODO : 출력부9 : 종족값 총합
        Panel outputLine8 = makeOutputLine8();
        outPutPanel.add(outputLine8);

        add(outPutPanel);
    }

    //출력부 최상단 : 레벨, 종족 출력
    private Panel makeOutputTop() {
        Panel outPutTop = new Panel();
        outPutTop.setBounds(0,0,FRAME_WIDTH, 30);
        outPutTop.setLayout(null);

        Label levelTextLabel = makeLabel("Level", 45, outPutTop.getHeight());
        levelTextLabel.setLocation(230,0);
        levelTextLabel.setAlignment(Label.LEFT);
        levelTextLabel.setFont(LABEL_FONT);

        outPutTop.add(levelTextLabel);

        Label levelOutputLabel = this.levelOutputLabel;
        levelOutputLabel.setLocation(280,0);
        levelOutputLabel.setAlignment(Label.LEFT);
        levelOutputLabel.setFont(LABEL_FONT);
        outPutTop.add(levelOutputLabel);

        Label speciesOutputLabel = this.speciesOutputLabel;
        speciesOutputLabel.setLocation(320,0);
        speciesOutputLabel.setAlignment(Label.LEFT);
        speciesOutputLabel.setFont(LABEL_FONT);
        outPutTop.add(speciesOutputLabel);

       return outPutTop;
    }

    private Panel makeOutputLine1() {
        Panel outputLine1 = new Panel();
        outputLine1.setBounds(0,30,FRAME_WIDTH,30);
        outputLine1.setLayout(null);

        Label baseStatsLabel = new Label("BaseStats");
        baseStatsLabel.setFont(LABEL_FONT);
        baseStatsLabel.setBounds(100,0,100,outputLine1.getHeight());
        baseStatsLabel.setAlignment(Label.CENTER);
        outputLine1.add(baseStatsLabel);


        Label statScaleLabel = new Label("Stat Scale");
        statScaleLabel.setFont(LABEL_FONT);
        statScaleLabel.setBounds(200,0,100,outputLine1.getHeight());
        statScaleLabel.setAlignment(Label.CENTER);
        outputLine1.add(statScaleLabel);

        Label statRangeLabel = new Label("Valid Stat Range");
        statRangeLabel.setFont(LABEL_FONT);
        statRangeLabel.setBounds(300,0,200,outputLine1.getHeight());
        statRangeLabel.setAlignment(Label.CENTER);
        outputLine1.add(statRangeLabel);

        Label ivRangeLabel = new Label("Possible IV Range");
        ivRangeLabel.setFont(LABEL_FONT);
        ivRangeLabel.setBounds(500,0,200,outputLine1.getHeight());
        ivRangeLabel.setAlignment(Label.CENTER);
        outputLine1.add(ivRangeLabel);

        return outputLine1;
    }

    // hp 라인
    private Panel makeOutputLine2() {
        Panel outputLine2 = new Panel();
        outputLine2.setBounds(0,60,FRAME_WIDTH,30);
        outputLine2.setLayout(null);

        Label hpOutputLabel = new Label("Hp");
        hpOutputLabel.setFont(LABEL_FONT);
        hpOutputLabel.setBounds(0,0,100,outputLine2.getHeight());
        hpOutputLabel.setAlignment(Label.CENTER);
        outputLine2.add(hpOutputLabel);

        Label hpBaseStatOutputLabel = this.hpBaseStatOutputLabel;
        hpBaseStatOutputLabel.setLocation(100,0);
        outputLine2.add(hpBaseStatOutputLabel);

        Label validHpRangeOutputLabel = this.validHpRangeOutputLabel;
        validHpRangeOutputLabel.setLocation(300,0);
        outputLine2.add(validHpRangeOutputLabel);

        Label hpIVRangeOutputLabel = this.hpIVRangeOutputLabel;
        hpIVRangeOutputLabel.setLocation(500,0);
        outputLine2.add(hpIVRangeOutputLabel);

        return outputLine2;
    }

    // Attack 라인
    private Panel makeOutputLine3() {
        Panel outputLine3 = new Panel();
        outputLine3.setBounds(0,90,FRAME_WIDTH,30);
        outputLine3.setLayout(null);

        Label attackOutputLabel = new Label("Attack");
        attackOutputLabel.setFont(LABEL_FONT);
        attackOutputLabel.setBounds(0,0,100,outputLine3.getHeight());
        attackOutputLabel.setAlignment(Label.CENTER);
        outputLine3.add(attackOutputLabel);

        Label attackBaseStatOutputLabel = this.attackBaseStatOutputLabel;
        attackBaseStatOutputLabel.setLocation(100,0);
        outputLine3.add(attackBaseStatOutputLabel);

        Label attackScaleOutputLabel = this.attackScaleOutputLabel;
        attackScaleOutputLabel.setLocation(200,0);
        outputLine3.add(attackScaleOutputLabel);

        Label validAttackRangeOutputLabel = this.validAttackRangeOutputLabel;
        validAttackRangeOutputLabel.setLocation(300,0);
        outputLine3.add(validAttackRangeOutputLabel);

        Label attackIVRangeOutputLabel = this.attackIVRangeOutputLabel;
        attackIVRangeOutputLabel.setLocation(500,0);
        outputLine3.add(attackIVRangeOutputLabel);

        return outputLine3;
    }

    // Block 라인
    private Panel makeOutputLine4() {
        Panel outputLine4 = new Panel();
        outputLine4.setBounds(0,120,FRAME_WIDTH,30);
        outputLine4.setLayout(null);

        Label blockOutputLabel = new Label("Block");
        blockOutputLabel.setFont(LABEL_FONT);
        blockOutputLabel.setBounds(0,0,100,outputLine4.getHeight());
        blockOutputLabel.setAlignment(Label.CENTER);
        outputLine4.add(blockOutputLabel);

        Label blockBaseStatOutputLabel = this.blockBaseStatOutputLabel;
        blockBaseStatOutputLabel.setLocation(100,0);
        outputLine4.add(blockBaseStatOutputLabel);

        Label blockScaleOutputLabel = this.blockScaleOutputLabel;
        blockScaleOutputLabel.setLocation(200,0);
        outputLine4.add(blockScaleOutputLabel);

        Label validBlockRangeOutputLabel = this.validBlockRangeOutputLabel;
        validBlockRangeOutputLabel.setLocation(300,0);
        outputLine4.add(validBlockRangeOutputLabel);

        Label blockIVRangeOutputLabel = this.blockIVRangeOutputLabel;
        blockIVRangeOutputLabel.setLocation(500,0);
        outputLine4.add(blockIVRangeOutputLabel);

        return outputLine4;
    }

    // Contact 라인
    private Panel makeOutputLine5() {
        Panel outputLine5 = new Panel();
        outputLine5.setBounds(0,150,FRAME_WIDTH,30);
        outputLine5.setLayout(null);

        Label contactOutputLabel = new Label("Contact");
        contactOutputLabel.setFont(LABEL_FONT);
        contactOutputLabel.setBounds(0,0,100,outputLine5.getHeight());
        contactOutputLabel.setAlignment(Label.CENTER);
        outputLine5.add(contactOutputLabel);

        Label contactBaseStatOutputLabel = this.contactBaseStatOutputLabel;
        contactBaseStatOutputLabel.setLocation(100,0);
        outputLine5.add(contactBaseStatOutputLabel);

        Label contactScaleOutputLabel = this.contactScaleOutputLabel;
        contactScaleOutputLabel.setLocation(200,0);
        outputLine5.add(contactScaleOutputLabel);

        Label validContactRangeOutputLabel = this.validContactRangeOutputLabel;
        validContactRangeOutputLabel.setLocation(300,0);
        outputLine5.add(validContactRangeOutputLabel);

        Label contactIVRangeOutputLabel = this.contactIVRangeOutputLabel;
        contactIVRangeOutputLabel.setLocation(500,0);
        outputLine5.add(contactIVRangeOutputLabel);

        return outputLine5;
    }

    //Defense 라인
    private Panel makeOutputLine6() {
        Panel outputLine6 = new Panel();
        outputLine6.setBounds(0,180,FRAME_WIDTH,30);
        outputLine6.setLayout(null);

        Label defenseOutputLabel = new Label("Defense");
        defenseOutputLabel.setFont(LABEL_FONT);
        defenseOutputLabel.setBounds(0,0,100,outputLine6.getHeight());
        defenseOutputLabel.setAlignment(Label.CENTER);
        outputLine6.add(defenseOutputLabel);

        Label defenseBaseStatOutputLabel = this.defenseBaseStatOutputLabel;
        defenseBaseStatOutputLabel.setLocation(100,0);
        outputLine6.add(defenseBaseStatOutputLabel);

        Label defenseScaleOutputLabel = this.defenseScaleOutputLabel;
        defenseScaleOutputLabel.setLocation(200,0);
        outputLine6.add(defenseScaleOutputLabel);

        Label validDefenseRangeOutputLabel = this.validDefenseRangeOutputLabel;
        validDefenseRangeOutputLabel.setLocation(300,0);
        outputLine6.add(validDefenseRangeOutputLabel);

        Label defenseIVRangeOutputLabel = this.defenseIVRangeOutputLabel;
        defenseIVRangeOutputLabel.setLocation(500,0);
        outputLine6.add(defenseIVRangeOutputLabel);

        return outputLine6;
    }

    //Speed 라인
    private Panel makeOutputLine7() {
        Panel outputLine7 = new Panel();
        outputLine7.setBounds(0,210,FRAME_WIDTH,30);
        outputLine7.setLayout(null);

        Label speedOutputLabel = new Label("Speed");
        speedOutputLabel.setFont(LABEL_FONT);
        speedOutputLabel.setBounds(0,0,100,outputLine7.getHeight());
        speedOutputLabel.setAlignment(Label.CENTER);
        outputLine7.add(speedOutputLabel);

        Label speedBaseStatOutputLabel = this.speedBaseStatOutputLabel;
        speedBaseStatOutputLabel.setLocation(100,0);
        outputLine7.add(speedBaseStatOutputLabel);

        Label speedScaleOutputLabel = this.speedScaleOutputLabel;
        speedScaleOutputLabel.setLocation(200,0);
        outputLine7.add(speedScaleOutputLabel);

        Label validSpeedRangeOutputLabel = this.validSpeedRangeOutputLabel;
        validSpeedRangeOutputLabel.setLocation(300,0);
        outputLine7.add(validSpeedRangeOutputLabel);

        Label speedIVRangeOutputLabel = this.speedIVRangeOutputLabel;
        speedIVRangeOutputLabel.setLocation(500,0);
        outputLine7.add(speedIVRangeOutputLabel);

        return outputLine7;
    }

    //Total 라인
    private Panel makeOutputLine8() {
        Panel outputLine8 = new Panel();
        outputLine8.setBounds(0,240,FRAME_WIDTH,30);
        outputLine8.setLayout(null);

        Label totalOutputLabel = new Label("Total");
        totalOutputLabel.setFont(LABEL_FONT);
        totalOutputLabel.setBounds(0,0,100,outputLine8.getHeight());
        totalOutputLabel.setAlignment(Label.CENTER);
        outputLine8.add(totalOutputLabel);

        Label totalBaseStatOutputLabel = this.totalBaseStatOutputLabel;
        totalBaseStatOutputLabel.setLocation(100,0);
        outputLine8.add(totalBaseStatOutputLabel);

        return outputLine8;
    }

    //TODO : 화면에 결과를 출력하기(OutPut의 컴포넌트에 값 넘기기)
    private void printResult(Map<String,String> results) {
        this.levelOutputLabel.setText(results.get("Level"));
        this.speciesOutputLabel.setText(results.get("Species"));
        this.hpBaseStatOutputLabel.setText(results.get("HpBaseStat"));
        this.attackBaseStatOutputLabel.setText(results.get("AttackBaseStat"));
        this.blockBaseStatOutputLabel.setText(results.get("BlockBaseStat"));
        this.contactBaseStatOutputLabel.setText(results.get("ContactBaseStat"));
        this.defenseBaseStatOutputLabel.setText(results.get("ContactBaseStat"));
        this.speedBaseStatOutputLabel.setText(results.get("ContactBaseStat"));
        this.totalBaseStatOutputLabel.setText(results.get("TotalBaseStat"));

        this.attackScaleOutputLabel.setText(results.get("AttackScale"));
        this.blockScaleOutputLabel.setText(results.get("BlockScale"));
        this.contactScaleOutputLabel.setText(results.get("ContactScale"));
        this.defenseScaleOutputLabel.setText(results.get("DefenseScale"));
        this.speedScaleOutputLabel.setText(results.get("SpeedScale"));

        this.validHpRangeOutputLabel.setText(results.get("ValidHpRange"));
        this.validAttackRangeOutputLabel.setText(results.get("ValidAttackRange"));
        this.validBlockRangeOutputLabel.setText(results.get("ValidBlockRange"));
        this.validContactRangeOutputLabel.setText(results.get("ValidContactRange"));
        this.validDefenseRangeOutputLabel.setText(results.get("ValidDefenseRange"));
        this.validSpeedRangeOutputLabel.setText(results.get("ValidSpeedRange"));

        this.hpIVRangeOutputLabel.setText(results.get("HpIVRange"));
        this.attackIVRangeOutputLabel.setText(results.get("AttackIVRange"));
        this.blockIVRangeOutputLabel.setText(results.get("BlockIVRange"));
        this.contactIVRangeOutputLabel.setText(results.get("ContactIVRange"));
        this.defenseIVRangeOutputLabel.setText(results.get("DefenseIVRange"));
        this.speedIVRangeOutputLabel.setText(results.get("SpeedIVRange"));
    }

    private void printExceptionLogs(List<Exception> exceptions) {
        for(Exception e : exceptions) {
            System.out.println(e.getMessage());
        }
    }
}