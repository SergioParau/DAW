import java.util.*;
public class Ejercicio03a {

	public static void main(String[] args) {
		
		int mes;
		Scanner input = new Scanner(System.in);

		do{
			System.out.println("Introduce un número de mes entre 1 y 12");
			mes = input.nextInt();
		}while(mes<1||mes>12);
		
	}

}
