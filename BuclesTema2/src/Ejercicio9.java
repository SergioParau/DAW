import java.util.*;
public class Ejercicio9 {
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		int edades;
		int personas = 0;
		int jubilados = 0;
		int menores = 0;
		int edadMax = 0;
		int edadMin = 0;
		int edadMedia;
		int suma = 0;
		
		do{
			System.out.println("Introduzca la edad del participante: ");
			edades = teclado.nextInt();
			
			if(edades>=0){
				personas++;
				suma = suma+edades;
			}//CIERRE IF
			if(personas==1){
				edadMax = edades;
				edadMin = edades;
			}
			if(personas>1){	
			if(edades>edadMax){
				edadMax = edades;
			}
			
			if(edades<edadMin&&edades>0){
				edadMin = edades;
			}
			
			}
			if(edades>=65){
				jubilados++;
			}
			if(edades<18 && edades>=0){
				menores++;
			}
			
			
		}/*Cierre DO*/while(edades>=0);
		
	
		
		edadMedia = suma/personas;
		
		System.out.println("La edad media es de " + edadMedia);
		System.out.println("Hay " + jubilados + " jubilados y " + menores + " menores de edad");
		System.out.println("La edad mínima es de " + edadMin + " años y la edad máxima es de " + edadMax + " años.");
		
		
		
		
		
		
	}//FIN MAIN
}//FIN CLASS


