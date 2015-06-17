import java.util.*;
public class EjercicioLetra {
	public static void main (String[] args){
		
		/*String one = "A";
		String two = "B";
		String three = "C";
		String four = "D";
		String five = "E";
		String calificacion;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca la nota obtenida: ");
		calificacion = teclado.next();
		
		if(calificacion.equals(one)){
			System.out.println("La nota obtenida es equivalente a un 10.");
		} else if (calificacion.equals(two)){
			System.out.println("La nota obtenida es equivalente a un 8.");
		} else if (calificacion.equals(three)){
			System.out.println("La nota obtenida es equivalente a un 6.");
		} else if (calificacion.equals(four)){
			System.out.println("La nota obtenida es equivalente a un 5.");
		} else if (calificacion.equals(five)){
			System.out.println("La nota obtenida es equivalente a un 0.");
		}*/
	
		char one = 'A';
		char two = 'B';
		char three = 'C';
		char four = 'D';
		char five = 'E';
		char calificacion;
		Scanner teclado = new Scanner(System.in);
		
		
		System.out.println("Introduzca la nota obtenida: ");
		calificacion = teclado.next().charAt(0);
		
		
		switch(calificacion){
		case 'A':
			System.out.println("La nota obtenida es equivalente a un 10.");
		break;
		
		case 'B':
			System.out.println("La nota obtenida es equivalente a un 8.");
		break;
		
		case 'C':
			System.out.println("La nota obtenida es equivalente a un 6.");
		break;
		
		case 'D':
			System.out.println("La nota obtenida es equivalente a un 5.");
		break;
		
		case 'E':
			System.out.println("La nota obtenida es equivalente a un 0.");
		break;
		}
	
	
	
	}
}
