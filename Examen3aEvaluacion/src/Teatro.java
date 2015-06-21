

import java.util.ArrayList;

public class Teatro extends Edificio {

	private ArrayList<String> obras;
	private int numLocalidades;

	public Teatro(int id, String nombre, String estilo, String arquitecto,
			int anyo, String direccion, int precioEntrada, int numLocalidades) {

		super(id, nombre, estilo, arquitecto, anyo, direccion, precioEntrada);
		this.obras = new ArrayList<String>();
		this.numLocalidades = numLocalidades;
	}

	public Teatro(int id, String nombre, String estilo, String arquitecto,
			int anyo, String direccion, int precioEntrada, int numLocalidades,
			ArrayList<String> obras) {

		super(id, nombre, estilo, arquitecto, anyo, direccion, precioEntrada);
		this.obras = obras;
		this.numLocalidades = numLocalidades;

	}

	public void anyadirObra(String nombreObra) {

		obras.add(nombreObra);

	}

	public void eliminarObra(String nombreObra) {
		int i = 0;
		for (String nom : obras) {

			if (nombreObra.equals(nom)) {
				obras.remove(i);
			}
			i++;
		}
	}

	public String listarObras() {
		String cadena = "- OBRAS - \n";
		for (String nom : obras) {
			cadena = cadena + nom + "\n";
		}
		return cadena;
	}
	
	public String toString() {

		String info = "\n";
		info = info + super.toString() + "\n" + listarObras() + "\n"
				+ "\n Nº Localidades: " + numLocalidades;
		
		return info;
	}
	
	public int calcularPrecio() {
		int i = 0;
		i = this.getPrecioEntrada();
		return i;
	}

	public ArrayList<String> getObras() {
		return obras;
	}

	public void setObras(ArrayList<String> obras) {
		this.obras = obras;
	}

	public int getNumLocalidades() {
		return numLocalidades;
	}

	public void setNumLocalidades(int numLocalidades) {
		this.numLocalidades = numLocalidades;
	}

}
