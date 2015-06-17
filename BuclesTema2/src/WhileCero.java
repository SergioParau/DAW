import java.util.*;
public class WhileCero {
	public static void main(String []args){
		
		int num=1;
		int suma= 0;
		Scanner teclado = new Scanner(System.in);
				
		while(num!=0){
			
			System.out.println("Introduce un numero entero");
			num = teclado.nextInt();
			System.out.println(suma = suma+num);
			
		}
		
		System.out.println("El valor total de la suma es " + suma);
	}
		
		
}
