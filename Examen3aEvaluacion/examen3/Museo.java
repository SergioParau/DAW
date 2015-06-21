package examen3;

import java.util.ArrayList;

public class Museo extends Edificio {

	private boolean visitasGuiadas;
	private ArrayList<String> exposiciones;
	private int descuento;

	public Museo(int id, String nombre, String estilo, String arquitecto,
			int anyo, String direccion, int precioEntrada,
			boolean visitasGuiadas, int descuento) {

		super(id, nombre, estilo, arquitecto, anyo, direccion, precioEntrada);
		this.visitasGuiadas = visitasGuiadas;
		this.descuento = descuento;
		exposiciones = new ArrayList<String>();

	}

	public Museo(int id, String nombre, String estilo, String arquitecto,
			int anyo, String direccion, int precioEntrada,
			boolean visitasGuiadas, ArrayList<String> exposiciones,
			int descuento) {

		super(id, nombre, estilo, arquitecto, anyo, direccion, precioEntrada);
		this.visitasGuiadas = visitasGuiadas;
		this.descuento = descuento;
		this.exposiciones = exposiciones;

	}

	public void anyadirExposicion(String nombreExposicion) {

		exposiciones.add(nombreExposicion);

	}

	public void eliminarExposicion(String nombreExposicion) {
		int i = 0;
		for (String nom : exposiciones) {

			if (nombreExposicion.equals(nom)) {
				exposiciones.remove(i);
			}
			i++;
		}
	}

	public String listarExposiciones() {
		String cadena = "- EXPOSICIONES - \n";
		for (String nom : exposiciones) {
			cadena = cadena + nom + "\n";
		}
		return cadena;
	}

	public String toString() {

		String info = "\n";
		info = info + super.toString() + "\n" + listarExposiciones() + "\n"
				+ "\n Descuento: " + descuento + "\n visitas Guiadas?: "
				+ visitasGuiadas + "\n Precio con descuento: "
				+ calcularPrecio();
		
		return info;
	}

	public int calcularPrecio() {
		int i = 0;
		i = this.getPrecioEntrada() - descuento;
		return i;
	}

	public boolean isVisitasGuiadas() {
		return visitasGuiadas;
	}

	public void setVisitasGuiadas(boolean visitasGuiadas) {
		this.visitasGuiadas = visitasGuiadas;
	}

	public ArrayList<String> getExposiciones() {
		return exposiciones;
	}

	public void setExposiciones(ArrayList<String> exposiciones) {
		this.exposiciones = exposiciones;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

}
