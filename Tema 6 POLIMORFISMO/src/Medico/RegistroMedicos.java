package Medico;

public class RegistroMedicos {

	Medico[] medicos = new Medico[50];
	
	public void addMedico(Medico medico){
		boolean anyadido = false;
		
		for (int i = 0 ;i<medicos.length&&!anyadido;i++){
			if(medicos[i]==null){
				medicos[i] = medico;
				anyadido = true;
			}
		}
		
	}
	
	public String listar(){
		
		String listado = "";
		
		for(int i = 0;i<medicos.length;i++){
			if(medicos[i]!=null){
				listado = listado + medicos[i].mostrarDatos() +"\n";
			}
		}
		
		return listado;
	}
}