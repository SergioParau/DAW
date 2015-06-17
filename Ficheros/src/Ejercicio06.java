import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
public class Ejercicio06 {

	public static void main(String[] args) {

		Scanner input = null;
		PrintWriter out = null;
		String word = null;
		int price;
		double IVA = 0.21;
		DecimalFormat numberFormat = new DecimalFormat ("#.##");
		
		
		try{
			
			input = new Scanner(new FileReader("preciosSinIVA.txt"));
			out = new PrintWriter("preciosConIVA.txt");
			
			do{
				
				word = input.next();
				price = input.nextInt();
				
				System.out.println(word+" "+(numberFormat.format(price+(price*IVA))));
				
				
				
			}while(input.hasNextLine());
			
			
			
		}catch(FileNotFoundException e){
			System.out.println("File not Found");
		}finally{
			
			if(input!=null){
				input.close();
			}
		}
		
		
		
		
		
		
		
		
	}

}
