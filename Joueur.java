import java.util.Vector;

public class Joueur extends Personne {

  String position;
  String equipe;
 // public int id;
  public float vitesse;
  public int tirs;
  public int passes;
  public int dribbles;
  public int defense;
  public int physique;
  /*Boolean titulaire;

    public Vector  myEquipe;
    public Vector  myStatJoueur;
    public Vector  myEquipe;
    public Vector  myEquipe;*/
    /**
   * 
   * @element-type Participation
   
  public Vector  tttt;
  public Vector  myPersonne;
  public Equipe appartient;*/

  public void afficherStats() {
    System.out.println(this.nom + " " + this.prenom);
    System.out.println(this.age + "ans");
    System.out.println("Ne le " + this.dateNaissance);
    System.out.println("Equipe : " + this.equipe);
    System.out.println("Position : " + this.position);
    System.out.println("Vitesse : " + this.vitesse);
    System.out.println("Tirs : " + this.tirs);
    System.out.println("Passes : " + this.passes);
    System.out.println("Dribbles : " + this.dribbles);
    System.out.println("Defense : " + this.defense);
    System.out.println("Physique : " + this.physique);
  }

}
