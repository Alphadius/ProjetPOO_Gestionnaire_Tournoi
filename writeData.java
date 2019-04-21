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
			e.printStackTrace();
		}
			writer.println("Ecrit ce que tu veux");
		writer.close();
	}
}