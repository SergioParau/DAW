import java.util.*;
public class PruebaCalc {

	public static void main(String[] args) {

		Calculadora calc = new Calculadora(5,23);
		Scanner input = new Scanner(System.in);
		String op;
		
		System.out.println("Introduzca la operación que desea realizar con los valores dados:");
		op = input.nextLine();
		
		calc.print(op);
		
		
		
	}

}
