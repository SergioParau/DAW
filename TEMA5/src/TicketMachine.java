import java.util.*;
public class TicketMachine {

	private int price;
	private int balance;
	private int total;
	private Scanner input = new Scanner(System.in);
	
	
	public TicketMachine(int ticketCost){

		price = ticketCost;
	}
	
	/*Devuelve el precio de un ticket*/
	public int getPrice(){
		
		return price;
	}
	
	
	/*Devuelve la cantidad de dinero que se ha instertado para obtener un ticket*/
	public int getBalance(){
		
		return balance;
		
	}
	
	
	/*Recibe una cantidad de dinero en céntimos de un cliente y comprueba que es una cantidad positiva*/
	public void insertMoney(int amount){
		
		
		
		if(amount>0){
			
			balance+=amount;
		}
		
		
	}
	
	
	/*Imprime el ticket si se ha insertado la cantidad de dinero suficiente, 
	reduce la cantidad de dinero del usuario e incrementa el total de dinero acumulado por la venta de tickets. 
	En el caso de que no se haya insertado la cantidad suficiente, 
	imprime un mensaje por pantalla donde le indica la cantidad de dinero que le falta.*/
	public void printTicket(){
		
		if(balance>=price){
			System.out.println("Imprimiendo ticket");
			total=+price;
		}else if(balance<price){
			
			System.out.println("Faltan "+(price-balance)+" euros.");
		}
		
	}
	
	/*Devuelve el dinero correspondiente al usuario*/ 
	
	public int refundBalance(){
		
		balance = balance-price;
		System.out.println("Recoja su cambio: "+ balance);
		return balance;
	}

	public static void main(String[] args){
		
		
		TicketMachine x = new TicketMachine(10);
		Scanner input = new Scanner(System.in);
		
		System.out.println("El precio del billete es "+x.getPrice());
		
		while(x.getBalance()<x.getPrice()){
		x.printTicket();
		System.out.println("Introduzca moneda:");
		int valor = input.nextInt();
		x.insertMoney(valor);
		}
		
		if(x.getBalance()==x.getPrice()){
		x.printTicket();	
		}else if(x.getBalance()>x.getPrice()){
			x.printTicket();
			x.refundBalance();
		}
			
		
		
	}
	
}
