package Submit;
import java.io.IOException;

public class CalculatorS {
    public String calculate(int op, int operand1, int operand2) {
        int result=0;
        double op1 = (double) operand1;
        double op2 = (double) operand2;

        float rf=0;
        if (op==-1) {
            rf = (float)(op1/op2);
            String s = Float.toString(rf);    //문자열로 형변환
            String r = getString(s);
            return s;
        }
        else {
            if (op == -5) {
                result = operand1 + operand2;
            } else if (op == -3) {
                result = operand1 - operand2;
            } else if (op == -6) {
                result = operand1 * operand2;
            }else if (op==46) {
                result = (int) Math.pow(operand1,operand2);
            } else if (op==66) {
                rf= (float)(Math.sqrt(op1));
                String s = Float.toString(rf);    //문자열로 형변환
                String r = getString(s);    //아스키
                return s;
            }
            String s = Integer.toString(result);    //문자열로 형변환
            String r = getString(s);
            return s;
        }
    }

    public String calculateF(int op, float operand1, float operand2) {
        float result=0;

        double op1 = (double) operand1;
        double op2 = (double) operand2;

        float rf=0;
        if (op==-1) {
            rf = (float)(op1/op2);
            String s = Float.toString(rf);    //문자열로 형변환
            String r = getString(s);    //아스키
            return s;
        }
        else if (op==-5) {
            result = operand1 + operand2;
        } else if (op==-3) {
            result = operand1 - operand2;
        } else if (op==-6) {
            result = operand1 * operand2;
        } else if (op==46) {
            result = (float) Math.pow(operand1,operand2);
        } else if (op==66) {
            rf= (float)(Math.sqrt(op1));
            String s = Float.toString(rf);    //문자열로 형변환
            String r = getString(s);    //아스키
            return s;
        }
        String s = Float.toString(result);    //문자열로 형변환
        String r = getString(s);
        return s;
    }
    public String getString(String s) {//아스키
        String retVal="";
        byte[]a = new byte[s.length()];
        for (int i = 0; i< s.length(); i++)
            a[i] = (byte)s.charAt(i);
        for(byte value : a)
            retVal+=value;
        return retVal;
    }

    public String compute(String input) throws IOException {
        while (true) {
            int operand1 = 0;
            int operand2;
            float operandF1 = 0;
            float operandF2;
            int op = 0;   //연산자를 저장하는 변수
            int r = 0;    //연산자가 입력되기 전까지의 숫자를 저장하는 변수
            int temp1 = -1; //소수점 앞부분
            String result = "";
            int count = 0; //소수점 이후 자릿수 저장하는 변수

            byte[] ba = input.getBytes();
            int[] ia = new int[input.length()];
            boolean t = false;

            for (int i = 0; i < input.length(); i++) {
                ia[i] = ba[i] - 48;
                if (ia[i] == -2)
                    t = true;
            }
            if (t) { //.이 포함된 경우.
                for (int i = 0; i < ia.length; i++) {  //문자열 끝날 때까지 반복
                    if (ia[i] == -5 || ia[i] == -3 || ia[i] == -6 || ia[i] == -1 ||ia[i] == 46|| ia[i] == 66) { //연산자일 경우
                        op = ia[i];    //연산자 저장
                        if(temp1==-1){
                            operandF1 = (float) r;
                            r=0;
                            count=0;
                            continue;
                        }
                        else {
                            operandF1 = (float) temp1; //연산자 입력되기 전까지의 숫자 저장
                            temp1 = -1;    //temp1 초기화
                            operandF1 = operandF1 + r * (float) (Math.pow(0.1, count)); //.이후까지의 수를 소수점 아래 수로 바꿔주고 자연수 부분과 더해줌
                            r = 0;
                            continue;
                        }
                    }
                    else if (ia[i] == 13) {//=을 입력한 경우
                        if(temp1==-1){
                            operandF2 = (float) r;
                            result = this.calculateF(op, operandF1, operandF2);
                            break;
                        }
                        else {
                            operandF2 = (float) temp1;
                            temp1 = -1;
                            operandF2 = operandF2 + r * (float) (Math.pow(0.1, count));
                            result = this.calculateF(op, operandF1, operandF2);
                            break;
                        }
                    }
                    else {//숫자와 .을 입력한 경우
                        if (ia[i] == -2) {//.을 입력한 경우
                            temp1 = r;  //.전까지의 숫자를 저장
                            r = 0; //초기화
                            count = 0;
                        } else {   //.을 입력하지 않은 경우
                            r = this.convert(r, ia[i]);
                            count++;
                        }
                    }
                }
                return result;
            }
            else {
                for (int i = 0; i < ia.length; i++) {  //문자열 끝날 때까지 반복
                    if (ia[i] == -5 || ia[i] == -3 || ia[i] == -6 || ia[i] == -1 ||ia[i] == 46|| ia[i] == 66) { //연산자일 경우
                        op = ia[i];    //연산자 저장
                        operand1 = r; //연산자 입력되기 전까지의 숫자 저장
                        r = 0;    //r 초기화
                        continue;
                    } else if (ia[i] == 13) {//=을 입력한 경우
                        operand2 = r; //
                        result = this.calculate(op, operand1, operand2);
                    } else {//숫자 입력한 경우
                        r = this.convert(r, ia[i]);
                    }
                }
                return result;
            }
        }
    }
    private int convert(int r,int a) {    //정수형으로 변환해주는 메소드
        r = r * 10 + a;
        return r;
    }

}

