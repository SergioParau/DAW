package GestionAeropuerto;

import java.io.*;
import java.util.Scanner;

public class Airline {

	private static int MAX_FLIGHTS = 10;
	public Flight[] flights;
	private int ofertados;
	private String name;

	public Airline(String name) {
		this.name = name;
		flights = new Flight[MAX_FLIGHTS];
		load();

	}

	private void load() {

		Scanner carga = null;

		try {
			carga = new Scanner(new File(this.name + ".txt"));

			while (carga.hasNext() && ofertados < MAX_FLIGHTS) {

				String id = carga.next();
				// System.out.print(id + "\t");
				String origin = carga.next();
				// System.out.print(origin + "\t");
				String destination = carga.next();
				// System.out.print(destination + "\t");
				String departureHour = carga.next();
				// System.out.print(departureHour + "\t");
				String arrivalHour = carga.next();
				// System.out.println(arrivalHour);
				// carga.nextLine();
				int booked = carga.nextInt();
				// System.out.println(booked);
				carga.nextLine();

				flights[ofertados] = new Flight(id, origin, destination,
						departureHour, arrivalHour);

				while (booked != 0) {
					int seat = carga.nextInt();
					// System.out.print(seat + "\t");
					String passenger = carga.nextLine();
					// System.out.println(passenger);

					flights[ofertados].bookSeat(passenger, seat);
					booked--;
				}
				carga.nextLine();
				ofertados++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("El archivo no se ha encontrado" + e);
		} finally {
			if (carga != null) {
				carga.close();
			}
		}
		
		//System.out.println(ofertados);

	}

	public String getName() {

		return name;
	}

	public Flight getFlight(String id) {

		boolean found = false;
		Flight vuelo = null;

		for (int i = 0; i < ofertados && !found; i++) {

			if (flights[i] != null && flights[i].getId().equals(id)) {
				found = true;
				vuelo = flights[i];
			}
		}

		return vuelo;
	}

	public String toString() {

		String vuelos = "";

		for (int i = 0; i < ofertados; i++) {

			
			vuelos = vuelos + vuelos.format("%15s %46s %17d\n", this.name,flights[i].toString(),(Flight.MAX_SEATS - flights[i].getBooked()));
			
		}
		return vuelos;
	}

	public String listFlights(String origin, String destination) {

		String vueloDisponible="";
		

		for (int i = 0; i < ofertados; i++) {

			if (flights[i].getOrigin().equals(origin)
					&& flights[i].getDestination().equals(destination)
					&& flights[i].seatsAvailable() == true) {
				vueloDisponible = vueloDisponible +vueloDisponible.format("%15s %46s %17d\n", this.name,flights[i].toString(),(Flight.MAX_SEATS - flights[i].getBooked()));
				
			}
		}
		
		if(vueloDisponible.equals("")){
			vueloDisponible = null;
		}
		
		return vueloDisponible;
	}

	public int[] toHistograma() {
		int histograma[] = new int[Flight.MAX_SEATS + 1];

		for (int i = 0; flights[i] != null && i < flights.length; i++) {
			histograma[flights[i].getBooked()]++;
		}
		return histograma;
	}

	public void save() {

		PrintWriter out = null;

		try {

			out = new PrintWriter(this.name + "2.txt");

			for (int i = 0;flights[i]!=null&& i < ofertados; i++) {

				flights[i].saveFile(out);
				out.println("=== === === === === === ===");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(out!=null){
				out.close();
			}
		}

	}
}
