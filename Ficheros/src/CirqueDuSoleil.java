import java.util.*;
import java.io.*;

public class CirqueDuSoleil {

	public static void main(String[] args) {

		int n = 13;
		int actuaciones[] = new int[13];
		int menu = 0;
		String ciudadMax = "none";
		long ingresosMax = 0;
		String ciudadMin = "none";
		long ingresosMin = 0;
		String checkCiudad;
		long mediaIngresos = 0;
		long sumaIngresos = 0;
		int histograma[] = new int[11];
		Scanner inTeclado = new Scanner(System.in);

		/*
		 * System.out.println(
		 * "Introduzca el número de ciudades visitadas por el circo:"); n =
		 * input.nextInt();
		 */

		int ciudades[] = new int[n];
		String nombreCiudad[] = new String[n];
		long ingresos[] = new long[n];

		Scanner input = null;
		PrintWriter out = null;
		try {

			input = new Scanner(new FileReader("ActividadEconomica.txt"));

			for (int i = 0; i < ciudades.length; i++) {

				// System.out.println("Introduce el nombre de la ciudad "+i);
				nombreCiudad[i] = input.next();

				// System.out.println("Introduce el número de actuaciones realizadas en "+nombreCiudad[i]);
				actuaciones[i] = input.nextInt();

				/*
				 * if(actuaciones[i]>10){ System.out.println(
				 * "Por favor, recuerda que el número máximo de actuaciones por ciudad es de 10."
				 * );
				 * System.out.println("Introduce de nuevo el número de actuaciones."
				 * ); actuaciones[i] = input.nextInt(); }
				 */

				// System.out.println("Introduce los ingresos obtenidos en "+nombreCiudad[i]);
				ingresos[i] = input.nextLong();
				sumaIngresos = sumaIngresos + ingresos[i];

			}// for

		} catch (FileNotFoundException e) {
			System.out.println("Error abriendo el fichero ");
		} finally {
			if (input != null) {
				input.close();
			}
		}

		do {
			System.out.println("Teclee la opción deseada:");
			System.out.println("1. Mostrar Actuaciones por ciudad");
			System.out.println("2. Mostrar Recaudación Máxima");
			System.out.println("3. Mostrar Recaudación Mínima");
			System.out.println("4. Mostrar Histograma de Actuaciones");
			//System.out.println("5. Mostrar Ingresos Medios");
			System.out.println("5. Generar informe con ingresos medios.");
			System.out.println("6. Salir");
			menu = inTeclado.nextInt();

			switch (menu) {

			case 1:

				System.out
						.println("Introduzca la ciudad de la que desea saber los datos:");
				checkCiudad = inTeclado.next();

				int i = 0;
				boolean ciudad = false;

				while (ciudad == false && i < ciudades.length) {
					if (checkCiudad.compareTo(nombreCiudad[i]) == 0) {
						ciudad = true;
					} else {
						i++;
					}

				}

				if (ciudad == true) {
					System.out.println(actuaciones[i]);
					System.out.println(ingresos[i] + "€");
					break;
				} else {
					System.out
							.println("Esta ciudad no se encuentra en la gira del circo.");
				}

			case 2:

				for (i = 0; i < ciudades.length; i++) {

					if (i == 0) {
						ciudadMax = nombreCiudad[i];
						ingresosMax = ingresos[i];
					}

					if (ingresos[i] > ingresosMax) {
						ciudadMax = nombreCiudad[i];
						ingresosMax = ingresos[i];
					}

				}

				System.out
						.println("La ciudad donde se generaron más ingresos fue "
								+ ciudadMax);
				System.out.println("Se generaron " + ingresosMax + " euros");
				break;

			case 3:

				for (i = 0; i < ciudades.length; i++) {

					if (i == 0) {
						ciudadMin = nombreCiudad[i];
						ingresosMin = ingresos[i];
					}

					if (ingresos[i] < ingresosMin) {
						ciudadMin = nombreCiudad[i];
						ingresosMin = ingresos[i];
					}

				}

				System.out
						.println("La ciudad donde se generaron menos ingresos fue "
								+ ciudadMax);
				System.out.println("Se generaron " + ingresosMax + " euros");
				break;

			case 4:

				for (i = 0; i < actuaciones.length; i++) {

					histograma[actuaciones[i]]++;
				}

				for (int j = 1; j < histograma.length; j++) {

					System.out.print("Ciudades con " + j + " actuaciones:");

					while (histograma[j] != 0) {

						System.out.print(" * ");
						histograma[j]--;

					}
					System.out.println();

				}
				break;

			case 5:

				mediaIngresos = sumaIngresos / n;

				// System.out.println("Los ingresos medios son de "+mediaIngresos+" euros.");

				//for (i = 0; i < ciudades.length; i++) {

					try {
						
						out = new PrintWriter("InformeGestion.txt");
						// escribe los datos en el fichero
						out.println("Informe de la actividad económica:");
						out.println("__________________________________");
						out.println();
						out.println("Recaudación media: " + mediaIngresos + "€");
						out.println();
						out.println("Ciudades que están por encima de la media:");
						out.println();
						for(i=0;i<n;i++){
						if (ingresos[i] > mediaIngresos) {
							
							out.println(nombreCiudad[i] + ": " + ingresos[i]+" euros.");
						}
						}
					} catch (IOException e) {
						System.out.println("Error: " + e);
					} finally {
						if (out != null)
							out.close();
					//}

					/*
					 * if(ingresos[i]>mediaIngresos){
					 * //System.out.println("Los ingresos de "
					 * +nombreCiudad[i]+" están por encima de la media."); }
					 */

				}

			}// FIN SWITCH

		} while (menu > 0 && menu < 7);

	}

}
