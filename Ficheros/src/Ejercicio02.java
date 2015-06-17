import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class Ejercicio02 {

	public static void main(String[] args) {
		
		Scanner input = null;
		String word = null;
		
		
		try{
			 input = new Scanner(new FileReader("Ficheros2.txt"));
			 input.useDelimiter(",");
			 
			 do{
				 word = input.nextLine();
				 word = word.replace(',', ' ');
			 
			 System.out.println(word.toLowerCase());
			 
			 }while(input.hasNextLine());
			
		}catch(FileNotFoundException e){
			System.out.println("Error abriendo el archivo");
		}finally{
			
			if(input!=null){
				input.close();
			}
		}
		

	}

}
