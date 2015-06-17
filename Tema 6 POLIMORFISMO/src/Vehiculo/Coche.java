package Vehiculo;

public class Coche extends Vehiculo{

	private int cilindrada;

	public Coche(String color,String sn,int cilindrada){
		super(color,sn);
		this.setCilindrada(cilindrada);
	}
	
	
	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	public String toString(){
		String datosCoche = "";
		
		datosCoche = super.toString()+"\n"+"Cilindrada: "+getCilindrada()+"cc";
		
		return datosCoche;
	}
}