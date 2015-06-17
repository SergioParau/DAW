import java.util.Scanner;
public class WhileNegativo {
	public static void main(String []args){
		
		int num=0;
		int suma= 0;
		Scanner teclado = new Scanner(System.in);
				
		while(num>=0){
			
			System.out.println("Introduce un número entero");
			num = teclado.nextInt();
			if(num>=0){
			System.out.println("El valor de la suma es ahora: " + (suma = suma+num));
			}
			
		}
		
		System.out.println("El valor total de la suma es " + suma);
	}
}
