package ivcal;

import resource.Nature;
import resource.Species;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

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
        button.setSize(100,30);
        button.addActionListener(e->{
            Map<String, String> args = getArgs(); // 입력값들을 리스트에 담는다.

            IvCalculator ivCal = IvCalculator.of(args);
            Map<String,String> results = ivCal.cal(); // TODO: 리스트의 인자들을 기반으로 결과출력문들의 리스트를 반환받는다.
            printResult(results); // TODO : 결과를 화면에 출력한다.
        });
        return button;
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
        inputPanel.setBounds(0,50,FRAME_WIDTH,400);
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



    //TODO : 화면에 결과를 출력하기(OutPut의 컴포넌트에 값 넘기기)
    private void printResult(Map<String,String> results) {

    }

    // 각 필드로부터 인자들을 읽어온다.
    private Map<String, String> getArgs() {
        Map<String,String> args = new HashMap<>();

        args.put("Species", speciesChoice.getSelectedItem());
        args.put("Level", levelField.getText());
        args.put("Nature", natureChoice.getSelectedItem());

        args.put("Hp Stat", hpStatField.getText());
        args.put("Attack Stat",attackStatField.getText());
        args.put("Block Stat",blockStatField.getText());
        args.put("Contact Stat",contactStatField.getText());
        args.put("Defense Stat",defenseStatField.getText());
        args.put("Speed Stat",speedStatField.getText());

        args.put("Hp Effort",hpEffortField.getText());
        args.put("Attack Effort", attackEffortField.getText());
        args.put("Block Effort", blockEffortField.getText());
        args.put("Contact Effort",contactEffortField.getText());
        args.put("Defense Effort",defenseEffortField.getText());
        args.put("Speed Effort",speedEffortField.getText());
        return args;
    }

    //TODO : 결과 출력창 생성 및 추가
    private void addOutputPanel() {

    }
}
