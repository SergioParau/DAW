import java.util.*;
public class Ejercicio14 {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int edad;
		double altura;
		double alturaEdge = 1.75d;
		double sumaAltura = 0;
		int sumaEdad = 0;
		int edadMedia;
		double alturaMedia;
		int mayores = 0;
		int altos = 0;
		int alumnos;

		for(alumnos = 0;alumnos<5;alumnos++){
			
			System.out.println("Introduce la edad del alumno: ");
			edad = teclado.nextInt();
			
			sumaEdad = sumaEdad + edad;
			
			if(edad>=18){
				mayores++;
			}//FIN IF EDAD
			
			System.out.println("Introduce la altura del alumno: ");
			altura = teclado.nextDouble();
			
			sumaAltura = sumaAltura + altura;
			
			if(altura>alturaEdge){
				altos++;
			}//FIN IF ALTURA
				
			
		}//FIN FOR
		
		edadMedia = sumaEdad/alumnos;
		alturaMedia = sumaAltura/alumnos;
		
		System.out.println("La edad media es de "+edadMedia+" años.");
		System.out.println("La altura media es de "+alturaMedia+" metros.");
		System.out.println("Hay "+altos+" alumnos de más de 1.75m");
		System.out.println("Hay "+mayores+" alumnos mayores de edad.");
		
		
		
		
	}//FIN MAIN

}//FIN CLAS
