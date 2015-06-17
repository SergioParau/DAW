import java.io.*;
import java.util.Scanner;
public class Ejercicio01 {

	public static void main(String[] args) {
 
		Scanner input = null;
		PrintWriter outMayus = null;
		String word = null;
		
		
		try{
			 input = new Scanner(new FileReader("ficheros1.txt"));
			 
			 do{
				 word = input.nextLine();
			 
			 System.out.println(word.toUpperCase()+" ");
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
