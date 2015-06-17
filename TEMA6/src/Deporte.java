
public class Deporte {

	private int Calorias;
	private int tiempo;
	private int gradosTemp;
	
	public Deporte (int Calorias, int tiempo, int gradosTemp){
		
		this.Calorias=Calorias;
		this.tiempo=tiempo;
		this.gradosTemp=gradosTemp;
		
	}

	public int getCalorias() {
		return Calorias;
	}

	public void setCalorias(int calorias) {
		Calorias = calorias;
	}

	public int getGradosTemp() {
		return gradosTemp;
	}

	public void setGradosTemp(int gradosTemp) {
		this.gradosTemp = gradosTemp;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
}

