import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class writeData{
	public static void main(String[] args) {

		String fileName = "sauvegarde.txt";

		PrintWriter writer = null;
		try{
			writer = new PrintWriter(fileName);
		}catch(FileNotFoundException e){
			//sortie erreur
			e.printStackTrace();
		}
		//on va transformer nos objet en fichier txt avec des boucle for ... 
		//et les mettres en page de manière à etre lisible pour le buffer
		while(true){
		Scanner reader=new Scanner (System.in);//permet decrire le texte que lon veut dans le txt
		System.out.println ("Que voulez vous ecrire ?");
		String text=reader.nextLine();
		if(text.equals("fini")){
			break;
		}
		writer.println(text);
		}
		writer.close();
	}
}