package Submit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.text.DecimalFormat;

public class MainFrame extends JFrame implements ActionListener{
    //components
    private JLabel inputL, outputL;
    private Calculator calculator;
    private JPanel whole, p1, p2, p3, p4, p5, p6, p7, top, bottom;
    private JButton[] buttons;  //16개의 버튼 배열 생성
    private WindowHandler windowHandler;

    StringBuffer sb = new StringBuffer();
    DecimalFormat df = new DecimalFormat("#.###");
    //constructor
    public MainFrame(){
        this.setTitle("ASCII/INT/FLOAT 계산기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(windowHandler);
        this.setSize(400,600);//사이즈 지정해주기
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));

        //폰트
        Font fButton = new Font("나눔고딕",Font.BOLD,20);
        Font fInput = new Font("나눔고딕",Font.BOLD,20);
        Font fOutput = new Font("나눔고딕",Font.BOLD,30);

        //패널 만들기. 계산기가 그려지는
        whole = new JPanel(); //모든 패널을 합칠 최종 패널
        whole.setBackground(Color.BLACK);

        p1 = new JPanel();   //input
        p1.setLayout(new GridLayout(1,1,0,0));
        p1.setBackground(Color.darkGray);
        p1.setForeground(Color.LIGHT_GRAY);
        p1.setFont(fInput);

        p2 = new JPanel();   //output
        p2.setLayout(new GridLayout(1,1,0,0));
        p2.setBackground(Color.darkGray);
        p2.setForeground(Color.WHITE);
        p2.setFont(fOutput);

        p3 = new JPanel();   //<- , C 버튼
        p3.setLayout(new GridLayout(1,2,0,0));

        p4 = new JPanel();   //숫자, 연산자 버튼
        p4.setLayout(new GridLayout(1,4,0,0));

        p5 = new JPanel();
        p5.setLayout(new GridLayout(1,4,0,0));

        p6 = new JPanel();
        p6.setLayout(new GridLayout(1,4,0,0));

        p7 = new JPanel();
        p7.setLayout(new GridLayout(1,4,0,0));

        top = new JPanel(); //input&output
        top.setLayout(new GridLayout(2,1,1,1));
        top.setBackground(Color.lightGray);

        bottom = new JPanel(); //buttons
        bottom.setLayout(new GridLayout(5,1,0,0));
        bottom.setBackground(Color.BLACK);

        //input&output label
        inputL=new JLabel();
        p1.add(inputL); //p1에 input 라벨 넣어줌
        outputL=new JLabel();
        p2.add(outputL); //p2에 output 라벨 넣어줌

        //input&output panel
        top.add(p1);top.add(p2);

        //버튼 만들기
        String[] buttonTitle = {"<-","C","1","2","3","+","4","5","6","-","7","8","9","*",".","0","=","/"};
        buttons = new JButton[18];
        for(int i=0;i<18;i++) {
            buttons[i] = new JButton(buttonTitle[i]);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setFont(fButton);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(this);
        }

        for(int i=0; i<2; i++){p3.add(buttons[i]);}
        for(int i=2; i<6; i++){p4.add(buttons[i]);}
        for(int i=6; i<10; i++){p5.add(buttons[i]);}
        for(int i=10; i<14; i++){p6.add(buttons[i]);}
        for(int i=14; i<18; i++){p7.add(buttons[i]);}

        bottom.add(p3);bottom.add(p4);bottom.add(p5);
        bottom.add(p6);bottom.add(p7);

        //whole.setLayout(new BoxLayout(whole,BoxLayout.Y_AXIS));
        //whole.setBackground(Color.darkGray);
        this.add(top);
        this.add(bottom);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand()=="1"){sb.append(1);}
        else if(e.getActionCommand()=="2"){sb.append(2);}
        else if(e.getActionCommand()=="3"){sb.append(3);}
        else if(e.getActionCommand()=="4"){sb.append(4);}
        else if(e.getActionCommand()=="5"){sb.append(5);}
        else if(e.getActionCommand()=="6"){sb.append(6);}
        else if(e.getActionCommand()=="7"){sb.append(7);}
        else if(e.getActionCommand()=="8"){sb.append(8);}
        else if(e.getActionCommand()=="9"){sb.append(9);}
        else if(e.getActionCommand()=="0"){sb.append(0);}
        else if(e.getActionCommand()=="+"){sb.append("+");}
        else if(e.getActionCommand()=="-"){sb.append("-");}
        else if(e.getActionCommand()=="*"){sb.append("*");}
        else if(e.getActionCommand()=="/"){sb.append("/");}
        else if(e.getActionCommand()=="."){sb.append(".");}
        else if(e.getActionCommand()=="<-"){sb.deleteCharAt(sb.length()-1);}//맨 마지막 문자 지우기
        else if(e.getActionCommand()=="C"){sb.delete(0,sb.length()-1);}//전체 지우기
        else if(e.getActionCommand()=="="){
            sb.append("=");
            try {
                this.calculator.compute();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
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
