import java.util.*;
public class Punto {

	private int x;
	private int y;
	
	
	public Punto(){
		
		int x1 = 0;
		int x2 = 0;
	}
	
	public Punto(int coordX,int coordY){
		
		x = coordX;
		y = coordY;
		
	}
	
	public int getCoordX(){
		
		return x;
		
	}
	
	public int getCoordY(){
		
		return y;
	}
	
	public void printCoords(){
		
		System.out.println("Las coordenadas son ("+x+","+y+").");
	}
	
	public static void main(String args[]){
		
		Punto p2 = new Punto(3,4);
		
		
		
		System.out.println("Las coordenadas de p2 son ("+p2.getCoordX()+","+p2.getCoordY()+").");
		
		
	}
}
