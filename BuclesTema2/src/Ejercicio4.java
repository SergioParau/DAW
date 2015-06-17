import java.util.*;
public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int numCoches = 0;
		int precio;
		int precioMax = 0;
		int precioMin = 0;
		
		System.out.println("Introduce el número de coches:");
		numCoches = teclado.nextInt();
		
		for(int i=0; i<numCoches; i++){
			
			System.out.println("Introduce el precio del coche: ");
			precio = teclado.nextInt();
			
			if(i==0){
				precioMax = precio;
				precioMin = precio;
			}//FIN IF INICIAL
			
			if(precio>precioMax){
				precioMax = precio;
			}//FIN IF MAX
			
			if(precio<precioMin){
				precioMin = precio;
			}//FIN IF MIN
		
		
		
		}//FIN FOR
		
		System.out.println("El precio máximo es de: " + precioMax);
		System.out.println("El precio mínimo es de: " + precioMin);
	}

}
