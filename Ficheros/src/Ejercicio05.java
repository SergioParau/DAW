import java.io.*;
import java.util.*;
public class Ejercicio05 {

	public static void main(String[] args) {

		Scanner input = null;
		int num;
		int counterNum = 0;
		int sum = 0;
		
		try{
			input = new Scanner(new FileReader("num_enteros.txt"));
			
			do{
			num = input.nextInt();
			counterNum++;
			sum = sum+num;
			System.out.println(num);

			}while(input.hasNextInt());
				
			
			System.out.println("Hay "+counterNum+" números.");
			System.out.println("La suma de todos los números es de "+sum);
			
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}finally{
			
			if(input!=null){
				input.close();
			}
		}
		
		
		
		
		
	}

}
