package Instrumentos;

public class Ejecucion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GuitarraElectrica fender = new GuitarraElectrica("Fender", 6);
		GuitarraElectrica washburn = new GuitarraElectrica("Washburn", 12);
		BajoElectrico stingRay = new BajoElectrico("MusicMan", 8);
		
		System.out.println(fender.tocar());
		System.out.println(washburn.tocar());
		System.out.println(stingRay.tocar());
		
		
		
	}

}