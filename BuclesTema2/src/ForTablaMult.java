import java.util.*;
public class ForTablaMult {
	public static void main(String[] args){
		
		int i;
		int n;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce el n�mero deseado: ");
		n = teclado.nextInt();
		
		for(i=0;i<=1000;i++){
			System.out.println(n + "x" + i + "=" + (n*i));	
		}
	}
}
