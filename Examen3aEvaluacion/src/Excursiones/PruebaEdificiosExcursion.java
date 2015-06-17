package Excursiones;


import java.util.ArrayList;



public class PruebaEdificiosExcursion {
	
	public static void main(String args[]){
		
		
	
		Teatro o1 = new Teatro(10, "shakespeare", "aaa", "bbb", 0, "ccc", 0, 0);
		Teatro o2 = new Teatro(10, "shakespeare", "aaa", "bbb", 0, "ccc", 0, 0);
		
		
		
		
		ArrayList<Edificio> museosTrue = new ArrayList();
		museosTrue.add(o1);
		museosTrue.add(o2);
		
	System.out.println(museosTrue);
	}

	
	
}
