public class main{
	public static void main(String[] args){
		Competition origin = new Competition();
		origin.getDataJoueur("Joueur");
		origin.getDataEquipe("Equipe",16);
		origin.writeDataJoueur("origin");
		origin.writeDataEquipe("origin");
        
    	Competition theModel = new Competition();
		theModel.getDataJoueur("BDDJoueur");
		// theModel.getDataEquipe("BDDEquipe",16);
		theModel.trierParEquipe();
		System.out.println(theModel.equipeDe("france").JoueursInEquipe.size());
		ViewCompetition theView = new ViewCompetition(origin, theModel);
        controllerCompetition theController = new controllerCompetition(theView,theModel,origin);
        
		theView.setVisible(true);
		// System.out.println(theModel.equipes.get(0).JoueursInEquipe.get(0).nom);
		//System.out.println(theModel.equipes.get(0).JoueursInEquipe.get(1).nom);
	}
}