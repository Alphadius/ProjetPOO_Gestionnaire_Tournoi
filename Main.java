package compMaker;
import compMaker.view.*;
import compMaker.model.*;
import compMaker.controller.*;
public class main{
	public static void main(String[] args){
		Competition origin = new Competition();
		origin.getDataJoueur("BDDJoueur");
		origin.getDataEquipe("BDDEquipe",16);
		origin.writeDataJoueur("origin");
		origin.writeDataEquipe("origin");
		// theModel.getDataEquipe("BDDEquipe",16);
					theModel.getDataJoueur("BDDJoueur");
					theModel.trierParEquipe();
					System.out.println(theModel.equipeDe("france").JoueursInEquipe.size());		
    	Competition theModel = new Competition();
		ViewCompetition theView = new ViewCompetition(origin, theModel);
        controllerCompetition theController = new controllerCompetition(theView,theModel,origin);
        
		theView.setVisible(true);
		// System.out.println(theModel.equipes.get(0).JoueursInEquipe.get(0).nom);
		//System.out.println(theModel.equipes.get(0).JoueursInEquipe.get(1).nom);
	}
}