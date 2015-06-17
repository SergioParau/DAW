import java.util.*;
import java.math.*;
public class Circulo {

	private double radio;
	
	
	public void asignaRadio(int valor){
		
		radio = valor;
		
	}
	
	public double daRadio(){
		
		return radio;
		
	}
	
	public double longitud(){
		
		double longitud = Math.PI *(2*radio);
		
		return longitud;
	}
	
	public double area(){
		
		double area = Math.PI * (Math.pow(radio, 2));
		
		return area;
	}
	
	public boolean biggerThan(Circulo B){
		
		if(this.radio>B.radio){
			return true;
		}else{
			return false;
		}
		
	}
	
}
