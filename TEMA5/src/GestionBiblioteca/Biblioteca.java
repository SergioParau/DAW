package GestionBiblioteca;

import java.io.*;
import java.security.acl.LastOwnerException;
import java.util.*;

public class Biblioteca {

	private Usuario[] usuarios;
	private Libro[] libros;

	public Biblioteca() {

		/*
		 * int maxLibros; int maxUsuarios; String tituloLibro; String
		 * autorLibro; int anyoLibro; String editorial; String isbn = " ";
		 * String nombreUser; String idUser; String direccion; int
		 * num_prestamos; int id_prestamo; String libroPrestamo; String
		 * inicioPrestamo; String finPrestamo;
		 */
		boolean sancion = true;
		// String estado;
		Scanner in = null;

		try {

			in = new Scanner(new FileReader("infoBiblioteca.txt"));
			in.next();
			int max_id_prestamos = in.nextInt();
			//System.out.println("Max_id_prestamo:" + max_id_prestamos);
			Prestamo.setNumPrestamos(max_id_prestamos);

			in.next();
			int maxLibros = in.nextInt();
			//System.out.println(maxLibros);
			in.next();
			int maxUsuarios = in.nextInt();
			//System.out.println(maxUsuarios);
			usuarios = new Usuario[maxUsuarios];
			libros = new Libro[maxLibros];

			String cadena1 = in.nextLine();
			String cadena2 = in.nextLine();
			String cadena3 = in.nextLine();

			in.useDelimiter(";");

			int i = 0;

			String tituloLibro = in.next();

			while (!tituloLibro.contains("Prestamo")) {

				//System.out.print(tituloLibro + ".");
				String autorLibro = in.next();
				//System.out.print(autorLibro + ".");
				int anyoLibro = in.nextInt();
				//System.out.print(anyoLibro + ".");
				String editorial = in.next();
				//System.out.print(editorial + ".");
				String isbn = in.next();
				//System.out.println(isbn + ".");

				libros[i] = new Libro(tituloLibro, autorLibro, anyoLibro,
						editorial, isbn);

				tituloLibro = in.next();
				i++;
			}

			in.nextLine();
			i = 0;

			while (in.hasNext()) {

				String nombreUser = in.next();
				//System.out.println("Nombre:" + nombreUser);
				int idUser = in.nextInt();
				//System.out.println("ID:" + idUser);
				String direccion = in.next();
				//System.out.println("Direccion:" + direccion);
				int num_prestamos = in.nextInt();
				//System.out.println("Num.Prestamos:" + num_prestamos);

				Prestamo[] prestamos = new Prestamo[10];
				in.nextLine();

				for (int j = 0; j < num_prestamos; j++) {

					int id_prestamo = in.nextInt();
					//System.out.println("idPrestamo:" + id_prestamo);
					String libroPrestamo = in.next();
					//System.out.println("Titulo:" + libroPrestamo);
					String inicioPrestamo = in.next();
					//System.out.println("Inicio:" + inicioPrestamo);
					String finPrestamo = in.next();
					//System.out.println("Fin:" + finPrestamo);
					String multa = in.next();
					if (multa.equals("-")) {
						sancion = false;
					} else if (multa.equals("+")) {
						sancion = true;
					}
					//System.out.println("Sancion:" + sancion);
					String estado = in.next();
					//System.out.println("Estado:" + estado);
					in.nextLine();

					for (int a = 0; a < libros.length; a++) {
						// System.out.println("libroPrestamo: -"+libroPrestamo+"-");
						// if(libros[a]!=null)
						// System.out.println("libros[a].getTitulo(): -"+libros[a].getTitulo()+"-");
						if (libros[a] != null&& libros[a].getTitulo().contains(libroPrestamo)) {

							prestamos[j] = new Prestamo(id_prestamo,inicioPrestamo, finPrestamo, sancion,estado, libros[a]);
							// System.out.println(prestamos[j].toString()+"\n");

						}
					}

				}

				usuarios[i] = new Usuario(nombreUser, idUser, direccion,
						prestamos);
				i++;
			}

			/*
			 * for(int z=0;usuarios[z]!=null&&z<usuarios.length;z++)
			 * System.out.println(usuarios[z].toString());
			 */

		} catch (FileNotFoundException e) {
			System.out.println("El archivo no se ha encontrado.");
		} finally {

			if (in != null) {
				in.close();
			}
		}
	}

	public void altaUsuario(Usuario usuario_) {

		boolean alta = false;

		for (int i = 0; i < usuarios.length && !alta; i++) {
			if (usuarios[i] == null) {
				usuarios[i] = usuario_;
				alta = true;
			}
		}

	}

	public void bajaUsuario(int dni) {

		boolean baja = false;

		for (int i = 0; usuarios[i]!=null&&i < usuarios.length && !baja; i++) {
			if (usuarios[i].getDNI()==dni) {

				usuarios[i] = null;
				baja = true;
				System.out.println("El usuario con DNI " + dni
						+ " ha sido correctamente dado de baja.");

			}

		}
	}

	public void altaLibro(Libro libro_) {

		boolean alta = false;

		for (int i = 0; i < libros.length && !alta; i++) {
			if (libros[i] == null) {
				libros[i] = libro_;
				alta = true;
				System.out.println("Libro dado de alta satisfactoriamente");
			}

		}
	}

	public int getNumPrestamosActivos() {

		int activos = 0;

		for (int i = 0; usuarios[i] != null && i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				Prestamo[] prestamosActivos = usuarios[i].getPrestamosActivos();

				for (int j = 0; j < prestamosActivos.length; j++) {

					if (prestamosActivos[j] != null) {
						activos++;
					}
				}

			}

		}

		return activos;

	}

	public int getNumPrestamosSanciones() {

		int numPrestSanciones = 0;

		for (int i = 0; usuarios[i] != null && i < usuarios.length; i++) {

			if (usuarios[i] != null) {
				Prestamo[] prestamosSancionados = usuarios[i]
						.getPrestamosSancionados();
				for (int j = 0; j < prestamosSancionados.length; j++) {
					if (prestamosSancionados[j] != null) {
						numPrestSanciones++;
					}
				}

			}

		}

		return numPrestSanciones;

	}

	public Usuario[] getUsuarios() {

		return usuarios;

	}

	public Libro[] getLibros() {

		return libros;
	}

	public Usuario getUsuario(int dni) {

		int posicion = 0;
		boolean encontrado = false;

		for (int i = 0; i < usuarios.length; i++) {

			if (!encontrado && usuarios[i] != null
					&& usuarios[i].getDNI()==dni) {

				posicion = i;
				encontrado = true;
				
			}
		}

		if (encontrado) {
			return usuarios[posicion];
		} else {
			return null;
		}
	}

	public Libro getLibro(String titulo) {

		int posicion = 0;
		boolean encontrado = false;

		for (int i = 0; !encontrado && i < libros.length; i++) {

			if (libros[i] != null)
				if (libros[i].getTitulo().contains(titulo)) {
					posicion = i;
					encontrado = true;
					System.out.print("Libro encontrado");
				}

		}
		if (encontrado) {
			return libros[posicion];
		} else {
			return null;
		}
	}

	public String histograma() {

		String histogramaString = " ";
		int histograma[] = new int[10];

		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				histograma[usuarios[i].getNumPrestamos()]++;
			}
		}

		for (int h = 0; h < histograma.length; h++) {

			histogramaString = histogramaString + "Personas con " + h
					+ " préstamos:";

			for (int n = 0; n < histograma[h]; n++) {
				histogramaString = histogramaString + "*";

			}
			histogramaString = histogramaString + "\n";
		}

		return histogramaString;

	}

	public String ListarLibros() {

		String listaLibros = " ";

		for (int i = 0; libros[i] != null && i < libros.length; i++) {

			listaLibros = listaLibros + libros[i].toString() + "\n";
		}

		return listaLibros;

	}

	public String ListarUsuarios() {

		String listaUsuarios = "";
		for (int i = 0; usuarios[i] != null && i < usuarios.length; i++) {

			listaUsuarios = listaUsuarios + usuarios[i].toString() + "\n";
		}

		return listaUsuarios;
	}

	public void guardar() {
		PrintWriter out = null;
		try {

			out = new PrintWriter("newInfoBiblioteca.txt");
			out.print("Last_id_prestamos "+Prestamo.getNumPrestamos()+"\n"
					+"Número máximo libros 50 \n"
					+"Número máximo usuarios 50 \n"
					+"----------LIBROS---------:\n");
			out.println(ListarLibros());
			out.println("---------PRÉSTAMOS---------\n");
			out.println(ListarUsuarios());			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			if (out != null) {
				out.close();
			}
		}
	}
		
	

}
