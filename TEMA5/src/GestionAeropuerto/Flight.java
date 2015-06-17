package GestionAeropuerto;

import java.io.*;

public class Flight {

	private String id;
	private String origin;
	private String destination;
	private String departureHour;
	private String arrivalHour;
	public static int MAX_SEATS = 52;
	private String[] seats;
	private int booked;

	public Flight(String id, String origin, String destination,
			String departureHour, String arrivalHour) {

		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.departureHour = departureHour;
		this.arrivalHour = arrivalHour;
		booked = 0;
		seats = new String[MAX_SEATS + 1];
	}

	public String getId() {

		return id;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public int getBooked() {
		return booked;
	}

	public boolean seatsAvailable() {

		boolean seats = false;

		if (booked < MAX_SEATS) {
			seats = true;
		} else {
			seats = false;
		}

		return seats;
	}

	public int firstSeat(char pref) {

		//String passenger = "";
		int seat = 0;
		boolean encontrado = false;
		if (pref == 'P' || pref == 'p') {

			for (int i = 2; i <= MAX_SEATS && !encontrado; i += 2) {

				if (seats[i] == null) {

					//seats[i] = passenger;
					seat = i;
					encontrado = true;
				}
			}
		} else if (pref == 'V' || pref == 'v') {

			for (int i = 1; i <= MAX_SEATS && !encontrado; i += 2) {
				if (seats[i] == null) {
					//seats[i] = passenger;
					seat = i;
					encontrado = true;
				}
			}
		} else {

			seat = -1;
		}

		return seat;
	}

	public void bookSeat(String passenger, int seatNum) {

		seats[seatNum] = passenger;
		booked++;

	}

	public String bookSeat(String passenger, char pref) {

		String message = "b";

		if (booked >= MAX_SEATS) {
			message = "Imposible realizar la reserva. Vuelo completo.";
		} else {

			if (pref == 'P' || pref == 'p') {
				if (firstSeat(pref) != -1) {
					int numSeat = firstSeat(pref);
					bookSeat(passenger, numSeat);
					message = "Su reserva: "+ seats[numSeat].toString() + "\t"+ numSeat + pref + "\t" + toString();
					
					
				} else if (firstSeat(pref) == -1) {
					pref = 'V';
					int numSeat = firstSeat(pref);
					bookSeat(passenger, numSeat);
					message = "No quedan plazas libres en pasillo. Su reserva: "+ seats[numSeat].toString() + "\t"+ numSeat + pref + "\t" + toString();
				}
				
				
			} else if (pref == 'V' || pref == 'v') {
				
				if (firstSeat(pref) != -1) {
					int numSeat = firstSeat(pref);
					bookSeat(passenger, numSeat);
					message = "Su reserva: "+ seats[numSeat].toString() + "\t"+ numSeat + pref + "\t" + toString();
					
					
				} else if (firstSeat(pref) == -1) {
					pref = 'P';
					bookSeat(passenger, firstSeat(pref));
					int numSeat = firstSeat(pref);
					bookSeat(passenger, numSeat);
					message = "No quedan plazas libres en ventanilla. Su reserva: "+ seats[numSeat].toString() + "\t"+ numSeat + pref + "\t" + toString();
				}
			}

		}

		return message;
	}

	public String cancelSeat(int seatNum) {

		String cancellation = " ";
		boolean cancelled = false;

		if (seats[seatNum] != null&&!cancelled) {
			seats[seatNum] = null;
			cancellation = "Reserva cancelada satisfactoriamente";
			cancelled = true;
			booked--;
		} else if (seats[seatNum] == null) {
			cancellation = "Imposible realizar la cancelación. la plaza "
					+ seatNum + " no está ocupada.";
		}

		return cancellation;
	}

	public String toString() {
		
String flight="";
		
			
		
		 flight = flight + flight.format("%13s %16s %16s %14s %14s",id,origin,destination,departureHour,arrivalHour);
		
		return flight;
	}

	public String bookingsList() {

		String bookings = "";

		bookings = toString()+"\n";

		for (int i = 1;i < MAX_SEATS; i++) {
			
			if(i%2!=0&&seats[i]!=null){
				bookings = bookings + seats[i] + " ("+i+"V"+")"+"\n";
			}else if(i%2==0&&seats[i]!=null){
				bookings = bookings + seats[i] + " ("+i+"P"+")"+"\n";
				
			}

		}
		return bookings;
	}

	public void saveFile(PrintWriter flights) {

		
		try {
			
			
			flights.print(bookingsList());
			//System.out.println(bookingsList());
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} 

	}

}
