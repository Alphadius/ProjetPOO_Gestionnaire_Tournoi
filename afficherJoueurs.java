import javax.swing.*; 
import java.util.*;   
public class afficherJoueurs {    
JFrame f;    
afficherJoueurs(Competition comp){    
    f=new JFrame("ComboBox Example");
    List<String> nomJoueurs = new ArrayList<String>();
    for(Joueur temp : comp.joueurs){
    	nomJoueurs.add(temp.nom+" "+temp.prenom);
    }
    String[] listNom = nomJoueurs.toArray(new String[nomJoueurs.size()]);
    JComboBox cb=new JComboBox(listNom);
    cb.setBounds(50, 50,90,20);    
    f.add(cb);        
    f.setLayout(null);    
    f.setSize(400,500);    
    f.setVisible(true);         
}      
}   