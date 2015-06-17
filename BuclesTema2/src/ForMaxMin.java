import java.util.Scanner;
public class ForMaxMin {
	public static void main(String[] args){
		
		int i,n,numero,max=0,min=0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el numero de enteros requeridos: ");
		n = teclado.nextInt();
		
		for(i=1; i<=n;i++){
			System.out.println("Introduzca un numero entero: ");
			numero = teclado.nextInt();
			
			if(i==1){
				max = numero;
				min = numero;
			}
			
			if(numero>max){
				max = numero;
		}
			if(numero<min){
				min = numero;
			}
		
		
		}//CIERRE BUCLE
		
		System.out.println("El valor maximo es: " + max);
		System.out.println("El valor minimo es: " + min);
	
	}
	
}
