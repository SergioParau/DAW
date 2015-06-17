package Figura;

public class Recta extends Figura1D{

	public Recta(){
		
	}
	
	public Recta(String color,int pIni,int pFin){
		super(color,pIni,pFin);
	}
	
	public void borra(){
		this.setColor(null);
		this.setPtoIni(0);
		this.setPtoFin(0);
	}
	
	public void dibuja(){
		this.setColor(getColor());
		this.setPtoIni(getPtoIni());
		this.setPtoFin(getPtoFin());
	}
	
}