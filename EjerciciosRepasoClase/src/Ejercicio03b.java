import java.util.*;

public class Ejercicio03b {

	public static void main(String[] args) {
	
	
	float total=0, nota;
	int numero_alumnos=0;
	Scanner input = new Scanner(System.in);
	
	System.out.println("Introducir primera nota (-1 para acabar): ");
	nota = input.nextFloat();
		while (nota>-1){
				total = total + nota;
				numero_alumnos++;
				System.out.println("Introducir siguiente nota (-1 para acabar): ");
				nota = input.nextFloat();
				}
				if (numero_alumnos != 0)
				System.out.println("La nota media es:" +total/numero_alumnos);
				}
}