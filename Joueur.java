import java.util.Vector;

public class Joueur extends Personne {

  String position;
  String equipe;
  public int numeroJoueur;
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

  public Joueur(String nom, String prenom, int age, String dateNaissance, String position, String equipe, int numeroJoueur, float vitesse, int tirs, int passes, int dribbles, int defense, int physique) {
    this.nom = nom;
    this.prenom = prenom;
    this.age = age;
    this.dateNaissance = dateNaissance;
    this.position = position;
    this.equipe = equipe;
    this.numeroJoueur = numeroJoueur;
    this.vitesse = vitesse;
    this.tirs = tirs;
    this.passes = passes;
    this.dribbles = dribbles;
    this.defense = defense;
    this.physique = physique;
  }

  // il faudra créer les joueurs avec une commande du style : Joueur ronaldo = new Joueur("ronaldo", "cristiano", 34, "5 février 1985", .. .. .. ... etc avec les autres stats);

  public void afficherStats() {
    System.out.println(this.nom + " " + this.prenom);
    System.out.println(this.age + " ans");
    System.out.println("Date de naissance : " + this.dateNaissance);
    System.out.println("Equipe : " + this.equipe);
    System.out.println("N°" + this.numeroJoueur)
    System.out.println("Position : " + this.position);
    System.out.println("Vitesse : " + this.vitesse);
    System.out.println("Tirs : " + this.tirs);
    System.out.println("Passes : " + this.passes);
    System.out.println("Dribbles : " + this.dribbles);
    System.out.println("Defense : " + this.defense);
    System.out.println("Physique : " + this.physique);
  }

}