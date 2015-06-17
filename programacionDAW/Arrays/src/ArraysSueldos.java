import java.util.*;
public class ArraysSueldos {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int sueldoManyana[];
		sueldoManyana = new int[4];
		int sueldoTarde[];
		sueldoTarde = new int[4];
		int m;
		int t;
		int sumaManyana = 0;
		int sumaTarde = 0;
		
		for(m=0;m<4;m++){
			System.out.println("Introduce el sueldo del trabajador "+(m+1)+" del turno de mañana");
			sueldoManyana[m] = teclado.nextInt();
			
			sumaManyana = sumaManyana + sueldoManyana[m];
		}// FIN FOR TURNO MAÑANA
		
		for(t=0;t<4;t++){
			System.out.println("Introduce ahora el sueldo del trabajador "+(t+1)+" del turno de tarde");
			sueldoTarde[t] = teclado.nextInt();
			
			sumaTarde = sumaTarde + sueldoTarde[t];
		}// FIN FOR TURNO TARDE
		
		System.out.println("El gasto en el turno de mañanas es de "+sumaManyana+" euros.");
		System.out.println("El gasto en el turno de tardes es de "+sumaTarde+" euros.");
		System.out.println("El gasto total es de "+(sumaManyana+sumaTarde)+" euros");
		
	}// FIN MAIN

}//FIN CLASS
