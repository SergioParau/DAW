package Medico;

public class MedicoInterino extends Medico {

	private String fechaComienzoInterinidad;
	
	
	public MedicoInterino(String nombre,String apellidos,int edad,String fecha){
		super(nombre,apellidos,edad);
		fechaComienzoInterinidad = fecha;
	}
	
	public String getFechaComienzoInterinidad() {
		return fechaComienzoInterinidad;
	}

	public void setFechaComienzoInterinidad(String fechaComienzoInterinidad) {
		this.fechaComienzoInterinidad = fechaComienzoInterinidad;
	}
	
	
	public String mostrarDatos(){
		
		String datosInterino = super.mostrarDatos()+"\nFecha de comienzo: "+getFechaComienzoInterinidad();
		
		return datosInterino;
	}

	
	
}