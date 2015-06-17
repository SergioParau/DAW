package GestionBiblioteca;

import java.util.*;


public class GestorBiblioteca {

	public static int menu(Scanner tec) {

		System.out.println("******** MENÚ PRINCIPAL *********");
		System.out.println("1. USUARIO");
		System.out.println("2. LIBROS");
		System.out.println("3. PRESTAMO");
		System.out.println("4. GUARDAR");
		System.out.println("0. TERMINAR");
		System.out.println("*********************************");
		System.out.println("Elige una opción");

		return tec.nextInt();
	}

	public static int submenu(int submenu, Scanner tec) {

		int subopcion = 0;

		switch (submenu) {

		case 1:
			subopcion = submenuUsuario(tec);
			break;
		case 2:
			subopcion = submenuLibros(tec);
			break;
		case 3:
			subopcion = submenuPrestamos(tec);
		}

		return subopcion;
	}

	public static int submenuUsuario(Scanner tec) {

		System.out.println("********* MENÚ USUARIOS *********");
		System.out.println("********* 1.Alta Usuario *********");
		System.out.println("********* 2.Baja Usuario *********");
		System.out.println("********* 3.Información Usuario *********");
		System.out.println("********* 0. Terminar *********");
		System.out.println("*********************************");

		return tec.nextInt();
	}

	public static int submenuLibros(Scanner tec) {

		System.out.println("********* MENÚ LIBROS *********");
		System.out.println("********* 1.Alta Libro *********");
		System.out.println("********* 2.Información Libro *********");
		System.out.println("********* 0. Terminar *********");
		System.out.println("*********************************");

		return tec.nextInt();
	}

	public static int submenuPrestamos(Scanner tec) {

		System.out.println("********* MENÚ PRÉSTAMOS *********");
		System.out.println("********* 1.Número de préstamos activos *********");
		System.out.println("********* 2.Número de préstamos sancionados *********");
		System.out.println("********* 3.Histograma de préstamos *********");
		System.out.println("********* 0. Terminar *********");
		System.out.println("*********************************");

		return tec.nextInt();
	}

	/*
	 * 
	 * 
	 * METODO MAIN
	 */

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Biblioteca biblio = new Biblioteca();
		int opcion = 0;
		int subopcion = 0;

		do {
			opcion = menu(input);
			do {
				switch (opcion) {
				// SUBMENU USUARIOS
				
				case 1:
					Scanner inputUser = new Scanner(System.in);
					subopcion = submenu(opcion, input);
					switch (subopcion) {

					case 1:// ALTA USUARIO
						System.out.println("Introduzca los datos del usuario que desea dar de alta: ");
						System.out.print("Nombre:");
						String nombre = inputUser.nextLine();
						System.out.print("DNI:");
						int id = inputUser.nextInt();
						System.out.print("Dirección:");
						String direccion = inputUser.next();
						Usuario u = new Usuario(nombre, id, direccion);
						biblio.altaUsuario(u);
						System.out.println("Usuario dado de alta satisfactoriamente");
						System.out.println(u.toString());
						break;
					case 2:// BAJA USUARIO
						System.out.println("Introduzca el DNI del usuario que desea dar de baja");
						int dni = inputUser.nextInt();
						biblio.bajaUsuario(dni);
						break;
					case 3:// INFORMACION USUARIO
						System.out.println("Introduzca el DNI del usuario del que desea obtener información.");
						id = inputUser.nextInt();
						Usuario u1 = biblio.getUsuario(id);
						if (u1 != null) {
							System.out.println("Usuario encontrado:");
							System.out.print(u1.toString());
						} else {
							System.out.println("El dni introducido no se corresponde con ningún usuario.");
						}
						break;
					case 0:
						biblio.guardar();
						System.out.println("Saliendo de usuario.");
						break;
					}
					break;

				// SUBMENU LIBROS
				case 2:
					Scanner inputLibro = new Scanner(System.in);
					subopcion = submenu(opcion, input);
					switch (subopcion) {
					case 1:// ALTA LIBRO
						System.out.println("Introduzca los datos del libro para darlo de alta");
						System.out.print("Nombre:");
						String nombreLibro = inputLibro.nextLine();
						System.out.print("Autor:");
						String autor = inputLibro.nextLine();
						System.out.print("Año: ");
						int anyo = inputLibro.nextInt();
						System.out.print("Editorial:");
						String editorial = inputLibro.next();
						System.out.print("ISBN");
						String isbn = inputLibro.next();
						Libro libro = new Libro(nombreLibro, autor, anyo, editorial, isbn);
						biblio.altaLibro(libro);
						break;
					case 2:// INFORMACION LIBRO
						System.out
								.println("Introduzca el título del libro del que desea información.");
						nombreLibro = inputLibro.next();
						Libro libro1 = biblio.getLibro(nombreLibro);
						if (libro1 != null) {
							System.out.println(libro1.toString());
						} else {
							System.out
									.println("El libro no se encuentra en nuestra base de datos.");
						}
						break;
					case 0:// SALIR MENU LIBROS
						biblio.guardar();
						System.out.println("Saliendo del menú de libros.");
					}
					break;
				// SUBMENU PRESTAMOS
				case 3:
					subopcion = submenu(opcion, input);
					switch (subopcion) {
					case 1:// PRESTAMOS ACTIVOS
						System.out.println("Número de préstamos activos:"
								+ biblio.getNumPrestamosActivos());
						break;
					case 2:// PRESTAMOS SANCIONADOS
						System.out.println("Número de préstamos sancionados:"+biblio.getNumPrestamosSanciones());
						break;
					case 3://HISTOGRAMA
						System.out.print(biblio.histograma());
						break;
					case 0://TERMINAR
						biblio.guardar();
						break;
					}
				}

			} while (subopcion != 0);

		} while (opcion != 0);

	}
}