import java.util.*;
public class ForPares {
	public static void main(String[] args){
		
		int i;
		int n;
		int numero;
		int sumaPares = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el n�mero de enteros requeridos: ");
		n = teclado.nextInt();
		
		for(i=0; i<n;i++){
			System.out.println("Introduzca un n�mero entero: ");
			numero = teclado.nextInt();
			
			if(numero%2==0){
			sumaPares = sumaPares + numero;
			}
		}
		
		System.out.println("La suma de los n�meros pares es " + sumaPares);
	}
}
