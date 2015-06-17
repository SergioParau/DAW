package Parque;

public class ReservaCaza extends Parque{

	private String arma;
	private double coste;
	
	public ReservaCaza(double km, String nombre,int numEspecies, String arma, double coste){
		super(km,nombre,numEspecies);
		this.setArma(arma);
		this.setCoste(coste);
		}
	
	
	public String getArma() {
		return arma;
	}
	public void setArma(String arma) {
		this.arma = arma;
	}
	public double getCoste() {
		return coste;
	}
	public void setCoste(double coste) {
		this.coste = coste;
	}
	
	public String toString(){
		return super.getInfo() + "\nArma utilizada: "+getArma()+"\nCoste del parque: "+getCoste()+"euros.";
	}
	
}