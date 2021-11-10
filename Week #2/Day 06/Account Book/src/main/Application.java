package main;

import appDB.AccountBookDB;
import home.HomeMenu;
import util.Inputter;

import java.util.Scanner;

public class Application {

    private static final Scanner SC = Inputter.getResource();
    private final AccountBookDB accountBookDB = new AccountBookDB();

    public Application() {
        putFileData();
    }

    // TODO : 프로젝트 폴더의 텍스트 파일들을 읽어와서, DB에 추가한다.
    void putFileData() {

    }

    // 홈화면을 호출한다. 홈화면의 작업을 마치면 종료하면서 true를 반환한다.
    public boolean run() {
        HomeMenu homeMenu = new HomeMenu(accountBookDB);
        homeMenu.run();
        return true;
    }

}
