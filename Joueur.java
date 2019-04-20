import java.util.Vector;

public class Joueur extends Personne {

  String Position;

  /*Boolean titulaire;

    public Vector  myEquipe;
    public Vector  myStatJoueur;
    public Vector  myEquipe;
    public Vector  myEquipe;*/
    /**
   * 
   * @element-type Participation
   
  public Vector  tttt;
  public Vector  myPersonne;*/

  public int id;
  public int vitesse;
  public int tirs;
  public int passes;
  public int dribbles;
  public int defense;
  public int physique;


  public Equipe appartient;
  public void afficherStatsJoueur(int idJoueur) {
    System.out.println(Joueur.id);
    if(this.id == idJoueur) {
      System.out.println(this.vitesse);
      //etc etc ?
    }
  }

}
