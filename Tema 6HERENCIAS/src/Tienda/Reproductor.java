package Tienda;

public class Reproductor extends Dispositivo {

	private String espacio;
	private boolean tieneRadio;
	
	public Reproductor(){
		super();
	}
	
	public Reproductor(float peso,float ancho,float alto,float grueso,float precio,String espacio,boolean tieneRadio){
		super(peso,ancho,alto,grueso,precio);
		this.espacio = espacio;
		this.tieneRadio = tieneRadio;
	}
	
	public String getEspacio() {
		return espacio;
	}
	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}
	public boolean isTieneRadio() {
		return tieneRadio;
	}
	public void setTieneRadio(boolean tieneRadio) {
		this.tieneRadio = tieneRadio;
	}
	
	public String toString(){
		String descRep;
		
		descRep = super.toString() + "\n"+"Espacio de almacenamiento: "+espacio+"\n";
		
		if(tieneRadio){
			descRep = descRep + "Radio: Sí";
		}else{
			descRep = descRep + "Radio: No";
		}
		
		return descRep;
	}
}
