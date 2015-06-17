import java.util.*;

public class EjercicioCafe {
	public static void main(String[] args) {

		int bebida;
		Scanner teclado = new Scanner(System.in);

		boolean opcionIncorrecta = true;
		while (opcionIncorrecta) {
			System.out.println("Escoja la bebida deseada: ");
			System.out.println("Para café solo, pulse 1 ");
			System.out.println("Para café cortado, pulse 2 ");
			System.out.println("Para chocolate, pulse 3 ");
			System.out.println("Para leche, pulse 4 ");
			bebida = teclado.nextInt();

			switch (bebida) {
			/*
			 * case 1: System.out.println(
			 * "El precio del producto es de 35 céntimos. Introduzca las monedas y recoja el producto."
			 * ); break;
			 */

			case 2:
				System.out
						.println("El precio del producto es de 40 céntimos. Introduzca las monedas y recoja el producto.");
				opcionIncorrecta=false;
				break;

			case 3:
				System.out
						.println("El precio del producto es de 30 céntimos. Introduzca las monedas y recoja el producto.");
				opcionIncorrecta=false;
				break;
			case 1:
			case 4:
				System.out
						.println("El precio del producto es de 35 céntimos. Introduzca las monedas y recoja el producto.");
				opcionIncorrecta=false;
				break;

			default:
				System.out
						.println("No se encuentra el producto, vuelva a introducir un número válido");
			}// fin switch
		}// fin while
	}// FIN MAIN
}// FIN CLASE
