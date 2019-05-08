package compMaker;
import compMaker.view.*;
import compMaker.model.*;
import compMaker.controller.*;
public class main{
	public static void main(String[] args){
		Competition origin = new Competition();
		origin.getDataJoueur("data/BDDJoueur");
		origin.getDataEquipe("data/BDDEquipe",16);
		origin.writeDataJoueur("data/origin");
		origin.writeDataEquipe("data/origin");
		origin.CombiMatch(origin.equipes.size());
		origin.writeDataMatch("data/origin");
		Competition theModel = new Competition();
		// theModel.getDataEquipe("BDDEquipe",16);
					theModel.getDataJoueur("data/BDDJoueur");
					theModel.trierParEquipe();
					origin.trierParEquipe();
					origin.coachParEquipe();
					System.out.println(origin.equipeDe("france").nomCoach);
					System.out.println(theModel.equipeDe("france").JoueursInEquipe.size());		
		ViewCompetition theView = new ViewCompetition(origin, theModel);
        controllerCompetition theController = new controllerCompetition(theView,theModel,origin);
        
		theView.setVisible(true);
		// System.out.println(theModel.equipes.get(0).JoueursInEquipe.get(0).nom);
		//System.out.println(theModel.equipes.get(0).JoueursInEquipe.get(1).nom);
	}
}