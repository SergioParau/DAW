import java.util.*;
public class Ejercicio8 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int sueldo[] = new int[5];
		int aux;
		
		
		for(int n=0;n<sueldo.length;n++){
			
		System.out.println("Introduce el sueldo "+(n+1));
		sueldo[n] = teclado.nextInt();
		}
		
		for (int i=0;i<5;i++){
			
			for(int j=0;j<4;j++){
				
				if(sueldo[j]>sueldo[j+1]){
					aux = sueldo[j];
					sueldo [j] = sueldo[j+1];
					sueldo[j+1] = aux;
				}
			
			}
		}
		
		for (int p = 0;p<sueldo.length;p++){
			System.out.println(sueldo[p]);
		}
		
	}

}
