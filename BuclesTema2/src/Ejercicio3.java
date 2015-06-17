import java.util.*;
public class Ejercicio3 {
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		int n;
		int suma = 0;
		
		for(int i=0;i<15;i++){
			System.out.println("Introduce un número.");
			n = teclado.nextInt();
			suma = suma + n;
		}
		
		System.out.println(suma);
		
	}//FIN MAIN
 }//FIN CLASS
