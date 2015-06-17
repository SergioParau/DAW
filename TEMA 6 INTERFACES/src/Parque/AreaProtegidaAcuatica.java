package Parque;

public class AreaProtegidaAcuatica extends AreaProtegida{

	private int numLagos;

	public AreaProtegidaAcuatica(double km, String nombre, int numEspecies,String ong,double subvencion,int numLagos){
		super(km,nombre,numEspecies,ong,subvencion);
		this.setNumLagos(numLagos);
	}
	
	public int getNumLagos() {
		return numLagos;
	}

	public void setNumLagos(int numLagos) {
		this.numLagos = numLagos;
	}
	
	public String toString(){
		return super.getInfo() + "\nNúmero de lagos: "+getNumLagos();
	}
	
}