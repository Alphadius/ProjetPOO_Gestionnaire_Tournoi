package compMaker.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import compMaker.view.ViewCompetition;
import compMaker.model.*;
public class controllerCompetition{
	private ViewCompetition theView;
	private Competition theModel;
	private Competition origin;

	public controllerCompetition(ViewCompetition theView, Competition theModel,Competition origin){
		this.theView = theView;
		this.theModel = theModel;
		this.origin = origin;

		this.theView.addCompEntreeListener(new ValidListener());
		this.theView.addRetourListener(new RetourListener());
		this.theView.addchoixEquipeListener(new choixEquipeListener());
	}

	class ValidListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			String compName = "";
			int nbEquipe = 0;
			try{
				if (theView.getNomCompetition().isEmpty()){
  					throw new Exception("Entrer un nom pour votre competition");
				}
				compName = theView.getNomCompetition();
				nbEquipe = theView.getNbEquipes();
				theView.comp = theModel;
				theView.origin = origin;
				theModel.putCompName(compName);
				theModel.putNbEquipe(nbEquipe);
				theModel.putDate( theView.getJour(), theView.getMois(), theView.getAnnee());
				//theView.setNomCompetition("<html> nom Competition : "+theModel.compName() + "<BR> Date début : " + theModel.sendDateStart()+"<BR> NombreEquipe : "+theModel.sendNbEquipe()+"</html>");
				
				////**** Séparation des différentes variables/attributs à réutiliser dans la vue
				theView.setNomCompetition(theModel.compName());
				theView.setNbEquipes(nbEquipe);
				theView.setDateStart(theModel.sendDateStart());
				theView.goChoixEquipe();
				
			} catch(Exception erreur) {
				theView.afficherErreur(erreur);
			}
		}
	}
	class choixEquipeListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			theModel.CombiMatch(theView.getNbEquipes());
			theView.sendMatch(theModel);
			theModel.trierParEquipe();
			System.out.println(theModel.equipeDe("france").JoueursInEquipe.size());
			theView.goListMatch();
		}
	}
	class RetourListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			String compName = "";
			int nbEquipe = 0;
			try{
				theView.retourListMatch();
			} catch(Exception erreur) {
				theView.afficherErreur(erreur);
			}
		}
	}
}