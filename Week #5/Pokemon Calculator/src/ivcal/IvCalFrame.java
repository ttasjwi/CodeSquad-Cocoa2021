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
    private static final int WIDTH = 700;
    private static final int HEIGHT = 600;

    // 입력 필드
    private Choice speciesChoice = getItems(Species.nameSet()); // 종족
    private TextField levelField = new TextField("1",3); // 레벨
    private Choice natureChoice = getItems(Nature.nameSet()); // 성격

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

    private void init() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowAdapter() { // 마우스 클릭 시 창을 안 보이게 한다. -> 더 이상 이 창에 접근할 방법이 없어짐.
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
        setResizable(false); // 창의 크기를 변경할 수 없게 한다.

        add(speciesChoice);
        add(levelField);
        add(natureChoice);
        add(natureChoice);

        add(hpStatField);
        add(attackStatField);
        add(blockStatField);
        add(contactStatField);
        add(defenseStatField);
        add(speedStatField);
        add(calButton);
    }

    // 지정 Collection<String>에서 item들을 긁어와, Choice에 저장해 반환
    private static Choice getItems(Collection<String> src) {
        Choice items = new Choice();
        src.stream()
                .sorted()
                .forEach(items::add);
        return items;
    }

    //버튼을 생성
    private Button makeCalButton() {
        Button button = new Button("Calculate");
        button.addActionListener(e->{
            Map<String, String> args = getArgs(); // 입력값들을 리스트에 담는다.

            IvCalculator ivCal = IvCalculator.of(args);
            Map<String,String> results = ivCal.cal(); // TODO: 리스트의 인자들을 기반으로 결과출력문들의 리스트를 반환받는다.
            printResult(results); // TODO : 결과를 화면에 출력한다.
        });
        return button;
    }

    private void printResult(Map<String,String> results) {
        //TODO : 화면에 결과를 출력하기
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

}
