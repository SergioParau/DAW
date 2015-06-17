import java.util.*;
public class Rectangulo {

	Punto xy1 = new Punto();
	Punto xy2 = new Punto();
	Punto xy3 = new Punto();
	Punto xy4 = new Punto();	
	private int base;
	private int altura;
	
	public Rectangulo(Punto p1,Punto p2,Punto p3,Punto p4){
		
		xy1 = p1;
		xy2 = p2;
		xy3 = p3;
		xy4 = p4;
		
	}
	
	public Rectangulo(int b, int a){
		
		base = b;
		altura = a;
	}
	
	public int superficie(){
		
		int superficie = base*altura;
		return superficie;
		
	}
	


public static void main(String args[]){
	
	//Rectangulo R1 = new Rectangulo();
	
}

}
