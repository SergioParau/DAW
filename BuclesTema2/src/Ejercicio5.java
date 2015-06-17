import java.util.*;
public class Ejercicio5 {
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		int edad;
		int media = 0;
		int personas = 0;
		int edadTotal = 0;
		
		do{
			System.out.println("Introduce la edad del asistente: ");
			edad = teclado.nextInt();
			edadTotal = edadTotal + edad;
			if(edad>0){
				personas++;
			}
		}while(edad>0);//FIN DO
		
		media = edadTotal/personas;
		
		System.out.println("La media de edad es de: " + media);
		
	}//FIN MAIN
}//FIN CLASS
