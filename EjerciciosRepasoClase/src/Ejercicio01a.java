import java.util.*;
public class Ejercicio01a {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int grupos = 5;
		int sesiones = 6;
		int alumnos;
		int alumnosAsist = 0;
		int contadorAsist = 0;
		int limite = 2;
		int grupoNO = 0;
		int sumaAsist = 0;
		int minSesion = 0;
		int minAsist = 0;
		double maxAsist = 0;
		int maxGrupo = 0;
		
		
		for(int i=0;i<grupos;i++){
			
			minAsist = 0;
			minSesion = 0;
			sumaAsist = 0;
			contadorAsist = 0;
			
			System.out.println("Introduce el número de alumnos del grupo "+i);
			alumnos = input.nextInt();
			
			for(int j=0;j<sesiones;j++){
				
				System.out.println("Cuantos alumnos del grupo "+i+" asistieron a la sesión "+j+"?");
				alumnosAsist = input.nextInt();
				
				sumaAsist = sumaAsist + alumnosAsist;
				
				if(alumnosAsist<(alumnos/2)){
					contadorAsist++;
					if(contadorAsist==limite){
						grupoNO++;
						break;
					}
				}
				
				if(j==0){
					j = minSesion;
					minAsist = alumnosAsist;
					//System.out.println(minSesion);
					//System.out.println(minAsist);
				}
				
				if(alumnosAsist<minAsist){
					minSesion = j;
					minAsist = alumnosAsist;
					//System.out.println(minSesion);
					//System.out.println(minAsist);
				}
				
				
					
					
			}//FIN FOR SESIONES
			
			
			
			if(contadorAsist==limite){
				System.out.println("El grupo "+i+" ha sido desestimado por falta de asistencia.");
			}
			
			
				
				
				
				
			
			double mediaAsist = sumaAsist/alumnos;
			
			if(i==0){
				maxAsist = mediaAsist;
				i = maxGrupo;
			}
			
			if(mediaAsist>maxAsist){
				maxAsist = mediaAsist;
				maxGrupo = i;
			}
			
			
			
			if(contadorAsist<limite){
			System.out.println("La asistencia media del grupo "+i+" ha sido de "+mediaAsist+" alumnos.");
			System.out.println("La sesión "+minSesion+" ha sido la sesión con menos asistencia del grupo "+i+" con una asistencia de "+minAsist+" alumnos.");
			}
		
		}
		
		if(contadorAsist<limite){
		System.out.println("El grupo con mayor asistencia media ha sido el grupo "+maxGrupo);
		}
		
		if(grupoNO == grupos){
			System.out.println("Todos los grupos han sido desestimados.");
		}
		
		
		
	}

}
