import java.util.*;
public class EJERCICIO01 {

	public static void main(String[] args) {
		
		/*EJERCICIO 1. EXAMEN PROGRAMACION
		 * autor: Ricardo Boluda Hernández
		 * curso: 1ºDAW
		 * Fecha: 15 de Diciembre de 2014
		 */
		
		int departamentos = 0;
		int trabajadores = 0;
		int ventas = 0;
		int maxTrabajadores = 0;
		double minVentas = 0;
		double sumaVentas = 0;
		int minDepartamento = 0;
		int maxDepartamento = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce el número de departamentos: ");
		departamentos = input.nextInt();
		
		for (int i=0;i<departamentos;i++){
			sumaVentas = 0;
			System.out.println("Introduce el número de trabajadores del departamento "+i);
			trabajadores = input.nextInt();
			
			if(i==0){
				maxTrabajadores = trabajadores;
				maxDepartamento = i;
			}
			
			if(trabajadores>maxTrabajadores){
				maxTrabajadores = trabajadores;
				maxDepartamento = i;
			}
			
			for (int j=0;j<trabajadores;j++){
				System.out.println("Introduce ahora el número de ventas de este trabajador: "+j);
				ventas = input.nextInt();
				sumaVentas = sumaVentas+ ventas;	
			
				
			}//FIN FOR j
			double mediaVentas = sumaVentas/trabajadores;
			System.out.println("El número medio de ventas del departamento "+i+" es de "+mediaVentas);
			
			if(i==0){
				minVentas = mediaVentas;
				minDepartamento = i;
			}
			
			if(mediaVentas<minVentas){
				minVentas = mediaVentas;
				minDepartamento = i;
			}
			
		}//FIN FOR i
		
		System.out.println("El departamento con menor número medio de ventas por trabajador es el "+minDepartamento);
		System.out.println("El departamento con mayor número de trabajadores es el "+maxDepartamento+" con "+maxTrabajadores+" trabajadores");
	}

}
