import ivcal.IvCalApp;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Application extends Frame {

    private static final String TITLE = "Pokemon Calculator";
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 225;
    public Application() {
        initApplication();
    }

    private void initApplication() {
        setTitle(TITLE);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setLayout(null);

        Button button = new Button("IV Calculator");
        button.setBounds(100,100,100,20);
        add(button);
        button.addActionListener(e -> new IvCalApp().open()); // button을 누르면 새 IVCalApp이 열린다.

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) { // 닫기 버튼을 누르면 프로그램이 종료된다.
                System.exit(0);
            }
        });
        setResizable(false);
        setVisible(true);
    }

    public void open() {
        setVisible(true);
    }

}
