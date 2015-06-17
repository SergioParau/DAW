import java.util.*;
public class Ejercicio5 {
	public static void main(String[] args) {
		
		int alumnos;
		int facultad[] = new int [50];
		int sexo[] = new int [50];
		int estado[] = new int [50];
		int sueldo [] = new int [50];
		int hombres = 0; 
		int mujeres = 0;
		int empleoHombres = 0;
		int empleoMujeres = 0;
		int sumaSueldoHombres = 0;
		int sumaSueldoMujeres = 0;
		double porcentajeHombres = 0;
		double porcentajeHombresEmpleo = 0;
		double porcentajeMujeresEmpleo = 0;
		double porcentajeMujeres = 0;
		int sueldoMedioHombres = 0;
		int sueldoMedioMujeres = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Cuántos alumnos se van a introducir?");
		alumnos= teclado.nextInt();
		
		while(alumnos>50){
			System.out.println("Por favor, introduzca un valor menor o igual a 50");
			alumnos = teclado.nextInt();
		}
		
		for(int a=0;a<alumnos;a++){
			System.out.println("Introduzca ahora los datos del alumno "+(a+1));
			System.out.println("Introduzca el código de la facultad");
			facultad[a] = teclado.nextInt();
			
			System.out.println("Perfecto!. Introduzca ahora el sexo del alumno. 1 para hombre y 2 para mujer");
			sexo[a] = teclado.nextInt();
			
			if(sexo[a]!=1&&sexo[a]!=2){
				System.out.println("Por favor, introduzca un valor válido");
			}
			
			System.out.println("Está este alumno/a trabajando? Introduzca 1 si está trabajando o 2 si está en paro");
			estado[a] = teclado.nextInt();
			if(estado[a]!=1&&estado[a]!=2){
				System.out.println("Por favor, introduzca un valor válido");
			}
			
			if(estado[a]==1){
				System.out.println("Introduzca ahora el sueldo de este alumno");
				sueldo[a] = teclado.nextInt();
			}
			
			if(estado[a]==2&&sexo[a]==1){
				sueldo[a]=0;
				hombres++;
				
			}
			
			if(estado[a]==2&&sexo[a]==2){
				mujeres++;
			}
			
			if(sexo[a]==1&&estado[a]==1){
				hombres++;
				empleoHombres++;
				sumaSueldoHombres = sumaSueldoHombres + sueldo[a];
				
			}
			
			if(sexo[a]==2&&estado[a]==1){
				mujeres++;
				empleoMujeres++;
				sumaSueldoMujeres = sumaSueldoMujeres + sueldo[a];
				
			}	
			
		}//FIN FOR
		
		porcentajeHombres = (hombres*100)/alumnos;
		porcentajeMujeres = (mujeres*100)/alumnos;
		porcentajeHombresEmpleo = (empleoHombres*100)/hombres;
		porcentajeMujeresEmpleo = (empleoMujeres*100)/mujeres;
		sueldoMedioHombres = sumaSueldoHombres/hombres;
		sueldoMedioMujeres = sumaSueldoMujeres/mujeres;
		
		System.out.println("Hay un "+porcentajeHombres+"% de hombres en la universidad.");
		System.out.println("Hay un "+porcentajeMujeres+"% de mujeres en la universidad.");
		System.out.println("Hay un "+porcentajeHombresEmpleo+"% de hombres en la universidad que trabajan y su sueldo medio es de "+sueldoMedioHombres+"€");
		System.out.println("Hay un "+porcentajeMujeresEmpleo+"% de mujeres en la universidad que trabajan y su sueldo medio es de "+sueldoMedioMujeres+"€");
		
	}//FIN MAIN

}//FIN CLASS
