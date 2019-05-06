public class main{
	public static void main(String[] args){
		Competition origin = new Competition();
		origin.getDataJoueur("BDD");
		origin.getDataEquipe("BDDEquipe",16);
		ViewCompetition theView = new ViewCompetition(origin);
        
    	Competition theModel = new Competition();
		theModel.getDataJoueur("BDD");
		theModel.getDataEquipe("BDDEquipe",16);
		theModel.trierParEquipe();
        ControllerCompetition theController = new ControllerCompetition(theView,theModel,origin);
        
		theView.setVisible(true);
		// System.out.println(theModel.equipes.get(0).JoueursInEquipe.get(0).nom);
		System.out.println(theModel.equipes.get(0).JoueursInEquipe.get(1).nom);

	}
}