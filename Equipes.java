import java.util.*;

public class Equipes {

  String nomEquipe;
  String nomCoach;
  int nombreJoueurs;
  List<Joueur> JoueursInEquipe = new ArrayList<Joueur>();


public Equipes(String nom){
  this.nomEquipe = nom;
}


public Equipes() {
  this.nomEquipe = "non attribuer";
  this.nomCoach = "non attribuer";
  this.nombreJoueurs = 0;
  }

  public void afficherStatEquipe() {
    System.out.println(this.nomEquipe);
    System.out.println("Coach : " + this.nomCoach);
    System.out.println("Nombre de Joueurs : " + nombreJoueurs);
    // Faire pareil pour les autres stats
  }

  public void changementFormation() {

  }

  public void afficherMatchEquipe() {
    
  }

}
