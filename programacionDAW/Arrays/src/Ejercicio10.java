import java.util.*;
public class Ejercicio10 {

	public static void main(String[] args) {
		
		int enteros[] = new int[10];
		Scanner input = new Scanner(System.in);
		int v = 0;
		
		
		for(int i = 0;i<enteros.length;i++){
		System.out.println("Introduce un número");
		enteros[i] = input.nextInt();
		}
		
		for(int j=0;j<enteros.length;j++){
			System.out.println();
			for(int i = 1;i<enteros[j];i++){
				
				System.out.print(i+" ");
				
			}
			
			
		}
		
	}

}
