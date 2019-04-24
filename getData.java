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
						// System.out.println("\nid : "+joueur1);
						// joueur1.afficherStats();
					break;
				}
				count = (count+1)%13;
			}
		}catch(IOException e){
			e.printStackTrace();
		}



		///TRIER LES JOUEURS PAR ORDRE ALPHABETIC
		class TrierParNom implements Comparator<Joueur> { 
		    public int compare(Joueur a, Joueur b) { 
		    	String nom1 = a.nom.toUpperCase();
			    String nom2 = b.nom.toUpperCase();
		        return nom1.compareTo(nom2);
		    } 
		}
		class TrierParPrenom implements Comparator<Joueur> { 
		    public int compare(Joueur a, Joueur b) { 
		    	String nom1 = a.prenom.toUpperCase();
			    String nom2 = b.prenom.toUpperCase();
		        return nom1.compareTo(nom2);
		    } 
		}
		class TrierParAge implements Comparator<Joueur> { 
		    public int compare(Joueur a, Joueur b) { 
		    	int nom1 = a.dateNaissance;
			    int nom2 = b.dateNaissance;
		        return nom1 - nom2;
		    } 
		}


		//copy la liste d'origine dans le liste temporaire pour la trier
		List<Joueur> tempJoueurs = new ArrayList<Joueur>();
		for(Joueur temp: joueurs){
			Joueur joueur1 = new Joueur(temp.nom, temp.prenom, temp.dateNaissance, temp.position, temp.vitesse, temp.tirs, temp.passes, temp.dribbles, temp.defense, temp.physique, temp.equipe, temp.numeroJoueur, temp.titulaire);
			tempJoueurs.add(joueur1);
		}




		//trier la liste temporaire par prénom de manière alphabétic
		Collections.sort(tempJoueurs, new TrierParPrenom());

		System.out.println("\nTrie par prenom:");
		for(Joueur temp: tempJoueurs){
			System.out.println("id : " + temp);
			System.out.println( temp.prenom + " " +temp.nom + " " + temp.equipe);
		}



		//trier la liste temporaire par nom de manière alphabétic
		Collections.sort(tempJoueurs, new TrierParNom());

		System.out.println("\nTrie par nom:");
		for(Joueur temp: tempJoueurs){
			System.out.println("id : " + temp);
			System.out.println(temp.nom + " " + temp.prenom + " " + temp.equipe);
		}


		Collections.sort(tempJoueurs, new TrierParAge());

		System.out.println("\nTrie par Age:");
		for(Joueur temp: tempJoueurs){
			System.out.println("id : " + temp);
			System.out.println(2019 - temp.dateNaissance+" "+temp.nom + " " + temp.prenom + " " + temp.equipe);
		}

		//vérifier que la liste d'origine na pas été affecté
		System.out.println("\nPas de trie:");
		for(Joueur temp: joueurs){
			System.out.println("id : " + temp);
			System.out.println( temp.prenom + " " +temp.nom + " " + temp.equipe);
		}

	}
}