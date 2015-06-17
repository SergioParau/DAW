import java.util.*;
public class Ejercicio6 {

	public static void main(String[] args) {
		
		String operarios[] = new String[5];
		int sueldo[] = new int[5];
		int sueldoMax = 0;
		String operadorTop = "x";
		Scanner teclado = new Scanner(System.in);
		
		
		for(int i = 0;i<5;i++){
			System.out.println("Introduzca el nombre del primo "+(i+1));
			operarios[i] = teclado.next();
			
			System.out.println("Introduzca ahora su sueldo.");
			sueldo[i] = teclado.nextInt();
			
			if(sueldo[i]>sueldoMax){
				sueldoMax = sueldo[i];
				operadorTop = operarios[i];
			}//FIN IF
			
		}//FIN FOR
		
		System.out.println("El primo que más gana es "+ operadorTop + " y su sueldo es de "+sueldoMax+"€");
	}

}
