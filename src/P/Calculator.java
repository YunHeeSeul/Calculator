package P;

import java.io.IOException;
import java.util.ArrayList;
public class Calculator {
    ArrayList<Integer> a = new ArrayList<>();

    public Calculator(){}
    public String calculate(int op, int operand1, int operand2) {
        int result=0;
        String rs = "";
        if (op==-5) {
            result = operand1 + operand2;
        } else if (op==-3) {
            result = operand1 - operand2;
        } else if (op==-6) {
            result = operand1 * operand2;
        } else if (op==-1) {
            result = operand1 / operand2;
        }
        String s = Integer.toString(result);    //문자열로 형변환
        for (int i=0; i<s.length(); i++)
            rs += s.charAt(i);
        return rs;
    }
    public String calculateF(int op, float operand1, float operand2) {
        float result=0;
        String rs = "";
        if (op==-5) {
            result = operand1 + operand2;
        } else if (op==-3) {
            result = operand1 - operand2;
        } else if (op==-6) {
            result = operand1 * operand2;
        } else if (op==-1) {
            result = operand1 / operand2;
        }
        String s = Float.toString(result);    //문자열로 형변환
        for (int i=0; i<s.length(); i++)
            rs += s.charAt(i);
        return rs;
    }

    public String compute(String input) throws IOException {
            int operand1 = 0;
            int operand2;
            float operandF1 = 0;
            float operandF2;
            int op=0;   //연산자를 저장하는 변수
            int r=0;    //연산자가 입력되기 전까지의 숫자를 저장하는 변수
            int temp1=0; //소수점 앞부분
            String result = "";
            int count=0; //소수점 이후 자릿수 저장하는 변수

            for(int i=0; i<input.length(); i++) a.add(System.in.read(input.getBytes())-48);//문자열 바이트로 변환한 상태로 읽어와서 -48을 해줌으로써 숫자 계산이 편하도록
            //System.out.println(a);

            if(a.contains(-2)){ //.이 포함된 경우.
                for (int i=0; i<a.size();i++){  //문자열 끝날 때까지 반복
                    if(a.get(i)==-5||a.get(i)==-3||a.get(i)==-6||a.get(i)==-1){ //연산자일 경우
                        op=a.get(i);    //연산자 저장
                        operandF1=(float)temp1; //연산자 입력되기 전까지의 숫자 저장
                        temp1=0;    //temp1 초기화
                        count = (int)( Math.log10(r)+1 ); //.이후까지의 숫자 자릿수
                        operandF1= operandF1 + (float) (r*Math.pow(0.1,count)); //.이후까지의 수를 소수점 아래 수로 바꿔주고 자연수 부분과 더해줌
                        continue;
                    }
                    else if(a.get(i)==13){//=을 입력한 경우
                        a.clear();  //a리스트 다 비우고
                        operandF2=(float) temp1;
                        temp1=0;
                        count = (int)( Math.log10(r)+1 );
                        operandF2= operandF2 + (float) (r*Math.pow(0.1,count));
                        result = this.calculateF(op,operandF1,operandF2);
                    }
                    else{//숫자와 .을 입력한 경우
                        if(a.get(i)==-2) {//.을 입력한 경우
                            temp1 = r;  //.전까지의 숫자를 저장
                            r=0; //초기화
                        }else   //.을 입력하지 않은 경우
                            r = this.convert(r,a.get(i));
                    }
                }
                return result;
            }
            else {
                for (int i = 0; i < a.size(); i++) {  //문자열 끝날 때까지 반복
                    if (a.get(i) == -5 || a.get(i) == -3 || a.get(i) == -6 || a.get(i) == -1) { //연산자일 경우
                        op = a.get(i);    //연산자 저장
                        operand1 = r; //연산자 입력되기 전까지의 숫자 저장
                        r = 0;    //r 초기화
                        continue;
                    } else if (a.get(i) == 13) {//=을 입력한 경우
                        a.clear();  //a리스트 다 비우고
                        operand2 = r; //
                        result = this.calculate(op, operand1, operand2);
                    } else {//숫자와 .을 입력한 경우
                        if (a.get(i) == -2) {//.을 입력한 경우
                            temp1 = r;  //.전까지의 숫자를 저장
                        } else   //.을 입력하지 않은 경우
                            r = this.convert(r, a.get(i));
                    }
                }
                return result;
            }
    }
    private int convert(int r,int a) {    //정수형으로 변환해주는 메소드
        r = r * 10 + a;
        return r;
    }
}

