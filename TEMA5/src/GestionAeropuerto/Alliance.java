package GestionAeropuerto;

import java.io.*;

public class Alliance {

	private int MAX_AIRLINES = 3;
	private Airline[] airlines;

	public Alliance() {

		airlines = new Airline[MAX_AIRLINES];
		airlines[0] = new Airline("Delta");
		airlines[1] = new Airline("AirFrance");
		airlines[2] = new Airline("Alitalia");

	}

	public Flight getFlight(String id) {

		Flight vuelo = null;
		boolean encontrado = false;

		for (int i = 0; i < MAX_AIRLINES && !encontrado; i++) {

			if (airlines[i].getFlight(id) != null && airlines[i] != null) {
				vuelo = airlines[i].getFlight(id);
				encontrado = true;

			}
		}

		if (!encontrado) {
			vuelo = null;
		}

		return vuelo;
	}

	public String toString() {

		String flights = "\tAEROLINEA\tIDVUELO\t\tORIGEN\t\tDESTINO\t\tHSALIDA\t\tHLLEGADA\tPLAZAS LIBRES";
		flights = flights
				+ "\n--------------------------------------------------------------------------------------------------------------------";

		for (int i = 0; i < airlines.length; i++) {

			flights = flights + "\n" + airlines[i].toString();
		}

		return flights;
	}

	public String listarVuelos(String origen, String destino) {
		String lista = null;
		
		boolean existenVuelos = false;
		for (int i = 0; i < MAX_AIRLINES; i++) {

			if (airlines[i].listFlights(origen, destino) != null) {
				existenVuelos = true;
			}
		}

		if (existenVuelos) {
			lista = "\tAEROLÍNEA\tIDVUELO\t\tORIGEN\t\tDESTINO\t\tHSALIDA\t\tHLLEGADA\tPLAZAS LIBRES";
			lista = lista
					+ "\n--------------------------------------------------------------------------------------------------------------------\n";

			for (int i = 0; i < MAX_AIRLINES; i++) {

				if (airlines[i].listFlights(origen, destino) != null) {
					lista = lista + airlines[i].listFlights(origen, destino);

				}
			}

		}
		return lista;
	}

	private String toStringHistograma(int[] histograma) {

		String histo = "============HISTOGRAMA DE OCUPACIÓN==============\n\n";
		int cont = 0;

		for (int i = 0; i < 53; i++) {

			if (histograma[i] != 0) {
				histo = histo + i + " Plazas reservadas:";
				cont = 0;
				for (int j = 0; j < histograma[i]; j++) {
					histo = histo + " * ";
					cont++;
				}
				histo = histo + "(" + cont + " vuelos)" + "\n\n";
			}

		}

		histo = histo + "=================================================";

		return histo;
	}

	public String toHistograma() {
		String histograma = "";
		int[] histoAlianza = new int[53];

		for (int i = 0; i < histoAlianza.length; i++)

			for (int j = 0; j < MAX_AIRLINES; j++) {

				histoAlianza[i] = histoAlianza[i]
						+ airlines[j].toHistograma()[i];
			}

		histograma = histograma + toStringHistograma(histoAlianza);

		return histograma;
	}

	public void guardar() {

		for (int i = 0; i < MAX_AIRLINES; i++) {
			airlines[i].save();
		}

	}

}
