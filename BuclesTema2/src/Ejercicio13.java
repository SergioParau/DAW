import  java.util.*;
public class Ejercicio13 {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int cantidad;
		int precioLitro;
		int facturacionTotal = 0;
		int precioFactura;
		int factura600 = 0;
		int articuloUno = 0;
		
		for(int i=1;i<=5;i++){
			System.out.println("Introduzca la cantidad en Litros: ");
			cantidad = teclado.nextInt();
			System.out.println("Introduzca el precio por litro: ");
			precioLitro = teclado.nextInt();
			
			precioFactura = cantidad*precioLitro;
			facturacionTotal = facturacionTotal+precioFactura;
			
			if(i==1){
				articuloUno = cantidad;
			}
			
			if(precioFactura>600){
				factura600++;
			}
		}//FIN FOR
		
		System.out.println("La facturación total ha sido de "+facturacionTotal+" euros.");
		System.out.println("En la factura número 1 se vendieron "+articuloUno+" litros de desinfectante");
		System.out.println("Ha habido "+factura600+" facturas que han sobrepasado los 600 euros.");

	}

}
