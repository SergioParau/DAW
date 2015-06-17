package Figura;

public class Curva extends Figura1D{

	private int radio;
	
	
	public Curva(){
		
	}
	
	public Curva(String color,int pIni,int pFin,int radio){
		super(color,pIni,pFin);
		this.radio = radio;
	}
	
	public void borra(){
		this.setColor(null);
		this.setPtoIni(0);
		this.setPtoFin(0);
		this.setRadio(0);
	}
	
	public void dibuja(){
		this.setColor(getColor());
		this.setPtoIni(getPtoIni());
		this.setPtoFin(getPtoFin());
		this.setRadio(getRadio());
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
}