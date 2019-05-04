public class main{
	public static void main(String[] args){
		Competition origin = new Competition();
		origin.getDataJoueur("BDD");
		ViewCompetition theView = new ViewCompetition();
        
    	Competition theModel = new Competition();
        theModel.getDataJoueur("BDD");
        theModel.getDataEquipe("BDDEquipe",16);
        ControllerCompetition theController = new ControllerCompetition(theView,theModel);
        
        theView.setVisible(true);
	}
}