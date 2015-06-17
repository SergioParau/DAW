
public class Becario  {

	private String nombre;
	private String departamento;
	private int anyoAlta;
	

	public Becario (String nombre, String departamento, int anyoAlta){
		
		this.setNombre(nombre);
		this.setDepartamento(departamento);
		this.setAnyoAlta(anyoAlta);
		
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public int getAnyoAlta() {
		return anyoAlta;
	}


	public void setAnyoAlta(int anyoAlta) {
		this.anyoAlta = anyoAlta;
	}
	
	public String getDetalle(){
		return "Departamento: "+departamento;
	}
}

