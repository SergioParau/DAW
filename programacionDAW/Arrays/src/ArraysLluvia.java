import java.util.*;
public class ArraysLluvia {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int lluvia[];
		lluvia = new int[6];
		int suma = 0;
		int media = 0;
		int l;
		
		for(l=0; l<6;l++){
			System.out.println("Introduzca los datos de lluvia del día "+(l+1));
			lluvia[l]=teclado.nextInt();
			
			suma = suma+lluvia[l];
		}// FIN FOR
		
		media = suma/l;
		
		for(l=0;l<6;l++){
			if(lluvia[l]>=(2*media)){
				System.out.println("El día "+(l+1)+" las precipitaciones fueron el doble de la media.");
			}
		}
		
		System.out.println("La media de precipitaciones ha sido de "+media+" mm");
		
	}// FIN MAIN

}//FIN CLASS
