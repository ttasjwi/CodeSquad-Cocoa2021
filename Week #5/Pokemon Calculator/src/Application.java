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
        initFrameBounds();
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

    //Frame의 초기 위치를 화면 정가운데에 두도록 한다.
    private void initFrameBounds() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        final int SCREEN_WIDTH = screenSize.width;
        final int SCREEN_HEIGHT = screenSize.height;

        final int FRAME_X = SCREEN_WIDTH/2 - FRAME_WIDTH/2;
        final int FRAME_Y = SCREEN_HEIGHT/2 - FRAME_HEIGHT/2;
        setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void open() {
        setVisible(true);
    }

}
