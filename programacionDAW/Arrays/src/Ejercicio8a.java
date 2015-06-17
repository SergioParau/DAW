import java.util.*;
public class Ejercicio8a {
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		int sueldo[] = new int[10];
		int aux;
		
		
		for(int n=0;n<sueldo.length;n++){
			
		System.out.println("Introduce el sueldo "+(n+1));
		sueldo[n] = teclado.nextInt();
		}
		
		for(int i=0;i<(sueldo.length-1);i++){
			
			if(sueldo[i]>sueldo[i+1]){
				aux = sueldo[i];
				sueldo[i] = sueldo[i+1];
				sueldo[i+1]= aux;
			}
		}
		
		for(int j=(sueldo.length-1);j>0;j--){
			
			if(sueldo[j]<sueldo[j-1]){
				aux = sueldo[j];
				sueldo[j] = sueldo[j-1];
				sueldo[j-1] = aux;
			}
		}
		
		for (int p = 0;p<sueldo.length;p++){
			System.out.println(sueldo[p]);
		}
	}
}
