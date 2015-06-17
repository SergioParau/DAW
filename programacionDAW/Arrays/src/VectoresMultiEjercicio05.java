import java.util.*;

public class VectoresMultiEjercicio05 {

	public static void main(String[] args) {

		String palabra = "testString";
		Scanner input = new Scanner(System.in);
		boolean pal = true;

		System.out.println("Introduce la palabra para ver si es palíndroma, palurdo:");
		palabra = input.next();

		int i = 0;
		int j = palabra.length() - 1;

		/*
		 * String reverse = new StringBuilder(palabra).reverse().toString();
		 * 
		 * if(palabra.compareTo(reverse)==0){
		 * System.out.println("La palabra es palíndroma."); }else{
		 * System.out.println("Lo siento. Esta palabra no es palíndroma"); }
		 */

		while (pal == true) {
			if (palabra.charAt(i) != palabra.charAt(j)) {

				pal = false;

			}else if (palabra.charAt(i) == palabra.charAt(j) && i == j) {
					System.out.println("La palabra es palíndroma.");
					return;

			} else if (palabra.charAt(i) == palabra.charAt(j)) {
					i++;
					j--;
					pal = true;
				}
			}

			if (pal == false) {
				System.out.println("La palabra no es palíndroma.");
			}

		}

	
}
