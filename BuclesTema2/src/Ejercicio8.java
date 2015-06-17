import java.util.*;
public class Ejercicio8 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		char letra;
		
		System.out.println("Introduzca la letra deseada: ");
		letra = teclado.next().charAt(0);
		
		while(letra>='a'&&letra<='z'){
		System.out.println(Character.toUpperCase(letra));
		System.out.println("Introduzca otra letra: ");
		letra = teclado.next().charAt(0);
		}
		
		System.out.println("El valor introducido no es válido");
		
	}//FIN MAIN

}//FIN CLASS
