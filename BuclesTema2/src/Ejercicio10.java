import java.util.*;
public class Ejercicio10 {
	public static void main(String[] args) {
			
		Scanner teclado = new Scanner(System.in);
		int notas = 1;
		int calificacion;
		int suspendidos = 0;
		int condicionados = 0;
		int aprobados = 0;
		
		while(notas<=6){
			
			System.out.println("Introduzca una calificación: ");
			calificacion = teclado.nextInt();
			
			
			if(calificacion>=0&&calificacion<=10){
				notas++;
			if(calificacion>=5){
				aprobados++;
			}//FIN IF APROBADOS
			
			if(calificacion==4){
				condicionados++;
			}//FIN IF CONDICIONADOS
			
			if(calificacion<4){
				suspendidos++;
			}//FIN IF SUSPENDIDOS
		}else{
			System.out.println("Introduzca una calificación entre 0 y 10: ");
		}
		}//FIN WHILE

		System.out.println("Han aprobado "+aprobados+" alumnos");
		System.out.println("Han salido "+condicionados+" alumno(s) condicionados");
		System.out.println("Han suspendido "+suspendidos+" alumnos");

		
	}//FIN MAIN

}//FIN CLASS
