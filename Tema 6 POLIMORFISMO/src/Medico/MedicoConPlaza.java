package Medico;

public class MedicoConPlaza extends Medico {

	private int id;
	
	public MedicoConPlaza(int id, String nombre, String apellidos, int edad){
		super(nombre,apellidos,edad);
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String mostrarDatos(){
		
		String datosMedPlaza = "ID: "+getId()+"\n"+super.mostrarDatos();
		
		return datosMedPlaza;
	}
	
	
}
