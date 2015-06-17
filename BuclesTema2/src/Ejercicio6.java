import java.util.*;
public class Ejercicio6 {
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		int codigo;
		int alquilerMes = 0;
		int codigoTop1 = 0;
		int alquilerTop1 = 0;
		int codigoTop2 = 0;
		int alquilerTop2 = 0;
		int codigoMin = 0;
		int alquilerMin = 50;
		int contador = 0;
		int alquiler20 = 0;
		double porcentaje20;
		int alquiler5 = 0;
		double porcentaje5;
		int alquiler715 = 0;
		double porcentaje715;
		double sumaAlquiler = 0;
		double mediaAlquiler = 0;
		
		System.out.println("Introduzca el código de la película: ");
		codigo = teclado.nextInt();
		
		while(codigo>999){
			System.out.println("Introduzca un código válido: ");
			codigo = teclado.nextInt();
		}
			
			while(codigo>0&&codigo<999){
				System.out.println("Introduce el número de veces que ha sido alquilada la película: ");
				alquilerMes = teclado.nextInt();
				
				
				
				if(contador==0){
					alquilerTop1 = alquilerMes;
					codigoTop1 = codigo;
					alquilerTop2 = alquilerMes;
					codigoTop2 = codigo;
					alquilerMin = alquilerMes;
					codigoMin = codigo;
				} else {
					
					if(alquilerMes>alquilerTop1){
						codigoTop2 = codigoTop1;
						codigoTop1 = codigo;
						alquilerTop2 = alquilerTop1;
						alquilerTop1 = alquilerMes;
					}
					if(alquilerMes>alquilerTop2&&alquilerMes<alquilerTop1){
						codigoTop2 = codigo;
						alquilerTop2 = alquilerMes;
					}
					if(alquilerMes<alquilerMin){
						codigoMin = codigo;
						alquilerMin = alquilerMes;
					}
					
				}
				
				if(alquilerMes>=20){
					alquiler20++;
				}
				if(alquilerMes<=5){
					alquiler5++;
				}
				if(alquilerMes>=7&&alquilerMes<=15){
					alquiler715++;
				}
				
				System.out.println("Introduzca el código de la película: ");
				codigo = teclado.nextInt();
				
				while(codigo>999){
					System.out.println("Introduzca un código válido: ");
					codigo = teclado.nextInt();
				}
	
				contador++;
				sumaAlquiler = sumaAlquiler + alquilerMes;
			}//FIN WHILE
			
			mediaAlquiler = sumaAlquiler/contador;
			porcentaje20 = (alquiler20*100)/contador;
			porcentaje5 = (alquiler5*100)/contador;
			porcentaje715 = (alquiler715*100)/contador;
			
			System.out.println("La película que más ha sido alquilada ha sido la "+codigoTop1);
			System.out.println("La segunda película más alquilada ha sido la "+codigoTop2);
			System.out.println("La película menos alquilada ha sido la "+codigoMin);
			System.out.println("La media de películas alquiladas es de "+ mediaAlquiler + " películas.");
			System.out.println("Un "+porcentaje20+"% de películas han sido alquiladas más de 20 veces.");
			System.out.println("Un "+porcentaje5+"% de películas han sido alquiladas menos de 5 veces.");
			System.out.println("Un "+porcentaje715+"% de películas han sido alquiladas entre 7 y 15 veces.");
		
	}//FIN MAIN
}//FIN CLASS




