package Mensajes;

public class Mensaje {

	private String NOMBRE_REM = "Ricardo";
	private String nombreDes;
	private String NUM_REM = "630088065";
	private String numDes;
	
	
	public Mensaje(){
		
	}
	
	public Mensaje(String nombreRem,String nombreDes,String numRem,String numDes){
		this.NOMBRE_REM=nombreRem;
		this.nombreDes=nombreDes;
		this.NUM_REM = numRem;
		this.numDes = numDes;
	}

	public String getNombreRem() {
		return NOMBRE_REM;
	}

	public void setNombreRem(String NOMBRE_REM) {
		this.NOMBRE_REM = NOMBRE_REM;
	}

	public String getNombreDes() {
		return nombreDes;
	}

	public void setNombreDes(String nombreDes) {
		this.nombreDes = nombreDes;
	}

	public String getNumRem() {
		return NUM_REM;
	}

	public void setNumRem(String NUM_REM) {
		this.NUM_REM = NUM_REM;
	}

	public String getNumDes() {
		return numDes;
	}

	public void setNumDes(String numDes) {
		this.numDes = numDes;
	}
	
	
	
	
}