package Submit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        CalculatorC cc = new CalculatorC();
        cc.compute();
    }
}
