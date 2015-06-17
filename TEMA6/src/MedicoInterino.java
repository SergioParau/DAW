
public class MedicoInterino extends Medico {
	
	private int fechaComienzoInterinidad;
	

	public MedicoInterino(String nombre, String apellidos, int edad, int fechaComienzoInterinidad) {		
		super(nombre, apellidos, edad);

		this.fechaComienzoInterinidad = fechaComienzoInterinidad;
	}


	public int getFechaComienzoInterinidad() {
		return fechaComienzoInterinidad;
	}


	public void setFechaComienzoInterinidad(int fechaComienzoInterinidad) {
		this.fechaComienzoInterinidad = fechaComienzoInterinidad;
	}


	
	public String MostrarDatos() {
		String Datos = "Fecha de comienzo" + fechaComienzoInterinidad;
		return Datos;
	}

}
