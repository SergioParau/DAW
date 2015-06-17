import java.util.*;
public class Ejercicio03 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		double notasA[] = new double[5];
		double notasB[] = new double[5];
		char grupo;
		int contadorA = 0;
		int contadorB = 0;
		double sumaA = 0;
		double mediaA = 0;
		double sumaB = 0;
		double mediaB = 0;
	
		
		
		for(int i=0;i<10;i++){
			System.out.println("Introduce el grupo de clase, A ó B.");
			grupo = teclado.next().charAt(0);
		
		if(grupo=='A'){
			
			System.out.println("Introduce ahora la nota obtenida.");
			notasA[contadorA] = teclado.nextInt();	
			
			if(notasA[contadorA]<=10&&notasA[contadorA]>=0){
			sumaA = sumaA + notasA[contadorA];
			contadorA++;
			
			} else {
				System.out.println("Por favor, introduce una nota válida entre 0 y 10.");
				notasA[contadorA] = teclado.nextInt();
			}//FIN IF CONDICION A
			}//FIN IF A
		
		if(grupo=='B'){
			
			System.out.println("Introduce ahora la nota obtenida.");
			notasB[contadorB] = teclado.nextInt();		
			
			if(notasB[contadorB]<=10&&notasB[contadorB]>=0){
			
				sumaB = sumaB + notasB[contadorB];
				contadorB++;
				} else {
					System.out.println("Por favor, introduce una nota válida entre 0 y 10.");
					notasB[contadorB] = teclado.nextInt();
					
					
				}//FIN IF CONDICION B
			}//FIN IF B
		}//FIN FOR
		
		mediaA = sumaA/contadorA;
		mediaB = sumaB/contadorB;
		
		if(mediaA>mediaB){
			System.out.println("El grupo A tiene mayor promedio que el grupo B");
		} else if (mediaA == mediaB){
			System.out.println("Las medias de los dos grupos son iguales");

		}else {
			System.out.println("El grupo B tiene mayor promedio que el grupo A");

		}
		
	}

}
