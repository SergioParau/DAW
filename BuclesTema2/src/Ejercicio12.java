import java.util.*;
public class Ejercicio12 {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int numero;
		int negativos = 0;
		
		for(int i=0;i<10;i++){
			System.out.println("Introduce un número: ");
			numero = teclado.nextInt();
			
			if(numero<0){
				negativos++;
			}//FIN IF
			
		}//FIN WHILE
		
		System.out.println("Se han introducido "+negativos+" números negativos.");

	}

}
