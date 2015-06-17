import java.util.*;
public class CodigoPeliculasV2 {
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		int codigo;
		int alquiler;
		int codigoMax1 = 0;
		int codigoMax2 = 0;
		int codigoMin = 0;
		int alquilerMax1 = 0;
		int alquilerMax2 = 0;
		int alquilerMin = 0;
		int contador=0;
		double mediaAlquiler = 0;
		double sumaAlquiler = 0;
		int alquiler20 = 0;
		int alquiler715 = 0;
		int alquiler5 = 0;
		double porcentaje20=0;
		double porcentaje715 = 0;
		double porcentaje5 = 0;
		
		
		System.out.println("Introduzca el código de la película: ");
		codigo = teclado.nextInt();
		

		while(codigo>0&&codigo<999){
			
			System.out.println("Introduzca ahora las veces que ha sido alquilada: ");
			alquiler = teclado.nextInt();
			
			
			
			if(contador==0){
				codigoMax1 = codigo;
				alquilerMax1 = alquiler;
				codigoMax2 = codigo;
				alquilerMax2 = alquiler;
				codigoMin = codigo;
				alquilerMin = alquiler;
			}//FIN IF CONTADOR
			
			if(alquiler>alquilerMax1){
				codigoMax2 = codigoMax1;
				alquilerMax2 = alquilerMax1;
				codigoMax1 = codigo;
				alquilerMax1 = alquiler;
			}//FIN IF MAX1
			if(alquiler>alquilerMax2&&alquiler<alquilerMax1){
				codigoMax2=codigo;
				alquilerMax2=alquiler;
			}//FIN IF MAX2
			if(alquiler<alquilerMin){
				codigoMin=codigo;
				alquilerMin=alquiler;
			}
			
			if(alquiler>20){
				alquiler20++;
			}
			
			if(alquiler>=7&&alquiler<=15){
				alquiler715++;
			}
			
			if(alquiler<5){
				alquiler5++;
			}
			
			System.out.println("Introduzca el código de la película: ");
			codigo = teclado.nextInt();
			
			contador++;
			sumaAlquiler =+ alquiler;
		}//FIN WHILE
		
			mediaAlquiler = sumaAlquiler/contador;
			
			if(codigo<0){
			porcentaje5 = (alquiler5*100)/contador;
			porcentaje715 = (alquiler715*100)/contador;
			porcentaje20 = (alquiler20*100)/contador;
			
			System.out.println("La película más alquilada ha sido la "+codigoMax1);
			System.out.println("La segunda película más alquilada ha sido la "+codigoMax2);
			System.out.println("La película menos alquilada ha sido la "+codigoMin);
			System.out.println("La media de películas alquiladas ha sido de "+mediaAlquiler+" películas.");
			System.out.println("Ha habido un "+porcentaje5+"% de películas alquiladas menos de 5 veces.");
			System.out.println("Ha habido un "+porcentaje715+"% de películas alquiladas entre 7 y 15 veces.");
			System.out.println("Ha habido un "+porcentaje20+"% de películas alquiladas más de 20 veces.");
		
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//FIN MAIN
}//FIN CLASS
