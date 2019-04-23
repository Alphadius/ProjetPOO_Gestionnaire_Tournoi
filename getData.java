import java.util.*;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class getData{
		public static void main(String[] args) {
		String nom = "";
	    String prenom = "";
	    int dateNaissance = 0;
	    int position = 0;
	    boolean titulaire = false;
	    int numeroJoueur = 0;
	    int vitesse = 0;
	    int tirs = 0;
	    int passes = 0;
	    int dribbles = 0;
	    int defense = 0;
	    int physique = 0;
	    String equipe = "";
		BufferedReader br = null;
		String line;
		int count = 0;
		List<Joueur> joueurs = new ArrayList<Joueur>();
		try{
			br = new BufferedReader(new FileReader("BDD.txt"));

			while((line = br.readLine()) != null){
				//on va choper toute les données ligne par ligne et les transformer en objets
				switch(count){
					case 0:
						nom = line;
					break;
					case 1:
						prenom = line;
					break;
					case 2:
						dateNaissance = Integer.valueOf(line);
					break;
					case 3:
						position = Integer.valueOf(line);
					break;
					case 4:
						vitesse = Integer.valueOf(line);
					break;
					case 5:
						tirs = Integer.valueOf(line);
					break;
					case 6:
						passes = Integer.valueOf(line);
					break;
					case 7:
						dribbles = Integer.valueOf(line);
					break;
					case 8:
						defense = Integer.valueOf(line);
					break;
					case 9:
						physique = Integer.valueOf(line);
					break;
					case 10:
						equipe = line;
					break;
					case 11:
						numeroJoueur = Integer.valueOf(line);
					break;
					case 12:
						if(line.equals("1")){
							titulaire = true;
						}else{titulaire = false;}
						Joueur joueur1 = new Joueur(nom, prenom, dateNaissance, position, vitesse, tirs, passes, dribbles, defense, physique, equipe, numeroJoueur, titulaire);
						joueurs.add(joueur1);
						// joueur1.afficherStats();
						System.out.println(joueur1);
					break;
				}
				count = (count+1)%13;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}