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
		writer.println("Ecrit ce que tu veux");
		writer.close();
	}
}