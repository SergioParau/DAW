import java.io.*;
import java.util.*;
public class Ejercicio03 {

	public static void main(String[] args) {

		PrintWriter out = null;
		PrintWriter out2 = null;
		Scanner input = new Scanner(System.in);
		int n;
		
		System.out.println("Introduce cuántos números enteros vas a introducir");
		n = input.nextInt();
		
		double enteros[] = new double[n];
		
		System.out.println("Introduce ahora la lista de números:");
		
		for (int i=0;i<enteros.length;i++){
			enteros[i] = input.nextDouble();
		}
		
		try{
			out = new PrintWriter("ficheros3.txt");
			out2 = new PrintWriter("ficheros3a.txt");
			
			
			for(int i=0;i<enteros.length;i++){
				out.print(enteros[i]+" ");
				out2.println(enteros[i]);
			}
			
		}catch(IOException e){
			System.out.println("Error: "+e);
			
		}finally{
			if(out!=null&&out2!=null){
				out.close();
				out2.close();
			}
		}
		
	}

}
