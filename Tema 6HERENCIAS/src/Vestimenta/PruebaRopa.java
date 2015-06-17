package Vestimenta;

public class PruebaRopa {

	public static void main(String[] args) {
	

		Ropa pantalon = new Ropa();
		pantalon.imprimir();
		System.out.println("\n\n");
		Camiseta c = new Camiseta();
		
		
		c.imprimir();
		System.out.println("\n\n");
		Ropa ch = new Ropa("azul","G-unit",32.99f,"poliestireno");
		ch.imprimir();
		System.out.println("\n\n");
		Camiseta ca = new Camiseta("Negro","Game",13,"","corto",false);
		ca.imprimir();
	}

}