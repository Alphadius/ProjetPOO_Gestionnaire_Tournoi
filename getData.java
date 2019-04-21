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
			br = new BufferedReader(new FileReader("sauvegarde.txt"));

			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}