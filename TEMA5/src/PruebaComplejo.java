import java.util.*;
public class PruebaComplejo {
	
	public static void main(String args[]){
		
		Complejo num1 = new Complejo();
		Complejo num2 = new Complejo();
		
		num1.asignar(4, 5);
		num2.asignar(7, 3);
		
		num1.sumar(num2);
		
		num1.imprimir();
		
	}

}
