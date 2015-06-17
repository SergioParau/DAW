import java.util.*;
public class Ejercicio11 {

	public static void main(String[] args) {
		
		int enteros[] = new int[5];
		Scanner input = new Scanner(System.in);
		int v = 0;
		int vMax = 0;
		int posMax = 0;
		
		
		
		for(int i = 0;i<enteros.length;i++){
		System.out.println("Introduce un número");
		enteros[i] = input.nextInt();
		}
		
		for(int j = 0; j<enteros.length;j++){
			
			int num = enteros[j];
			
			v=0;
			
			while(num!=0){
				
				num/=10;
				v++;
			}
			
			if(j==0){
				vMax = v;
			}
			
			if(v>vMax){
				vMax = v;
				posMax = j;
				
			}
		}
		
		System.out.println("El vector con más dígitos está en la posición "+(posMax+1));
	}

}
