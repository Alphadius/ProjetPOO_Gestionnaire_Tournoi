import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ControllerCompetition{
	private ViewCompetition theView;
	private Competition theModel;

	public ControllerCompetition(ViewCompetition theView, Competition theModel){
		this.theView = theView;
		this.theModel = theModel;

		this.theView.addCompEntreeListener(new ValidListener());
		this.theView.addRetourListener(new RetourListener());
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
				theModel.putCompName(compName);
				theModel.putNbEquipe(nbEquipe);
				theModel.putDate( theView.getJour(), theView.getMois(), theView.getAnnee());
				//theView.setNomCompetition("<html> nom Competition : "+theModel.compName() + "<BR> Date début : " + theModel.sendDateStart()+"<BR> NombreEquipe : "+theModel.sendNbEquipe()+"</html>");
				
				////**** Séparation des différentes variables/attributs à réutiliser dans la vue
				theView.setNomCompetition(theModel.compName());
				theView.setNbEquipes(nbEquipe);
				theView.setDateStart(theModel.sendDateStart());
				theModel.CombiMatch(nbEquipe);
				theView.affichermatch(theModel);
				theView.goChoixEquipe();
				
			} catch(Exception erreur) {
				theView.afficherErreur(erreur);
			}
		}
	}
	class RetourListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			String compName = "";
			int nbEquipe = 0;
			try{
				theView.retourComp();
			} catch(Exception erreur) {
				theView.afficherErreur(erreur);
			}
		}
	}
}