package Parque;

public class AreaProtegida extends Parque implements Visitable{

	private String ong;
	private double subvencion;
	
	public AreaProtegida(double km, String nombre, int numeroEspecies,String ong,double subvencion){
		super(km,nombre,numeroEspecies);
		this.setOng(ong);
		this.setSubvencion(subvencion);
	}

	public String getOng() {
		return ong;
	}

	public void setOng(String ong) {
		this.ong = ong;
	}

	public double getSubvencion() {
		return subvencion;
	}

	public void setSubvencion(double subvencion) {
		this.subvencion = subvencion;
	}
	
	public String visitar(){
		return "Visitando área protegida "+getNombre();
	}
	
	public String toString(){
		return super.getInfo() + "\nONG a cargo: "+getOng()+"\nSubvención recibida: "+getSubvencion()+"euros.";
	}
	
}