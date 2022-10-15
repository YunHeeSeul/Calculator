package Ex;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.*;
import java.awt.Panel;

public class MainFrame extends JFrame {
    //components
    private JLabel inputL, outputL;
    private ToolBar toolBar;
    private Panel panel;
    private JPanel whole, p1, p2, p3, top, bottom;
    private JButton[] buttons;  //16개의 버튼 배열 생성
    private WindowHandler windowHandler;

    //constructor
    public MainFrame(){
        this.setTitle("ASCII/INT/FLOAT 계산기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(windowHandler);
        this.setSize(400,600);//사이즈 지정해주기
        this.setLayout(new BorderLayout(30,0));

        //폰트
        Font fButton = new Font("나눔고딕",Font.BOLD,20);
        Font fInput = new Font("나눔고딕",Font.BOLD,20);
        Font fOutput = new Font("나눔고딕",Font.BOLD,30);

        //툴바 만들기. ASCII->Int/Float 과 Int/Float->ASCII 선택하는
        toolBar = new ToolBar();
        //toolBar.setSize(1400,50);
        toolBar.setBackground(Color.BLACK);
        add(toolBar,BorderLayout.NORTH);

        //패널 만들기. 계산기가 그려지는
        whole = new JPanel(); //모든 패널을 합칠 최종 패널
        p1 = new JPanel();   //input
        p2 = new JPanel();   //output
        p3 = new JPanel();   //숫자와 기호 버튼
        top = new JPanel(); //input&output
        bottom = new JPanel(); //button

        //input&output label
        inputL=new JLabel();
        outputL=new JLabel();

        p1.setLayout(new GridLayout(1,1));
        p1.setBackground(Color.darkGray);
        p1.setForeground(Color.LIGHT_GRAY);
        p1.setFont(fInput);
        p1.add(inputL); //p1에 input 라벨 넣어줌

        p2.setLayout(new GridLayout(1,1));
        p2.setBackground(Color.darkGray);
        p2.setForeground(Color.WHITE);
        p2.setFont(fOutput);
        p2.add(outputL); //p2에 output 라벨 넣어줌

        //this.panel = new Panel();
        //this.add(this.panel,BorderLayout.CENTER);
        top.setLayout(new GridLayout(2,1,1,1));
        top.setBackground(Color.lightGray);
        top.add(p1);
        top.add(p2);

        //버튼 만들기
        String[] buttonTitle = {"+","-","*","/","1","2","3","%","4","5","6","C","7","8","9","<-",".","0","=",""};
        buttons = new JButton[20];
        for(int i=0;i<20;i++) {
            buttons[i] = new JButton(buttonTitle[i]);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setFont(fButton);
            buttons[i].setForeground(Color.WHITE);
        }
        p3.setLayout(new GridLayout(5,4,3,3));
        p3.setBackground(Color.BLACK);
        for(int i=0; i<20; i++){
                p3.add(buttons[i]);
        }


        //whole.setLayout(new GridLayout(3,1,5,5));
        whole.setLayout(new BoxLayout(whole,BoxLayout.Y_AXIS));
        //whole.setLayout(new BorderLayout());
        whole.setBackground(Color.darkGray);
        whole.add(top);
        whole.add(p3);

        add(whole,BorderLayout.CENTER);

    }
   public void initialize(){
        //초기화
        //this.panel.initialize();
        //this.toolBar.initialize(this.panel);
    }
    private class WindowHandler implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {}
        @Override
        public void windowClosing(WindowEvent e) {}
        @Override
        public void windowClosed(WindowEvent e) {}
        @Override
        public void windowIconified(WindowEvent e) {}
        @Override
        public void windowDeiconified(WindowEvent e) {}
        @Override
        public void windowActivated(WindowEvent e) {}
        @Override
        public void windowDeactivated(WindowEvent e) {}
    }
}
