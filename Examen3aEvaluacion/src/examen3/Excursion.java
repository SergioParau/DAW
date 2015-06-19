package examen3;

import java.util.HashMap;
import java.util.Iterator;

public class Excursion {

	private HashMap<Integer, Edificio> itinerario;
	private int precio;

	public Excursion(HashMap<Integer, Edificio> itinerario, int precio) {
		this.itinerario = itinerario;
		this.precio = precio;
	}

	public Excursion(int precio) {
		this.itinerario = new HashMap<Integer, Edificio>();
		this.precio = precio;
	}

	public void anyadirEdificio(int idEdificio, Edificio edificio) {

		itinerario.put(idEdificio, edificio);
	}

	public void eliminarEdificio(int idEdificio) {

		itinerario.remove(idEdificio);
	}

	public int getIdEdificio(String nombre) {
		int claveID = 0;

		for (Iterator<Integer> id = itinerario.keySet().iterator(); id
				.hasNext();) {

			Edificio ed = itinerario.get(id);
			if (ed.getNombre().equals(nombre)) {
				claveID = id.next();
			}
		}

		return claveID;
	}

	public String listarItinerario() {
		String info = "";

		for (Iterator<Integer> id = itinerario.keySet().iterator(); id
				.hasNext();) {

			int clave = id.next();
			Edificio ed = itinerario.get(clave);		
			info = info + ed.toString();
		}

		return info;
	}

	public String toString() {
		String info = "";

		info = info + listarItinerario() + "\n PRECIO EXCURSION: " + precio;
		
		return info;
	}

}
