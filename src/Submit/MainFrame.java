package Submit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class MainFrame extends JFrame{
    //components
    private JLabel inputL, outputL;
    CalculatorS calculator;
    private JPanel p1, p2, p3, p4, p5, p6, p7, top, bottom;
    private JButton[] buttons;  //20개의 버튼 배열 생성
    private WindowHandler windowHandler;
    private String result;//결과
    private String mid;//아스키결과
    private String m;//중간결과
    StringBuffer sb = new StringBuffer();

    //constructor
    public MainFrame(){
        this.calculator=new CalculatorS();

        this.setTitle("ASCII/INT/FLOAT 계산기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(windowHandler);
        this.setSize(400,600);//사이즈 지정해주기
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));

        ActionHandler actionHandler = new ActionHandler();

        //폰트
        Font fButton = new Font("나눔고딕",Font.BOLD,20);
        Font fInput = new Font("Arial",Font.BOLD,30);
        Font fOutput = new Font("Arial",Font.ITALIC,40);

        p1 = new JPanel();   //output
        p1.setLayout(new GridLayout(1,1,0,0));
        //p1.setBackground(Color.getHSBColor(0,0,75));
        p1.setBackground(Color.getHSBColor(254,26,100));
        p1.setFont(fOutput);

        p2 = new JPanel();   //input
        p2.setLayout(new GridLayout(1,1,0,0));
        p2.setBackground(Color.DARK_GRAY);
        p2.setFont(fInput);

        p3 = new JPanel();   //<- , C 버튼
        p3.setLayout(new GridLayout(1,4,0,0));

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
        top.setBackground(Color.BLACK);

        bottom = new JPanel(); //buttons
        bottom.setLayout(new GridLayout(5,1,0,0));
        bottom.setBackground(Color.BLACK);

        //input&output label
        outputL=new JLabel("",JLabel.RIGHT);
        outputL.setFont(fOutput);
        outputL.setForeground(Color.DARK_GRAY);
        p1.add(outputL); //p1에 output 라벨 넣어줌
        inputL=new JLabel("",JLabel.RIGHT);
        inputL.setFont(fInput);
        inputL.setForeground(Color.getHSBColor(254,26,100));
        p2.add(inputL); //p2에 input 라벨 넣어줌

        //input&output panel
        top.add(p1);top.add(p2);

        //버튼 만들기
        String[] buttonTitle = {"<-","C","Root", "^", "1","2","3","+","4","5","6","-","7","8","9","*",".","0","=","/"};
        buttons = new JButton[20];
        for(int i=0;i<20;i++) {
            buttons[i] = new JButton(buttonTitle[i]);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setFont(fButton);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(actionHandler);
        }
        for(int i=0; i<4; i++){p3.add(buttons[i]);}
        for(int i=4; i<8; i++){p4.add(buttons[i]);}
        for(int i=8; i<12; i++){p5.add(buttons[i]);}
        for(int i=12; i<16; i++){p6.add(buttons[i]);}
        for(int i=16; i<20; i++){p7.add(buttons[i]);}

        bottom.add(p3);bottom.add(p4);bottom.add(p5);
        bottom.add(p6);bottom.add(p7);

        this.add(top);
        this.add(bottom);

    }

    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)  {

            if(e.getActionCommand()=="="){
                sb.append("=");
                if(!outputL.getText().equals("")){//무언가 있는 상태라면
                    outputL.setText("");
                }
                try {
                    result=run(sb.toString());
                    mid=output(result);//아스키
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                sb.delete(0,sb.length());//초기화
                sb.append(result);
                outputL.setText(mid); //결과 출력
                mid="";
            }
            else if(e.getActionCommand()=="1"){sb.append(1); inputL.setText(sb.toString());}
            else if(e.getActionCommand()=="2"){sb.append(2); inputL.setText(sb.toString());}
            else if(e.getActionCommand()=="3"){sb.append(3);  inputL.setText(sb.toString());}
            else if(e.getActionCommand()=="4"){sb.append(4);  inputL.setText(sb.toString());}
            else if(e.getActionCommand()=="5"){sb.append(5);  inputL.setText(sb.toString());}
            else if(e.getActionCommand()=="6"){sb.append(6);  inputL.setText(sb.toString());}
            else if(e.getActionCommand()=="7"){sb.append(7);  inputL.setText(sb.toString());}
            else if(e.getActionCommand()=="8"){sb.append(8);  inputL.setText(sb.toString());}
            else if(e.getActionCommand()=="9"){sb.append(9);  inputL.setText(sb.toString());}
            else if(e.getActionCommand()=="0"){sb.append(0);  inputL.setText(sb.toString());}
            else if(e.getActionCommand()=="."){
                sb.append(".");
                inputL.setText(sb.toString());
            }
            else if(e.getActionCommand()=="<-"){//맨 마지막 문자 지우기
                sb.deleteCharAt(sb.length()-1);
                inputL.setText(sb.toString());
            }
            else if(e.getActionCommand()=="C"){//전체 지우기
                sb.delete(0,sb.length());//여태까지 입력한 문자열 지우기
                inputL.setText(sb.toString());
                outputL.setText(sb.toString());
            }else{//연산자를 클릭한 경우
                if(!outputL.getText().equals("")) {//이미 계산된 적 있는 경우라면
                    inputL.setText(sb.toString());//inputL에 이전 결과를 넣어줌
                    m=sb.toString();
                    sb.delete(0,sb.length());//초기화
                    sb.append(m);
                }
                if (e.getActionCommand() == "+") {
                    sb.append("+");
                    inputL.setText(sb.toString());
                } else if (e.getActionCommand() == "-") {
                    sb.append("-");
                    inputL.setText(sb.toString());
                } else if (e.getActionCommand() == "*") {
                    sb.append("*");
                    inputL.setText(sb.toString());
                } else if (e.getActionCommand() == "/") {
                    sb.append("/");
                    inputL.setText(sb.toString());
                }else if (e.getActionCommand() == "Root") {
                    sb.append("r");
                    inputL.setText(sb.toString());
                }else if (e.getActionCommand() == "^") {
                    sb.append("^");
                    inputL.setText(sb.toString());
                }
            }
        }
    }

    private String run(String input) throws IOException {//int/float
        return calculator.compute(input);
    }

    private String output(String input) throws IOException {//아스키
        return calculator.getString(input);
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
