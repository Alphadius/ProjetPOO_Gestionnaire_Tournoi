package compMaker;

import compMaker.view.*;
import compMaker.model.*;
import compMaker.controller.*;

public class main {
	public static void main(String[] args) {
		Competition origin = new Competition();
		origin.getDataJoueur("data/BDDJoueur");
		origin.getDataEquipe("data/BDDEquipe", 16);
		origin.writeDataJoueur("data/origin");
		origin.writeDataEquipe("data/origin");
		origin.CombiMatch(origin.equipes.size());
		origin.writeDataMatch("data/origin");
		Competition theModel = new Competition();
		theModel.getDataJoueur("data/BDDJoueur");
		theModel.trierParEquipe();
		origin.trierParEquipe();
		origin.coachParEquipe();
		ViewCompetition theView = new ViewCompetition(origin, theModel);
		controllerCompetition theController = new controllerCompetition(theView, theModel, origin);

		theView.setVisible(true);
	}
}