import java.util.*;
public class Ejercicio11 {
	public static void main(String[] args){
	
		Scanner teclado = new Scanner(System.in);
		int numSueldos;
		int sueldos;
		int sueldoMax = 0;
		
		
		System.out.println("Introduce el número de sueldos: ");
		numSueldos = teclado.nextInt();
		
		for(int i = 0;i<numSueldos;i++){
			System.out.println("Introduce un sueldo: ");
			sueldos = teclado.nextInt();
			
			if(i==0){
				sueldoMax=sueldos;
			}
			if(sueldos>sueldoMax){
				sueldoMax=sueldos;
			}
		}//FIN FOR
		
		System.out.println("El sueldo máximo es de "+sueldoMax+" euros.");
		
		
	}//FIN MAIN
}// FIN CLASS
