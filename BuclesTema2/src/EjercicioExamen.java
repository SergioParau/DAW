import java.util.*;
public class EjercicioExamen {
	public static void main (String[] args){
		
		Scanner teclado = new Scanner(System.in);
		int notaExamen;
		
		System.out.println("Introduce la nota obtenida para conocer el resultado: ");
		notaExamen = teclado.nextInt();
		
		while(notaExamen<0||notaExamen>10){
			System.out.println("Por favor, introduce una nota entre 0 y 10.");
			notaExamen = teclado.nextInt();
		}
		if(notaExamen>=0&&notaExamen<=10){
			if (notaExamen>=0&&notaExamen<5){
				System.out.println("El examen ha sido suspendido.");
			}//FIN IF SUSPENSO
				if (notaExamen>=5&&notaExamen<7){
					System.out.println("El examen está aprobado.");
				}//FIN IF APROBADO
					if (notaExamen>=7&&notaExamen<9){
						System.out.println("El examen está aprobado con un notable.");
					}//FIN IF NOTABLE
						if (notaExamen>=9&&notaExamen<10){
							System.out.println("El examen está aprobado con un sobresaliente.");
						}//FIN IF SOBRESALIENTE
							if(notaExamen==10){
								System.out.println("Enhorabuena! Has obtenido una matrícula de honor.");
							}//FIN IF MATRICULA
						
					}//FIN CONDICIÓN
		
		/*if (notaExamen>=0&&notaExamen<5){
			System.out.println("El examen ha sido suspendido.");
		} else if (notaExamen>=5&&notaExamen<7) {
			System.out.println("El examen está aprobado.");
		} else if (notaExamen>=7&&notaExamen<9){
			System.out.println("El examen está aprobado con un notable.");
		} else if (notaExamen>=9&&notaExamen<10){
			System.out.println("El examen está aprobado con un sobresaliente.");
		} else if (notaExamen==10){
			System.out.println("Enhorabuena! Has obtenido una matrícula de honor.");
		}*/
		
		
/*	switch(notaExamen){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.println("El examen está suspendido.");
		break;
		
		case 5:
		case 6:
			System.out.println("El examen está aprobado.");
		break;
		
		case 7:
		case 8:
			System.out.println("El examen está aprobado con notable.");
		break;
		
		case 9:
			System.out.println("El examen está aprobado con sobresaliente.");
		break;
		
		case 10:
			System.out.println("Enhorabuena!Has aprobado con matrícula de honor!");
		}*/
		
		
	}//FIN MAIN
}//FIN CLASE
