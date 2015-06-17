import java.util.*;
public class Ejercicio7 {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int numero;
		int digitos=0;
		int digitosUsuario=1;
		
		System.out.println("Introduzca el número: ");
		numero = teclado.nextInt();
		
		while(digitos!=digitosUsuario){
			System.out.println("Introduzca ahora el número de dígitos: ");
			digitosUsuario = teclado.nextInt();
		
			while(numero!=0){
				digitos++;
				numero = numero/10;
			}
		
		if(digitos == digitosUsuario){
		
		System.out.println("El número es correcto");
		
		}else{
			System.out.println("El número no es correcto");
		}
		}
		
		
		
		
	}//FIN MAIN
}//FIN CLASS
