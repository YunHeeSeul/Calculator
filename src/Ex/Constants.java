package Ex;

public class Constants {
    public enum EToolMenu{
        ascii("Int/Float->ASCII",new Ascii()),
        num("ASCII->Int/Float", new Num());

        private String toolMenu;
        private Calculate selectedCal;

        private EToolMenu(String toolMenu, Calculate selectedCal){
            this.toolMenu = toolMenu;
            this.selectedCal=selectedCal;
        }

        public String getToolMenu(){
            return this.toolMenu;
        }

        public Calculate getSelectedCal(){
            return this.selectedCal;
        }



    }
}
