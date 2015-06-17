import java.io.*;
import java.util.*;
public class Ejercicio04 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int numWord;
		String aux;
		
		
		System.out.println("Cuántas palabras vas a introducir?");
		numWord = input.nextInt();
		
		String word[] = new String[numWord];
		
		System.out.println("Introduce las palabras deseadas:");
		
		for(int i=0;i<word.length;i++){
			word[i] = input.next();
		}
		
		for(int i=0;i<word.length;i++){
			
			for(int j=0;j<word.length-1;j++){
				
				if(word[j].compareTo(word[j+1])>0){
					
					aux = word[j];
					word[j] = word[j+1];
					word[j+1] = aux;
				}
				
				
			}
		}//FIN FOR COMPROBACIÓN ALFABÉTICA
		
		
		PrintWriter out = null;
		
		try{
			
			out = new PrintWriter("ficheros4.txt");
			int bulletPoint = 1;
			
			for(int i=0;i<word.length;i++){
				
				out.print(bulletPoint+". "+word[i]);
				out.println();
				bulletPoint++;
				
			}
			
			
		}catch(IOException e){
			System.out.println("Error: "+e);
		}finally{
			if(out!=null){
				out.close();
			}
		}
		
		
		
		
		
	}

}
