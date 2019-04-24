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
		try{
			//va chercher le fichier demandé
			br = new BufferedReader(new FileReader("BDD.txt"));

			while((line = br.readLine()) != null){
				//on va choper toute les données ligne par ligne et les transformer en objets
				System.out.println(line);
			}
		}catch(IOException e){
			//si ya une erreur
			e.printStackTrace();
		}
	}
}