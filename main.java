import java.util.*;
public class main{

	public static void main(String[] args){
		// List<Competition> listComp = new ArrayList<Competition>();
		Competition comp1 = new Competition();
		comp1.InitCompetition();
		comp1.getDataJoueurs();
		// listComp.add(comp1);
		new AfficherCompetition(comp1);
	}
}