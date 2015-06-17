import java.util.*;
public class VectoresMultiEjercicio04 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int alumnos;
		int asignaturas;
		float mediaAlumno = 0;
		float mediaAsignatura = 0;
		
		
		
		
		System.out.println("Introduzca el número de alumnos: ");
		alumnos = input.nextInt();
		System.out.println("Introduzca ahora de cuántas asignaturas han de ser evaluados: ");
		asignaturas = input.nextInt();
		
		float notas[][] = new float[alumnos][asignaturas];
		float sumaAlumno[] = new float[alumnos];
		float sumaAsignatura[] = new float[asignaturas];
		
		for(int f=0;f<alumnos;f++){
			
			
			for(int c=0;c<asignaturas;c++){
				System.out.println("Introduce la nota para el alumno "+f+" y la asignatura "+c);
				notas[f][c]=input.nextInt();
				
				sumaAlumno[f] = sumaAlumno[f] + notas[f][c];
				sumaAsignatura[c] = sumaAsignatura[c] + notas[f][c];
				
			}
		}
		
		
		
		
		for(int a=0;a<alumnos;a++){
			
		mediaAlumno = sumaAlumno[a]/alumnos;
		System.out.println("La media del alumno "+(a+1)+" es de "+mediaAlumno);
		}
		
		for(int s=0;s<asignaturas;s++){
		mediaAsignatura = sumaAsignatura[s]/asignaturas;
		System.out.println("La media de la asignatura "+(s+1)+" es de "+mediaAsignatura);

		}
	}

}
