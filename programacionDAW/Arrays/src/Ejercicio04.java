import java.util.*;
public class Ejercicio04 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int valor[] = new int[10];
		int contador = 0;
		
		
		for(int v = 0;v<10;v++){
			
		System.out.println("Introduce el valor "+(v+1));
		valor[v] = teclado.nextInt();
	
		
		}//FIN FOR
		
		for (int v = 0;v<9;v++){
			if(valor[v]<valor[v+1]){
				contador++;
			}
		}
		
		if(contador==9){
			System.out.println("Los valores introducidos están ordenados.");
		}else{
			System.out.println("Los valores introducidos no están ordenados.");
		}
		
	}//FIN MAIN

}// FIN CLASS
