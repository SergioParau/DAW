
public class Autor {
	
	private String nombre;
	private int inicioContrato;
	private String dni;
	
	public Autor(String nombre, int inicioContrato, String dni){
		
		this.nombre=nombre;
		this.inicioContrato=inicioContrato;
		this.dni=dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getInicioContrato() {
		return inicioContrato;
	}

	public void setInicioContrato(int inicioContrato) {
		this.inicioContrato = inicioContrato;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
	public String toString(){
		
		String cadAutor = "Nombre: "+"nombre";
		return cadAutor;
	}
}
