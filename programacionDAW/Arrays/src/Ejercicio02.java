
public class Ejercicio02 {

	public static void main(String[] args) {
		
		int valorA[] = {30,20,30,40};
		int valorB[] = {50,60,70,80};
		int valorC[] = new int[4];
		
		for(int i=0;i<valorA.length;i++){
		
			valorC[i] = valorA[i]+valorB[i];
			
		}
		
		for(int j=0;j<valorC.length;j++){
		System.out.println(valorC[j]);
		}
	}

}
