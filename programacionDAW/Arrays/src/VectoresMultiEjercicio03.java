import java.util.*;
public class VectoresMultiEjercicio03 {

	public static void main(String[] args) {
		
		int matriz[][] = new int[4][4];
		int filaA;
		int filaB;
		int aux[][] = new int[1][1];
		Scanner input = new Scanner(System.in);
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.println("Introduce el valor de la posición "+i+","+j);
				matriz[i][j] = input.nextInt();
			}
		}
		
		System.out.println("Introduzca las filas que quiera intercambiar: ");
		filaA = input.nextInt();
		filaB = input.nextInt();
		
		aux[0] = matriz[filaA];
		matriz[filaA]=matriz[filaB];
		matriz[filaB] =aux[0];
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print(matriz[i][j]+" ");
				
			}System.out.println();
		}
	}

}
