import java.util.*;
public class Ejercicio9a {

	public static void main(String[] args) {
		
		String pais[] = new String[3];
		Scanner input = new Scanner(System.in);
		String aux;
		
		for(int p = 0;p<pais.length;p++){
			System.out.println("Introduce el nombre del país: ");
			pais[p] = input.next();
		}

		for(int i = 0;i<(pais.length-1);i++){
			
			if(pais[i].compareTo(pais[i+1])>0){
				
				aux = pais[i];
				pais[i] = pais[i+1];
				pais[i+1] = aux;
				
			}
		}
		
		for(int j = (pais.length-1);j>0;j--){
			
			if(pais[j].compareTo(pais[j-1])<0){
				
				aux = pais[j+1];
				pais[j+1] = pais[j];
				pais[j] = aux;
			}
		}
		
		for(int p = 0;p<pais.length;p++){
			System.out.println(pais[p]);
		
		}
	}
	

}
