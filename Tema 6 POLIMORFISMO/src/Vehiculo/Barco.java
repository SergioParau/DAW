package Vehiculo;

public class Barco extends Vehiculo{

	
	//COMENTARIO DEPRUEBA
	public Barco(String color,String sn){
		super(color,sn);
	}
	
	public String toString(){
		String datosBarco = "";
		
		datosBarco = super.toString();
		
		return datosBarco;
	}
	
}