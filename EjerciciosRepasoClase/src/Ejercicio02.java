import java.util.*;
public class Ejercicio02 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int numeros[] = new int[10];
		int rep = 0;
		int max = 0;
		
		for(int i=0;i<numeros.length;i++){
			System.out.println("Introduce el valor para la posición "+i);
			numeros[i] = input.nextInt();
		}
		
		for(int i=0;i<numeros.length;i++){
			
			if(i==0){
				
				max = numeros[i];
			}
			
			if(numeros[i]>max){
				max = numeros[i];
			}
			
		}
		
		System.out.println(max);
		
		for(int j = 0;j<numeros.length;j++){
			if(numeros[j]==max){
				rep++;
			}
		}
		
		System.out.println("El número mayor es "+max+" y aparece "+rep+" veces");
	}

}
