import java.util.*;
public class VectoresMultiEjercicio01 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int numeros[][] = new int[2][4];
		int numeros2[][] = new int[4][2];
		
		
		for(int i=0;i<2;i++){
			for(int j=0;j<4;j++){
				
				System.out.println("Introduzca el valor para "+i+" y "+j);
				numeros[i][j] = input.nextInt();
								
			}
				
		}
		
		for(int i=0;i<4;i++){
			for(int j = 0;j<2;j++){
				
				numeros2[i][j]=numeros[j][i];
				System.out.print(numeros2[i][j]);
			}System.out.println();
		}
	}

}
