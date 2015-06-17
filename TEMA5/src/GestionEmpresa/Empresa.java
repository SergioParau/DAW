package GestionEmpresa;
import java.util.*;
import java.io.*;

public class Empresa {

	private String nombre;
	private int antiguedadEmpresa;
	private int maxTrabajadores;
	private int numTrabajadores;
	private Trabajador[] trabajadores;
	Scanner input = null;

	public Empresa() {
		try {

			int i = 0;
			antiguedadEmpresa = 30;

			input = new Scanner(new FileReader("trabajadoresEmpresa.txt"));

			maxTrabajadores = input.nextInt();
			trabajadores = new Trabajador[maxTrabajadores];

			while (input.hasNext()) {

				String name = input.next();
				String NIF = input.next();
				int years = input.nextInt();
				int wage = input.nextInt();
				String div = input.next();

				Trabajador T = new Trabajador(name, NIF, years, wage, div);

				trabajadores[i] = T;
				i++;
			}

			numTrabajadores = i;

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	public int getNumMaximoTrabajadores() {

		return maxTrabajadores;
	}

	public int getNumTrabajadores() {

		return numTrabajadores;
	}

	public String getNombreEmpresa() {
		return nombre;
	}

	public boolean existeEmpleado(String NIF) {

		boolean existe = false;

		for (int i = 0; i < trabajadores.length && existe == false; i++) {

			if (trabajadores[i] != null && NIF.equals(trabajadores[i].getDNI())) {

				existe = true;

			}

		}

		return existe;
	}// FIN EXISTE EMPLEADO

	public void anyadirEmpleado(Trabajador T) {

		/*
		 * for(int i=0;i<trabajadores.length&&insert==false;i++){
		 * 
		 * if(T.getDNI().equals(trabajadores[i].getDNI())){
		 * 
		 * System.out.println("El empleado ya existe. No puede añadirse.");
		 * }else{ insert = true; } }
		 */

		if (numTrabajadores >= maxTrabajadores) {
			System.out
					.println("Se ha excedido el número máximo de trabajadores.");

		} else {

			if (existeEmpleado(T.getDNI())) {
				System.out.println("El empleado ya existe. No puede añadirse.");
			} else {
				boolean insert = false;

				for (int j = 0; j < trabajadores.length && insert == false; j++) {

					if (trabajadores[j] == null) {
						trabajadores[j] = T;
						numTrabajadores++;
						insert = true;
					}
				}
			}
		}
	}// FIN AÑADIR EMPLEADO

	public String cancelarEmpleado(String numDNI) {

		String cancelado = " ";
		boolean cancela = false;

		for (int i = 0; i < trabajadores.length && cancela == false; i++) {

			if (trabajadores[i] != null
					&& numDNI.equals(trabajadores[i].getDNI())) {

				trabajadores[i] = null;
				cancela = true;
				numTrabajadores--;

			}

		}

		if (cancela) {
			cancelado = "Empleado borrado del sistema.";
		} else {
			cancelado = "Imposible realizar la cancelacion: el DNI requerido no existe";
		}

		return cancelado;
	}// FIN CANCELAR EMPLEADO

	public int getIdEmpleado(String numDni) {

		boolean existe = false;
		int posicion = 0;

		for (int i = 0; i < trabajadores.length && existe == false; i++) {

			if (numDni.equals(trabajadores[i].getDNI())) {

				existe = true;
				posicion = i;
				break;
			}

		}
		if (existe) {
			/*
			 * System.out.print("El empleado está en la posición " + posicion +
			 * " ");
			 */
		}
		return posicion;

	}// FIN getIDEMPLEADO

	public String getInfoEmpleado(String numDni) {

		int posicion = getIdEmpleado(numDni);

		return (trabajadores[posicion].toString());

	}// FIN getINFO

	public String listarEmpleados() {

		String listado = " ";

		for (int i = 0; i < trabajadores.length; i++) {

			if (trabajadores[i] != null) {
				listado = listado + trabajadores[i].toString() + "\n";
			}
		}

		return listado;
	}// FIN LISTADO

	public void guardar() {
		PrintWriter fich = null;

		try {

			fich = new PrintWriter("trabajadoresEmpresa.txt");

			fich.println(maxTrabajadores);
			for (int i = 0; i < trabajadores.length && trabajadores[i] != null; i++) {
				fich.println(trabajadores[i]);
			}

		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
			if (fich != null) {
				fich.close();
			}
		}

	}// FIN GUARDAR

	public String toHistograma() {

		int histograma[] = new int[antiguedadEmpresa + 1];
		String toHistograma = " ";

		for (int i = 0; i < trabajadores.length; i++) {
			if (trabajadores[i] != null)
				histograma[trabajadores[i].getAntiguedad()]++;
		}

		for (int i = 0; i < histograma.length; i++) {

			if (histograma[i] != 0) {
				toHistograma = toHistograma + "\nAntigüedad " + (i + 1)
						+ " años:";
			}
			for (int j = 0; j < histograma[i]; j++) {
				toHistograma = toHistograma + "*";
			}

		}

		return toHistograma;
	}

}
