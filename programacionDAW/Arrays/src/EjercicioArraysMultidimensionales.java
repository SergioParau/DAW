import java.util.*;

public class EjercicioArraysMultidimensionales {

	public static void main(String[] args) {

		char opcion = 'z';
		int codigo = 0;
		double ordenadores[][] = new double[5][20];
		int sala = 0;
		int equipo = 0;
		int disponibles = 0;
		int disponible[] = new int[5];
		int ocupado[] = new int[5];
		int ocupados = 0;
		Scanner input = new Scanner(System.in);

		while (codigo != 4) {

			System.out.println();
			System.out.println("Seleccione la opción del menú: ");
			System.out.println("1. Asignar o Cancelar un turno");
			System.out.println("2. Cantidad de equipos disponibles");
			System.out.println("3. Cantidad de turnos asignados");
			System.out.println("4. Salir");
			codigo = input.nextInt();

			while (codigo < 1 || codigo > 4) {
				System.out.println("Introduzca un código válido 1-4:");
				codigo = input.nextInt();

			}// FIN WHILE CODIGO ERRONEO

			switch (codigo) {

			case 1:// ASIGNAR-CANCELAR

				System.out
						.println("Por favor, pulse 'a' si desea asignar una reserva o 'c' si desea cancelar una reserva");
				opcion = input.next().charAt(0);

				while (opcion != 'a' && opcion != 'c') {
					System.out
							.println("Por favor, introduzca una de las dos opciones.");
					opcion = input.next().charAt(0);
				}// FIN WHILE OPCION ERRONEA

				if (opcion == 'a') {

					System.out
							.println("Seleccione sala y ordenador a reservar:");
					System.out.println("Sala (0-4)");
					sala = input.nextInt();
					while (sala < 0 || sala > 4) {
						System.out.println("Introduzca una sala válida (0-4)");
						sala = input.nextInt();
					}
					System.out.println("Equipo (0-19)");
					equipo = input.nextInt();
					while (equipo < 0 || equipo > 19) {
						System.out
								.println("Introduzca un equipo válido (0-19)");
						equipo = input.nextInt();
					}

					if (ordenadores[sala][equipo] == 1) {
						while (ordenadores[sala][equipo] == 1) {
							System.out
									.println("el ordenador está ocupado. Por favor, elija otro.");
							System.out.println("Sala (0-4)");
							sala = input.nextInt();
							System.out.println("Equipo (0-19)");
							equipo = input.nextInt();

						}
						if (ordenadores[sala][equipo] == 0) {
							System.out
									.println("Ha reservado el equipo solicitado.");
							ordenadores[sala][equipo] = 1;
						}
					}

					else {

						System.out
								.println("Ha reservado el equipo solicitado.");
						ordenadores[sala][equipo] = 1;
					}

				}// FIN ASIGNAR

				if (opcion == 'c') {
					System.out
							.println("Seleccione sala y ordenador a cancelar: ");
					System.out.println("Sala (0-4)");
					sala = input.nextInt();
					while (sala < 0 || sala > 4) {
						System.out.println("Introduzca una sala válida (0-4)");
						sala = input.nextInt();
					}
					System.out.println("Equipo (0-19)");
					equipo = input.nextInt();
					while (equipo < 0 || equipo > 19) {
						System.out
								.println("Introduzca un equipo válido (0-19)");
						sala = input.nextInt();
					}

					if (ordenadores[sala][equipo] == 0) {
						System.out.println("Este ordenador ya está vacío.");

						if (ordenadores[sala][equipo] == 1) {

							ordenadores[sala][equipo] = 0;
							System.out
									.println("Ha cancelado el equipo deseado.");
						}

					} else {

						ordenadores[sala][equipo] = 0;

						System.out.println("Ha cancelado el equipo deseado.");

					}

				}// FIN CANCELAR

				break;

			case 2:// ORDENADORES DISPONIBLES

				for (int i = 0; i < 5; i++) {
					
					disponibles = 0;
					
					for (int j = 0; j < 20; j++) {
						
						if (ordenadores[i][j] == 0) {
							
							disponible[i] = j;
							disponibles++;
							System.out.print((disponible[i]+1)+" ");
							
							
						}

					}
				System.out.println();
				System.out.println("Estos son los ordenadores disponibles en la sala "+i+" con un total de "+disponibles+" equipos disponibles");	
				System.out.println();
				}

				break;

			case 3:// ORDENADORES OCUPADOS
				
				for (int i = 0; i < 5; i++) {
					
					ocupados = 0;
					
					for (int j = 0; j < 20; j++) {
						if (ordenadores[i][j] == 1) {
							ocupado[i] = j ;
							ocupados++;
							System.out.print((ocupado[i]+1)+" ");
						}
					}

					System.out.println();
					System.out.println("Estos son los ordenadores ocupados en la sala "+i+" con un total de "+ocupados+" equipos ocupados");	
					System.out.println();

				}

				break;

			case 4:

				System.out
						.println("Gracias por utilizar el sistema de reservas de FloridaUni.");

				break;

			}
		}// FIN BUCLE PROGRAMA
	}// FIN MAIN

}// FIN CLASS
