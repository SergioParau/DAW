package Instrumentos;

public abstract class Instrumento {

	private String nombre;
	
	public Instrumento(String nombre){
		this.nombre=nombre;
	}
	
	public Instrumento(){
		
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract String tocar();
	
}
