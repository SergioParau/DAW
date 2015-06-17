import java.util.*;

public class VectoresMultiEjercicio02 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int filas;
		int columnas;
		int sumaPos = 0;
		int sumaNeg = 0;

		System.out.println("Introduce las filas de la matriz:");
		filas = input.nextInt();
		System.out.println("Introduce ahora las columnas de la matriz:");
		columnas = input.nextInt();

		int matriz[][] = new int[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.println("Introduce el valor para la posición " + i
						+ "," + j);
				matriz[i][j] = input.nextInt();
			}
		}

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				
				if(matriz[i][j]>=0){
					sumaPos = sumaPos + matriz[i][j];
				}
				
				if(matriz[i][j]<0){
					sumaNeg = sumaNeg + matriz[i][j];
				}

			}
		}
		
		System.out.println("La suma de los números positivos es igual a "+sumaPos);
		System.out.println("La suma de los números negativos es igual a "+sumaNeg);
	}

}
