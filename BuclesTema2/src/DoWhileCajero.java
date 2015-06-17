import java.util.*;
public class DoWhileCajero {
	public static void main(String[] args){
		
		int opcion;
		Scanner teclado = new Scanner(System.in);
		
		do{
			System.out.println("Elija una operación:");
			System.out.println("1. Extraer dinero");
			System.out.println("2. Ingresar dinero");
			System.out.println("3. Últimos movimientos");
			System.out.println("4. Salir");
			opcion = teclado.nextInt();
		}while(opcion<1||opcion>4);
		
		/*do{
			System.out.println("Elija una operación:");
			System.out.println("1. Extraer dinero");
			System.out.println("2. Ingresar dinero");
			System.out.println("3. Últimos movimientos");
			System.out.println("4. Salir");
			opcion = teclado.nextInt();
		}while(opcion!=4);*/
		
		
		
		
		
		
	}//FIN MAIN
}//FIN CLASS
