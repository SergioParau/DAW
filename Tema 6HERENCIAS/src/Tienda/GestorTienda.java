package Tienda;

public class GestorTienda {

	public static void main(String[] args) {

		Movil m = new Movil(220,225,30,140,111, "orange", true);
		System.out.println(m.toString());
		System.out.println("\n\n");

		Camara sony = new Camara(10,255,148,956,658,147,22,true);
		System.out.println(sony.toString());
		System.out.println("\n\n");
		Reproductor mp = new Reproductor(10,20,30,40,10, "120Gb",false);
		System.out.println(mp.toString());
		System.out.println("\n\n");
	}

}