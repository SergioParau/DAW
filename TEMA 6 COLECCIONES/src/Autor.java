
public class Autor {

	private String nombre;
	private String inicioContrato;
	private String dni;
	
	public Autor(String nombre,String inicioContrato,String dni){
		this.setNombre(nombre);
		this.setInicioContrato(inicioContrato);
		this.setDni(dni);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getInicioContrato() {
		return inicioContrato;
	}
	public void setInicioContrato(String inicioContrato) {
		this.inicioContrato = inicioContrato;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
