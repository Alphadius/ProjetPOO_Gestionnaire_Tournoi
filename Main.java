public class main{
	public static void main(String[] args){
		ViewCompetition theView = new ViewCompetition();
        
    	Competition theModel = new Competition();
        
        ControllerCompetition theController = new ControllerCompetition(theView,theModel);
        
        theView.setVisible(true);
	}
}