
public class MedicoConPlaza  extends Medico{
	
	private int id_Medico;
	

	public MedicoConPlaza(String nombre, String apellidos, int edad, int id_Medico) {
		super(nombre, apellidos, edad);
		this.id_Medico = id_Medico;
	}
	
	
	

	
	public int getId_Medico() {
		return id_Medico;
	}





	public void setId_Medico(int id_Medico) {
		this.id_Medico = id_Medico;
	}





	public String MostrarDatos() {
		String Datos = "ID del Medico" + id_Medico;
		return Datos;
		
	}
		
	}


