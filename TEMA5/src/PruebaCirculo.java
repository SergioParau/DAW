import java.util.*;
public class PruebaCirculo {

	public static void main(String args[]){
	
		Circulo A = new Circulo();
		Circulo B = new Circulo();
		
		A.asignaRadio(5);
		B.asignaRadio(8);
		System.out.println("El radio del círculo es de "+A.daRadio());
		System.out.println("El perímetro del círculo es de "+A.longitud());
		System.out.println("El área del círculo es de "+A.area());
		
		System.out.println("El círculo A es mayor que el círculo B: "+A.biggerThan(B));
		
		
		
		
	}
	
}
