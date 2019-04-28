import java.util.*;
import javax.swing.*;
public class main{

	public static void main(String[] args){
		// List<Competition> listComp = new ArrayList<Competition>();
		
		JFrame pageTournoi = new JFrame("Tournoi");
		Competition comp1 = new Competition();
		new menu(pageTournoi, comp1);
		// listComp.add(comp1);
	}
}