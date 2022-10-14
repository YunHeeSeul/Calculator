package Ex;

import java.io.IOException;
import java.util.ArrayList;
public class Calculator {
    ArrayList<Integer> a = new ArrayList<>();

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

    public void compute() throws IOException {

        while (true) {
            int operand = 0;
            int operand1 = 0;
            int operand2 = 0;
            int op=0;
            int r=0;
            int result=0;

            System.out.println("입력");

            for(int i=0; i<6; i++)
                a.add(System.in.read()-48);
            //System.out.println(a);

            for (int i=0; i<a.size();i++){
                if(a.get(i)==-5||a.get(i)==-3||a.get(i)==-6||a.get(i)==-1){
                    op=a.get(i);
                    operand1=r;
                    r=0;
                    continue;
                }
                else if(a.get(i)==-35||a.get(i)==-38) {
                    a.clear();
                    operand2=r;
                    result=this.calculate(op,operand1,operand2);
                    System.out.println(result+"\n");
                }
                else{
                    r = r * 10 + a.get(i);
                }
            }
            if(a.equals(72)||a.equals(40))
                return;
        }
    }
}

