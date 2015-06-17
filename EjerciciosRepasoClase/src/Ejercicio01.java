import java.util.*;

public class Ejercicio01 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int grupos[][] = new int[14][15];
		int alumnos[] = new int[30];
		int bajaAsist = 0;
		int grupo = 14;
		int sesion = 15;
		double sumaAsist = 0;
		int minSesion = 0;
		int minAsist = 0;
		double maxAsist = 0;
		int grupoMax = 0;
		int out = 0;
		int asistencia[] = new int[30];

		for (int i = 0; i < grupo; i++) {
			System.out.println("Alumnos matriculados en el grupo " + i);
			alumnos[i] = input.nextInt();
		}

		for (int i = 0; i < grupo; i++) {

			bajaAsist = 0;
			sumaAsist = 0;

			for (int j = 0; j < sesion; j++) {

				System.out.println("Asistencia de alumnos del grupo " + i
						+ " en la sesión " + j);

				grupos[i][j] = input.nextInt();
				sumaAsist = sumaAsist + grupos[i][j];

				if (j == 0) {
					minSesion = 0;
					minAsist = grupos[i][j];

				}

				if (grupos[i][j] < minAsist) {
					minSesion = j;
				}

				if (grupos[i][j] < (alumnos[i] / 2)) {
					bajaAsist++;
					System.out.println(bajaAsist);

				}
				if (bajaAsist >= 10) {
					System.out.println("El grupo " + i
							+ " ha sido desestimado por falta de asistencia.");
					j = sesion;
					out++;
				}

			}// CIERRE FOR j

			double mediaAsist = sumaAsist / sesion;

			if (bajaAsist < 10) {
				System.out.println("La media de asistencia del grupo " + i
						+ " es de " + mediaAsist);
				System.out
						.println("La sesión con menos asistencia ha sido la sesión "
								+ minSesion);
				asistencia[i] = 1;

			}

			if (bajaAsist < 10 && i == 0) {
				maxAsist = mediaAsist;

			}

			if (bajaAsist < 10 && mediaAsist > maxAsist) {
				maxAsist = mediaAsist;
				grupoMax = i;

			}

		}// CIERRE FOR i

		if (asistencia[grupoMax] == 1) {
			System.out
					.println("El grupo con mayor media de asistencia ha sido el "
							+ grupoMax
							+ " con una media de asistencia de "
							+ maxAsist);
		}

		if (out == grupo) {
			System.out
					.println("Todos los grupos han sido desestimados por falta de asistencia.");
		}
	}

}
