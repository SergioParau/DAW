package examen3;


import java.util.ArrayList;
import java.util.HashMap;

public class PruebaEdificiosExcursion {

	public static void main(String[] args) {

		ArrayList<String> obras = new ArrayList<String>();
		obras.add("Obra primera");
		obras.add("Obra segunda");
		obras.add("Obra tercera");

		ArrayList<String> exposiciones = new ArrayList<String>();
		exposiciones.add("Primera exposicion");
		exposiciones.add("Segunda exposicion");
		exposiciones.add("Tercera exposicion");

		Museo m = new Museo(1, "Museo Con lista de Exposicones", "Esilo clasico", "Arquitecto Museo",
				2010, "Calle del museo nº3", 50, true, exposiciones, 10);

		Teatro t1 = new Teatro(1, "Teatro Con Lista de obras", "Estilo 1", "Arquitecto 1", 2000,
				"Calle primera nº 1", 10, 100, obras);
		
		Teatro t2 = new Teatro(2, "Teatro Sin Lista", "Estilo 2", "Arquitecto 2", 2000,
				"Calle segunda nº 2", 5, 50);

		t2.anyadirObra("Obra anyadida 1");
		t2.anyadirObra("Obra anyadida 2");
		t2.anyadirObra("Obra anyadida 3");

		HashMap<Integer, Edificio> itinerario = new HashMap<>();
		itinerario.put(1, t1);
		itinerario.put(2, m);
		itinerario.put(3, t2);

		Excursion exc = new Excursion(itinerario, 100);
		System.out.println(exc.toString());
	}

}
