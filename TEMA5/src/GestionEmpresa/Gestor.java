package GestionEmpresa;
import java.util.*;

public class Gestor {

	public static int menu(Scanner input) {

		input = new Scanner(System.in);
		int select;

		System.out.println("******MENÚ PRINCIPAL******");
		System.out.println("1.Número de trabajadores");
		System.out.println("2.Buscar datos de un trabajador. Introduzca DNI:");
		System.out.println("3.Añadir un trabajador");
		System.out.println("4.Borrar un trabajador");
		System.out.println("5.Listar trabajadores");
		System.out.println("6.Histograma de antigüedad");
		System.out.println("0.Salir del programa");
		select = input.nextInt();

		return select;

	}

	public static void main(String args[]) {

		Empresa geekshub = new Empresa();
		Scanner input = new Scanner(System.in);
		String numDni;
		String NIF;
		int opcion;
		String nombre;
		int antiguedad;
		int salario;
		String dept;
		int anyosEmpresa = 30;

		do {

			opcion = menu(input);

			switch (opcion) {
			case 1:
				System.out.println(geekshub.getNumTrabajadores()
						+ " trabajadores.");
				break;

			case 2:

				geekshub.existeEmpleado(NIF = input.nextLine());
				if (geekshub.existeEmpleado(NIF)) {
					System.out.println(geekshub.getIdEmpleado(numDni = NIF));
					System.out.println(geekshub.getInfoEmpleado(numDni));
				} else {
					System.out
							.println("El DNI solicitado no se corresponde con ningún empleado. ");
				}
				break;

			case 3:

				System.out
						.println("Introduzca los datos del trabajador en el siguiente orden:");
				System.out.print("Nombre:");
				nombre = input.next();
				System.out.print("DNI:");
				NIF = input.next();
				System.out.print("Antigüedad:");
				antiguedad = input.nextInt();
				if (antiguedad > anyosEmpresa) {
					System.out
							.println("La antigüedad del trabajador es mayor que la propia empresa. Introduzca un valor menor de 30.");
					antiguedad = input.nextInt();
				}
				System.out.print("Salario:");
				salario = input.nextInt();
				System.out.print("Departamento:");
				dept = input.next();

				Trabajador T1 = new Trabajador(nombre, NIF, antiguedad,
						salario, dept);

				geekshub.anyadirEmpleado(T1);

				break;

			case 4:

				System.out
						.println("Introduzca el DNI del trabajador que desea borrar:");
				NIF = input.next();
				System.out.println(geekshub.cancelarEmpleado(NIF));
				break;

			case 5:

				System.out.println(geekshub.listarEmpleados());
				break;

			case 6:
				System.out.println(geekshub.toHistograma());
				break;

			case 0:
				geekshub.guardar();
			}
		} while (opcion != 0);
	}

}
