
public class Windsurf extends Deporte {


	private boolean arnes;
	private int velViento;
	private int TamVela;
	
	public Windsurf(int Calorias, int tiempo, int gradosTemp, boolean arnes, int velViento, int TamVela) {
		super(Calorias, tiempo, gradosTemp);
		this.arnes=arnes;
		this.velViento=velViento;
		this.TamVela =TamVela;
		// TODO Auto-generated constructor stub
	}

	public boolean isArnes() {
		return arnes;
	}

	public void setArnes(boolean arnes) {
		this.arnes = arnes;
	}

	public int getVelViento() {
		return velViento;
	}

	public void setVelViento(int velViento) {
		this.velViento = velViento;
	}

	public int getTamVela() {
		return TamVela;
	}

	public void setTamVela(int tamVela) {
		TamVela = tamVela;
	}
	
}
