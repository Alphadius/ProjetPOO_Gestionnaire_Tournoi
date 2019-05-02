public class main{
	public static void main(String[] args){
		System.setProperty( "file.encoding", "UTF-8" );

		ViewCompetition theView = new ViewCompetition();
        
    	Competition theModel = new Competition();
        
        ControllerCompetition theController = new ControllerCompetition(theView,theModel);
        
        theView.setVisible(true);
	}
}