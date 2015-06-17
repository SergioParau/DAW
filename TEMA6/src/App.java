import java.util.ArrayList;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*public AreaProtegida(int extension, int NumEsp, String nombre, String ONG, int sbvencion) {
		super(extension, NumEsp, nombre);*/

		ReservaDeCaza r1 = new ReservaDeCaza(5,10,"a1", 10,"arma1");
		ReservaDeCaza r2 = new ReservaDeCaza(5,10,"a2", 10,"arma2");
	
		AreaProtegida a = new AreaProtegida(1, 2, "area1", "ONG1", 2);
		AreaProtegida a2 = new AreaProtegida(1, 2, "area2", "ONG2", 2);
		AreaProtegida a3 = new AreaProtegida(1, 2, "area3", "ONG3", 2);
		
		ArrayList<?> AreaProtegida = new ArrayList();
		
		ArrayList<?> ReservaDeCaza = new ArrayList();
	}

}
