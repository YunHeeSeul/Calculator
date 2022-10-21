package Submit;

import javax.swing.*;

public class ToolBar extends JToolBar {
    /*
    private Panel panel;

    public ToolBar(){
        this.setLayout(new GridLayout(1,2,50,0));
        //버튼 그룹화
        ActionHandler actionHandler = new ActionHandler();
        ButtonGroup group = new ButtonGroup();
        for(Constants.EToolMenu eToolMenu:Constants.EToolMenu.values()){
            JButton button = new JButton(eToolMenu.getToolMenu());
            button.setActionCommand(eToolMenu.name());
            button.addActionListener(actionHandler);
            group.add(button);
            this.add(button);
        }
    }

    public void initialize(Panel panel){
        this.panel=panel;
        //처음 눌리는 버튼을 num으로 설정
        ((JButton)this.getComponent(Constants.EToolMenu.num.ordinal())).doClick();
    }
    private class ActionHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

     */
}
