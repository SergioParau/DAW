import java.util.*;

public class VectoresMultiEjercicio06 {

	public static void main(String[] args) {

		int magia[][] = new int[3][3];
		int suma = 0;
		int CLAVE = 15;
		int mal = 0;
		int repeticion[] = new int[10];
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			repeticion[i] = 0;
		}

		for (int i = 0; i < 3; i++) {
			System.out.println("Fila " + i);
			for (int j = 0; j < 3; j++) {
				System.out.println("Introduce el valor de la posición " + j);
				magia[i][j] = input.nextInt();

					do {
						if (repeticion[magia[i][j]] == 0) {

							repeticion[magia[i][j]] = 1;
							
						} else if (repeticion[magia[i][j]] == 1) {
							System.out.println("Por favor, introduce otro número. Este ya ha sido introducido.");
							while(repeticion[magia[i][j]]==1){
							System.out.println("Introduce el valor de la posición " + j);
							magia[i][j] = input.nextInt();
							}
						}
					}while (repeticion[magia[i][j]] == 0);
				
				while (magia[i][j] < 1 || magia[i][j] > 9) {
					System.out
							.println("Por favor, introduce un valor válido entre 1 y 9");
					magia[i][j] = input.nextInt();
				}

			}
		}

		for (int i = 0; i < 3; i++) {
			suma = 0;
			for (int j = 0; j < 3; j++) {
				suma = suma + magia[i][j];
				// System.out.println(suma);
			}
			if (suma != CLAVE) {
				mal++;
			}
		}

		for (int i = 0; i < 3; i++) {
			suma = 0;
			for (int j = 0; j < 3; j++) {
				suma = suma + magia[j][i];
				// System.out.println(suma);
			}
			if (suma != CLAVE) {
				mal++;
			}
		}

		suma = 0;

		for (int i = 0; i < 3; i++) {

			suma = suma + magia[i][i];

			// System.out.println(suma);

		}
		if (suma != CLAVE) {
			mal++;
		}

		suma = 0;

		for (int i = 0; i < 3; i++) {

			suma = suma + magia[i][2 - i];

			// System.out.println(suma);

		}
		if (suma != CLAVE) {
			mal++;
		}

		if (mal == 0) {
			System.out
					.println("Este cubo es tan mágico como el culo de Houdini.");
		} else {
			System.out
					.println("Este cubo es menos mágico que las políticas de Rajoy.");
		}
	}

}
