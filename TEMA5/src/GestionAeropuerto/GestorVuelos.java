package GestionAeropuerto;
import java.util.*;


public class GestorVuelos {

	public static int menu(Scanner tec){
		
		int opcion = 0;
		
		System.out.println("************MENÚ PRINCIPAL*************\n"
				+ "1. Mostrar vuelos\n"
				+ "2. Reservar\n"
				+ "3. Listar reservas\n"
				+ "4. Cancelar\n"
				+ "5. Histograma\n"
				+ "0. Terminar\n"
				+ "***************************************\n"
				+ "Elige una opción:");
		opcion = tec.nextInt();
		
		
		
		
		
		return opcion;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner tec = new Scanner(System.in);
		Alliance iberair = new Alliance();
		int opcion;
		do{
			
		opcion = menu(tec);
		
		switch(opcion){
		
		
		
		case 1:
			System.out.println(iberair.toString());
			break;
		case 2:
			
			System.out.println("Seleccione primero el origen del vuelo.");
			String origen = tec.next();
			System.out.println("Ahora especifique el destino del vuelo.");
			String destino = tec.next();
			
			if(iberair.listarVuelos(origen,destino)!=null){
				System.out.println(iberair.listarVuelos(origen, destino));
			}else{
				do{
					System.out.println("Alguna de las ciudades introducidas no son operadas por nuestras aerolíneas. Por favor, vuelva a introducir de nuevo los datos:");
					System.out.println("Seleccione primero el origen del vuelo.");
					origen = tec.next();
					System.out.println("Ahora especifique el destino del vuelo.");
					destino = tec.next();
					if(iberair.listarVuelos(origen,destino)!=null){
						System.out.println(iberair.listarVuelos(origen, destino));
					}
				}while(iberair.listarVuelos(origen,destino)==null);
			}
			
			System.out.println("Introduzca el ID del vuelo que desea reservar.");
			String id = tec.next();
			if(iberair.getFlight(id)==null){
				System.out.println("No existe un vuelo con identificador "+id+" de "+origen+" a "+destino);
			}else{
				System.out.println("Introduzca su nombre para formalizar la reserva:");
				String nombre = tec.next();
				System.out.println("Seleccione Pasillo o Ventanilla. Inserte 'P' para pasillo o 'V' para ventanilla");
				String inicial = tec.next();
				char asiento = inicial.charAt(0);
				System.out.println(iberair.getFlight(id).bookSeat(nombre, asiento));
			}
			break;
		case 3:
			
			System.out.println("Introduza el ID del vuelo del que desea conocer las reservas: ");
			id = tec.next();
			if(iberair.getFlight(id)==null){
				System.out.println("No existe un vuelo con identificador "+id);
			}else{
				System.out.println(iberair.getFlight(id).bookingsList());
			}
			break;
		case 4:
			
			System.out.println("Introduzca el ID del vuelo cuya plaza desea cancelar:");
			id = tec.next();
			if(iberair.getFlight(id)==null){
				System.out.println("No existe un vuelo con identificador "+id);
			}else{
				System.out.println("Introduzca el número de la plaza que quiere cancelar:");
				int plaza = tec.nextInt();
				System.out.println(iberair.getFlight(id).cancelSeat(plaza));
			}
			break;
		case 5:
			
			System.out.println(iberair.toHistograma());
			break;
		case 0:
			iberair.guardar();
			break;
			
		}
		}while(opcion!=0);
		
	}

}
