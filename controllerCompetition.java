import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ControllerCompetition{
	private ViewCompetition theView;
	private Competition theModel;

	public ControllerCompetition(ViewCompetition theView, Competition theModel){
		this.theView = theView;
		this.theModel = theModel;

		this.theView.addCompEntreeListener(new ValidListener());
	}

	class ValidListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			String compName = "";

			try{
				if (theView.getNomCompetition().isEmpty()){
  					throw new Exception("Entrer un nom pour votre competition");
				}
				System.out.println("dans validListener");
				compName = theView.getNomCompetition();
				theModel.putCompName(compName);
				theView.goChoixEquipe();
			}catch(Exception erreur){
				System.out.println(erreur);
			}
		}
	}
}