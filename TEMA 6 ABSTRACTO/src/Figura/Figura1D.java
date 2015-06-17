package Figura;

public abstract class Figura1D extends Figura{

	private int ptoIni;
	private int ptoFin;
	
	public Figura1D(){
		super();
	}
	
	public Figura1D(String color, int ptoIni,int ptoFin){
		super(color);
		this.ptoIni = ptoIni;
		this.ptoFin = ptoFin;
		}
	
	public int getPtoIni() {
		return ptoIni;
	}
	public void setPtoIni(int ptoIni) {
		this.ptoIni = ptoIni;
	}
	public int getPtoFin() {
		return ptoFin;
	}
	public void setPtoFin(int ptoFin) {
		this.ptoFin = ptoFin;
	}
	
}