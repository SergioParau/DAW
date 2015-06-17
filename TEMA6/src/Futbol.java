
public class Futbol extends Deporte {



	private int numJugs;
	
	public Futbol(int Calorias, int tiempo, int gradosTemp, int numJugs) {
		super(Calorias, tiempo, gradosTemp);
		this.numJugs=numJugs;
		
		// TODO Auto-generated constructor stub
	}

	public int getNumJugs() {
		return numJugs;
	}

	public void setNumJugs(int numJugs) {
		this.numJugs = numJugs;
	}
	
	
}
