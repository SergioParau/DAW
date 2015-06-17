import java.util.*;
public class Ejercicio01 {

	public static void main(String[] args) {
		
		//int valor[] = {10,10,10,10,10,10,100,100};
		Scanner teclado = new Scanner(System.in);
		int valor[] = new int[8];
		int suma = 0;
		int suma36 = 0;
		int contador50 = 0;
		
		
		
		for(int i=0; i<valor.length;i++){
			
			System.out.println("Introduce un valor: ");
			valor[i] = teclado.nextInt();
			
			suma = suma+valor[i];
			
			if(valor[i]>36){
				suma36 = suma36+valor[i];
			}
			
			if(valor[i]>50){
				contador50++;
			}
			
		}//FIN FOR
		
		System.out.println("La suma de valores es de "+suma);
		System.out.println("La suma de los valores mayores de 36 es de "+suma36);
		System.out.println("Hay un total de "+contador50+" valores mayores de 50.");
		
		
	}//FIN MAIN

}//FIN CLASS
