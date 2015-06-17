package Parque;

public abstract class Parque {

	private double km;
	private String nombre;
	private int numEspecies;
	
	public Parque(double km,String nombre,int numEspecies){
		this.setKm(km);
		this.setNombre(nombre);
		this.setNumEspecies(numEspecies);
	}
	
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumEspecies() {
		return numEspecies;
	}
	public void setNumEspecies(int numEspecies) {
		this.numEspecies = numEspecies;
	}
	
	public String getInfo(){
		
		return "\n-----INFO PARQUE-----\nNombre: "+getNombre()+"\nExtensión: "+getKm()+"km cuadrados\nNúmero de especies: "+getNumEspecies();
	}
	
}