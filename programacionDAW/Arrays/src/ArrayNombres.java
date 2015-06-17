import java.util.*;
public class ArrayNombres {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		String nombre[] = new String[5];
		int edad[] = new int[5];
		String mayores[] = new String[5];
		
		for(int i=0; i<5;i++){
			
			System.out.println("Introduce el nombre de la "+(i+1)+"a persona.");
			nombre[i] = teclado.next();
			
			System.out.println("Introduce ahora la edad de la persona.");
			edad[i] = teclado.nextInt();	
		
		}//FIN FOR
		
		for(int j = 0;j<5;j++){
			
			if(edad[j]>=18){
				System.out.println(nombre[j]+" tiene más de 18 años");
			}else{
				System.out.println(nombre[j]+" tiene menos de 18 años y es muy guapa.");
			}
			
			if(nombre[j]=="Laia"){
				System.out.println(nombre[j]+"es muy guapa!");
			}
			
			
		}
		
		
	}

}
