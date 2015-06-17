import java.util.*;
public class ForMedia {
	public static void main (String[] args){
		
		Scanner teclado = new Scanner(System.in);
		int i;//Variable control bucle (INDEPENDIENTE DE LA VARIABLE INTRODUCIDA POR EL USUARIO)
		int n;//Variable que guarda el número del usuario
		int suma = 0;
		
		for(i=0;i<10;i=i+1){
			System.out.println("Introduce el valor de N: ");
			n = teclado.nextInt();
			suma = suma + n;
			
		}
		
		int media = suma/10;
		System.out.println("La media de los valores introducidos es igual a " + media);
	}
}
