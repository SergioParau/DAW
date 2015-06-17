import java.util.*;
public class Ejercicio9 {

	public static void main(String[] args) {
		
		String aux;
		String pais[] = new String[5];
		Scanner teclado = new Scanner(System.in);
		
		for(int n=0;n<pais.length;n++){
		System.out.println("Introduce el nombre del país");
		pais[n] = teclado.next();
		}
		
		for (int i=0;i<pais.length;i++){
			
			for(int j=0;j<((pais.length-1)-i);j++){
				
				if(pais[j].compareTo(pais[j+1])>0){
					aux = pais[j];
					pais [j] = pais[j+1];
					pais[j+1] = aux;
				}
			
			}
		}
		
		for (int p = 0;p<pais.length;p++){
			System.out.println(pais[p]);
		}
	}

}
