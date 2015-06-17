import java.util.*;
public class Cafetera {

	public int maxCap;
	public int currCap;
	Scanner input = new Scanner(System.in);
	
	public Cafetera(){
		
		maxCap = 1000;
		currCap = 0;	
	}
	
	public Cafetera(int full){
		
		maxCap = full;
		currCap = maxCap;
	}
	
	public Cafetera(int full,int current){
		
		maxCap = full;
		currCap = current;
		
		if(current>full){
			current = full;
		}
		
	}
	
	public void fillPot(){
		
		currCap = maxCap;
		
	}
	
	public void fillCup(int cup){
		
		currCap = currCap - cup;
		
		if(currCap<cup){
			cup = currCap;
			currCap = 0;
		}
	}
	
	public void emptyPot(){
		
		currCap = 0;
	}
	
	public void addCoffee(int fill){
	
		currCap = currCap + fill;
		
	}
	
}
