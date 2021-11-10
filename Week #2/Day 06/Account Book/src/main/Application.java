package main;

import home.HomeMenu;
import util.Inputter;

import java.util.Scanner;

public class Application {

    private final Scanner SC = Inputter.getResource();
    private HomeMenu homeMenu = new HomeMenu(this);

    //TODO : Application 생성자 : 초기화 역할
    public Application() {
        //* 경로에 위치한 개별 AccountBook들을 순서대로 읽어온다.
        //* Record들을 읽어오고, AccountBooks에 추가한다.
    }

    // 홈화면을 호출한다.
    public boolean run() {
        homeMenu.run();
        return true;
    }

}
