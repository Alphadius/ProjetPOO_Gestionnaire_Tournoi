import java.util.*;

public class Participation {

  int nbButs[][] = new int[nbEquipes][/*nbMatchs*/]; //tableau contenant le nombre de buts par équipe : nbButs[idEquipe][idMatch]
  int idEquipe, idMatch;
  
  public void entrerScore() {
    Scanner reader = new Scanner(System.in);
      
    System.out.println("Entrer le n° identifiant du match");
    idMatch = reader.nextInt();
    
    for(int i=0; i<2; i++) {
      System.out.println("Entrer le n° de l'équipe\n");
      idEquipe = reader.nextInt();
      System.out.println("Entrer le nombre de buts de l'équipe");
      nbButs[idEquipe][idMatch] = reader.nextInt(); 
    }
  }

  int nbCarton;

    public Vector  1.1;
    public Joueur xxxxx;
    public Match valide;

}
