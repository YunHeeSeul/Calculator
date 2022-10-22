package Ex;

import java.io.IOException;
import java.util.ArrayList;
public class Calculator {
    ArrayList<Integer> a = new ArrayList<>();

    public Calculator(){}
    public int calculate(int op, int operand1, int operand2) {
        int result=0;

        if (op==-5) {
            result = operand1 + operand2;
        } else if (op==-3) {
            result = operand1 - operand2;
        } else if (op==-6) {
            result = operand1 * operand2;
        } else if (op==-1) {
            result = operand1 / operand2;
        }
        return result;
    }

    public float calculateF(int op, int operand1, int operand2) {
        int result=0;

        if (op==-5) {
            result = operand1 + operand2;
        } else if (op==-3) {
            result = operand1 - operand2;
        } else if (op==-6) {
            result = operand1 * operand2;
        } else if (op==-1) {
            result = operand1 / operand2;
        }
        return result;
    }

    public String compute(String input) throws IOException {

        while (true) {
            int operand = 0;
            int operand1 = 0;
            int operand2;
            float operandF1 = 0;
            float operandF2;
            int op=0;   //연산자를 저장하는 변수
            int r=0;    //연산자가 입력되기 전까지의 숫자를 저장하는 변수
            float fr = 0;   //r을 float형으로 바꿔준 변수
            int temp1=0; //소수점 앞부분
            int temp2=0; //소수점 뒷부분
            int result=0;
            int count=0;
            int [] dot = new int[10]; //.이 있는 인덱스를 저장하는 변수

            for(int i=0; i<input.length(); i++) a.add(System.in.read(input.getBytes())-48);//문자열 바이트로 변환한 상태로 읽어와서 -48을 해줌으로써 숫자 계산이 편하도록
            //System.out.println(a);

            if(a.contains(-2)){ //.이 포함된 경우.
                for (int i=0; i<a.size();i++) {  //문자열 끝날 때까지 반복
                        dot[i] = a.indexOf(-2);
                }
                for (int i=0; i<a.size();i++){  //문자열 끝날 때까지 반복
                    count++;

                    if(a.get(i)==-5||a.get(i)==-3||a.get(i)==-6||a.get(i)==-1){ //연산자일 경우
                        op=a.get(i);    //연산자 저장
                        operandF1=fr; //연산자 입력되기 전까지의 숫자 저장
                        fr=0;    //r 초기화
                        continue;
                    }
                    else if(a.get(i)==13){//=을 입력한 경우
                        a.clear();  //a리스트 다 비우고
                        operand2=r; //
                        result=this.calculate(op,operand1,operand2);
                    }
                    else{//숫자와 .을 입력한 경우
                        for(int j=0; j<dot[i]-1; j++)
                            r=this.convert(r,a.get(j));

                    }
                }

            }
            else {

            }

            for (int i=0; i<a.size();i++){  //문자열 끝날 때까지 반복
                count++;
                if(a.get(i)==-5||a.get(i)==-3||a.get(i)==-6||a.get(i)==-1){ //연산자일 경우
                    op=a.get(i);    //연산자 저장
                    operand1=r; //연산자 입력되기 전까지의 숫자 저장
                    r=0;    //r 초기화
                    continue;
                }
                /*
                else if(a.get(i)==-35||a.get(i)==-38) {
                    a.clear();
                    operand2=r;
                    result=this.calculate(op,operand1,operand2);
                    System.out.println(result+"\n");
                }
                 */
                else if(a.get(i)==13){//=을 입력한 경우
                    a.clear();  //a리스트 다 비우고
                    operand2=r; //
                    result=this.calculate(op,operand1,operand2);
                }
                else{//숫자와 .을 입력한 경우
                    if(a.get(i)==-2) {//.을 입력한 경우
                        temp1 = r;  //.전까지의 숫자를 저장
                    }else   //.을 입력하지 않은 경우
                        r = this.convert(r,a.get(i));
                }
            }
            /*
            if(a.equals(72)||a.equals(40))  //X를 입력한 경우
                return null;
             */
        }

    }
    private int convert(int r,int a) {    //정수형으로 변환해주는 메소드
        r = r * 10 + a;
        return r;
    }
    private int convertF(int r,int a) {    //실수형으로 변환해주는 메소드
        r = (int) (r * 0.1 + a * 0.1);
        return r;
    }
}

