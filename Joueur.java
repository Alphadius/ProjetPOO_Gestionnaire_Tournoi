import java.util.Vector;

public class Joueur extends Personne {

  int position;
  String equipe;
  public boolean titulaire;
  public int numeroJoueur;
  public float vitesse;
  public int tirs;
  public int passes;
  public int dribbles;
  public int defense;
  public int physique;
  int dateNaissance;
  /*
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

  public Joueur(String nom, String prenom,int dateNaissance, int position, int vitesse, int tirs, int passes, int dribbles, int defense, int physique, String equipe, int numeroJoueur, boolean titulaire) {
    this.nom = nom;
    this.prenom = prenom;
    this.age = age;
    this.dateNaissance = dateNaissance;
    this.position = position;
    this.equipe = equipe;
    this.titulaire = titulaire;
    this.numeroJoueur = numeroJoueur;
    this.vitesse = vitesse;
    this.tirs = tirs;
    this.passes = passes;
    this.dribbles = dribbles;
    this.defense = defense;
    this.physique = physique;
  }

  // il faudra créer les joueurs avec une commande du style : Joueur ronaldo = new Joueur("ronaldo", "cristiano", 34, "5 février 1985", .. .. .. ... etc avec les autres stats);

  public void afficherStats(int annee) {
    System.out.println(this.nom + " " + this.prenom);
    System.out.println((annee-this.dateNaissance) + " ans");
    System.out.println("Date de naissance : " + this.dateNaissance);
    System.out.println("Equipe : " + this.equipe);
    if(this.titulaire) {
      System.out.println("Titulaire");
    } else {
      System.out.println("Non-titulaire");
    }
    System.out.println("Numero : " + this.numeroJoueur);
    System.out.println("Position : " + this.position);
    System.out.println("Vitesse : " + this.vitesse);
    System.out.println("Tirs : " + this.tirs);
    System.out.println("Passes : " + this.passes);
    System.out.println("Dribbles : " + this.dribbles);
    System.out.println("Defense : " + this.defense);
    System.out.println("Physique : " + this.physique);
  }

}