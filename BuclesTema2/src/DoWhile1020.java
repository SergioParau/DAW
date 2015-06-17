import java.util.*;
public class DoWhile1020 {
	public static void main(String[] args){
		
		int n;
		Scanner teclado = new Scanner(System.in);
		
		do{
			System.out.println("Introduce un número entre el 10 y el 20: ");
			n = teclado.nextInt();
		}while(n<10 || n>20);
	}
}
