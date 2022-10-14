package Ex;

import javax.swing.*;
import javax.swing.plaf.ToolBarUI;
import java.awt.*;
import java.awt.Panel;

public class MainFrame extends JFrame {
    //로그인 되었습니다. 비밀번호가 틀렸습니다 다시 입력하세요 등. 작성
    //components
    private MenuBar menuBar;
    private ToolBarUI toolBar;
    private Panel panel;

    //constructor
    public MainFrame(){
        setTitle("ASCII/INT/FLOAT 계산기");

        this.setSize(400,600);//사이즈 지정해주기

        //메뉴바 만들기
        JMenuBar menuBar = new JMenuBar();

        //컨테이너 3개 만들기
        JPanel container1 = new JPanel();   //상단 형변환 선택 컴포넌트들이 들어갈 컨테이너
        JPanel container2 = new JPanel();   //중앙 값을 입력하는 컴포넌트들이 들어갈 컨테이너
        JPanel container3 = new JPanel();   //하단 결과 값을 출력하는 컴포넌트들이 들어갈 컨테이너

        //컴포넌트들 만들기
        //1. 상단 컴포넌트


        //컴포넌트 만들기
        //상단 컨테이너에 들어갈 컴포넌트 만들기




        // JLabel tID = new JLabel("test");
        //tID.setLocation(5,5);
        //tID.setSize(100,20);
        //mainFrame.add(tID);
    }

}
