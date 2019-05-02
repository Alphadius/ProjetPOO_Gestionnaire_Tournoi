public class main{
	public static void main(String[] args){
		Competition origin = new Competition();
		origin.getDataOrigin();
		ViewCompetition theView = new ViewCompetition();
        
    	Competition theModel = new Competition();
        
        ControllerCompetition theController = new ControllerCompetition(theView,theModel);
        
        theView.setVisible(true);
	}
}