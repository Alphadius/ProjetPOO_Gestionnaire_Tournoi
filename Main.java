public class main{
	public static void main(String[] args){
		Competition origin = new Competition();
		origin.getDataJoueur("BDD");
		origin.getDataEquipe("BDDEquipe",16);
		ViewCompetition theView = new ViewCompetition(origin);
        
    	Competition theModel = new Competition();
        theModel.getDataJoueur("BDD");
        ControllerCompetition theController = new ControllerCompetition(theView,theModel,origin);
        
        theView.setVisible(true);
	}
}