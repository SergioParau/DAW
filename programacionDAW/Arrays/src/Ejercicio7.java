import java.util.*;
public class Ejercicio7 {

	public static void main(String[] args) {
		
			Scanner teclado = new Scanner(System.in);
			int n = 0;
			int sueldoMin = 0;
			int repeticion = 0;
			
			System.out.println("Introduce el número de elementos a introducir");
			n = teclado.nextInt();
			
			int sueldo[] = new int[n];
			
			for(int i=0;i<n;i++){
				System.out.println("Introduce el sueldo "+(i+1));
				sueldo[i] = teclado.nextInt();
				
				if(i==0){
					sueldoMin = sueldo[i];
				}
				if(sueldo[i]<sueldoMin){
					sueldoMin = sueldo[i];
				}
				
			}//FIN FOR
			
			for(int v=0;v<n;v++){
				if(sueldo[v]==sueldoMin){
					repeticion++;
				}
			}
			
			
			
			System.out.println("El sueldo mínimo es " + sueldoMin + " y aparece "+repeticion+" veces.");
		
			
			
	}//FIN MAIN
}//FIN CLASS
