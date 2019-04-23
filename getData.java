import java.util.*;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class getData{
	public static void main(String[] args) {

		BufferedReader br = null;
		String line;
		int count = 0;
		try{
			//va chercher le fichier demandé
			br = new BufferedReader(new FileReader("BDD.txt"));
			while((line = br.readLine()) != null){
				//on va choper toute les données ligne par ligne et les transformer en objets
				int a = Integer.valueOf(line);
				System.out.println(a);
				switch(count){
					case 0:
						Joueur joueur = new Joueur();
						joueur.nom = line;
						System.out.println(joueur.nom);
					break;
					case 1:
						joueur.prenom = line;
					break;
					case 2:
						joueur.dateNaissance = Integer.valueOf(line);
					break;
					case 3:
						joueur.position = Integer.valueOf(line);
					break;
					case 4:
						joueur.vitesse =Integer.valueOf(line);
					break;
					case 5:
					joueur.tirs = Integer.valueOf(line);
					break;
					case 6:
						joueur.passes = Integer.valueOf(line);
					break;
					case 7:
						
						joueur.dribbles = Integer.valueOf(line);
					break;
					case 8:
						
						joueur.defense = Integer.valueOf(line);
					break;
					case 9:
						
						joueur.physique = Integer.valueOf(line);
					break;
					case 10:
						
						joueur.equipe = line;
					break;
					case 11:
						
						joueur.numeroJoueur = Integer.valueOf(line);
					break;
					case 12:
						if(line.equals("true")){
							joueur.titulaire = true;
						}else{joueur.titulaire = false;}
					break;
				}
				count = (count+1)%13;
				joueur.afficherstat();
			}
		}catch(IOException e){
			//si ya une erreur
			e.printStackTrace();
		}
	}
}