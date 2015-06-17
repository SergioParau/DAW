package Excursiones ;



import java.util.HashMap;



public class Excursion {

	
	private HashMap <Integer, Edificio> edificio;
	private int precio;
	
	public Excursion(int precio){
		edificio= new HashMap <Integer, Edificio>();
		this.precio=precio;
	}
	
	public Excursion (HashMap<Integer, Edificio> edificio, int precio){
		this.edificio = edificio;
		this.precio=precio;
	}
	
	
	public HashMap<Integer, Edificio> getEdificio() {
		return edificio;
	}

	public void setEdificio(HashMap<Integer, Edificio> edificio) {
		this.edificio = edificio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void anyadirEdificio( int idEdificio, Edificio edificio){
		idEdificio.put(idEdificio.getId(), edificio);
	}
	
	public void eliminarEdificio(int idEdificio){
		idEdificio.remove(id);
		
		
	}
	
	
	
	
	

		
	}
	
	
	
	
