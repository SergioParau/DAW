package guerra;

public class Guerra{
	public static void main(String[] args) {
		

		
		Troyano ulises = new Troyano ("Ulises",20,8);
		Troyano ulises2 = new Troyano (ulises, "Ulises2");
		Griego hector = new Griego("Hector",20,10);
		Troyano cualquier = new Troyano();
		hector.setMuerto(true);
		
		System.out.println(ulises.toString());
		System.out.println(ulises2.toString());
		System.out.println(hector.toString());
		System.out.println(cualquier.toString());
		System.out.println(hector.retirarse());
		
	}

}
