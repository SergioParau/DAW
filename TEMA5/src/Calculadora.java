import java.util.*;
public class Calculadora {

	private double a;
	private double b;
	
	
	
	public Calculadora(double x,double y){
		
		a = x;
		b = y;
	}
	
	
	public double suma(){
		
		double suma = a+b;
		return suma;
	}
	
	public double resta(){
		double resta = a-b;
		return resta;
	}
	
	
	public double division(){
		
		double div = a/b;
		return div;
	}
	
	public double mult(){
		
		double mult = a*b;
		return mult;
		
	}
	
	public void print(String op){
		
		switch(op){
		
		case "suma":
			System.out.println("El resultado de la suma es: "+suma());
			break;
		case "resta":
			System.out.println("El resultado de la resta es: "+resta());
			break;
		case "multiplicacion":
			System.out.println("El resultado de la multiplicacion es: "+mult());
			break;
		case "division":
			System.out.println("El resultado de la división es: "+division());
			break;
		}
		
	}
}
