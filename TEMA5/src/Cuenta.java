import java.util.*;
public class Cuenta {

	public static long accNum = 100001;
	private long numCuenta;
	private long idNum;
	private int balance;
	private double rate=0.7;
	private int cash;
	Scanner input = new Scanner(System.in);
	
	
	public Cuenta(){
		
		numCuenta = accNum;
		accNum++;
		
	}
	
	public Cuenta(long id,int score){
		
		idNum = id;
		balance = score;
		numCuenta = accNum;
		accNum++;

		
		
	}
	
	public double deposit(){
		
		System.out.println("Introduzca la cantidad a ingresar: ");
		cash = input.nextInt();
		
		balance += cash;
		return balance;
		
	}
	
	public double credit(){
		
		System.out.println("Introduzca la cantidad a retirar: ");
		cash = input.nextInt();
		
		balance-=cash;
		return balance;
		
		
	}
	
	public void printInfo(){
		
		System.out.println("Número de cuenta: "+numCuenta);
		System.out.println("DNI: "+idNum);
		System.out.println("Saldo actual: "+balance);
		System.out.println("Interés anual: "+rate+"%.");
		System.out.println();

		
	}
	
}
