import java.util.*;
public class EJERCICIO02 {

	public static void main(String[] args) {

		/*EJERCICIO 2. EXAMEN PROGRAMACION
		 * autor: Ricardo Boluda Hernández
		 * curso: 1ºDAW
		 * Fecha: 15 de Diciembre de 2014
		 */
	
		int N = 0;
		int min = 0;
		int contador = 0;
		boolean consecutivo = false;
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Introduce los elementos del vector: ");
		N = input.nextInt();
		
		int numeros[] = new int[N];
		
		for(int i=0;i<numeros.length;i++){
			System.out.println("Introduce el valor del vector en la posición "+i);
			numeros[i] = input.nextInt();
			
			if(i==0){
				min = numeros[i];
			}//ESTABLECER ELEMENTO MINIMO INICIAL
			
			if(numeros[i]<min){
				min = numeros[i];
				
			}//ESTABLECER ELEMENTO MINIMO EN ITERACIONES CONSECUTIVAS
			
		}//FOR PARA INTRODUCIR ELEMENTOS
		
		for(int j=0;j<numeros.length;j++){
			
			if(numeros[j]==min){
				contador++;
			}
		}//FOR PARA AVERIGUAR SI HAY REPETICION DE ELEMENTOS
		
		for(int v=0;v<numeros.length-1;v++){
			
			if(numeros[v]==numeros[v+1]){
				consecutivo = true;
			}
		}//FOR PARA AVERIGUAR SI HAY ELEMENTOS CONSECUTIVOS
		
		System.out.println("El valor mínimo es "+min+" y aparece "+contador+" veces");
		System.out.println("Existen dos valores en posiciones consecutivas iguales?: "+consecutivo);
		
	}

}
