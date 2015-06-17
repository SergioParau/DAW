package Futbol;

public class PruebaJugadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jugador messi = new Jugador();
		messi.imprimir();
		System.out.println("\n\n");
		Portero egea = new Portero();
		egea.setGolesRecibidos(20);
		egea.setPenaltisParados(10);
		egea.imprimir();
		
		
		
		
	}

}