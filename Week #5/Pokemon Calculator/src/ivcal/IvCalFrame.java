package ivcal;

import resource.Nature;
import resource.Species;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Collection;

class IvCalFrame extends Frame {
    private static final String TITLE = "IVCalculator";
    private static final int WIDTH = 700;
    private static final int HEIGHT = 600;

    // 입력 필드
    private TextField levelField = new TextField("1",3);
    private Choice speciesChoice = getItems(Species.nameSet());
    private Choice natureChoice = getItems(Nature.nameSet());

    private TextField hpStatField = new TextField("0", 3);
    private TextField attackStatField = new TextField("0", 3);
    private TextField blockStatField = new TextField("0", 3);
    private TextField contactStatField = new TextField("0", 3);
    private TextField defenseStatField = new TextField("0", 3);
    private TextField speedStatField = new TextField("0", 3);

    private TextField hpEffortField = new TextField("0", 3);
    private TextField attackEffortField = new TextField("0", 3);
    private TextField blockEffortField = new TextField("0", 3);
    private TextField contactEffortField = new TextField("0", 3);
    private TextField defenseEffortField = new TextField("0", 3);
    private TextField speedEffortField = new TextField("0", 3);

    public IvCalFrame() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        add(levelField);
        add(speciesChoice);
        add(natureChoice);

        add(natureChoice);

        add(hpStatField);
        add(attackStatField);
        add(blockStatField);
        add(contactStatField);
        add(defenseStatField);
        add(speedStatField);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        }
        );
        setResizable(false);
    }


    // 계산 명령 버튼
    private Button calButton = makeCalButton();

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
            //TODO : 버튼이 눌렀을 떄 해야할 내용들...
        });
        return button;
    }

}
