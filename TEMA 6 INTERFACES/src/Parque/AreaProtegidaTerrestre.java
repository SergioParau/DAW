package Parque;

public class AreaProtegidaTerrestre extends AreaProtegida{

	private String terreno;

	public AreaProtegidaTerrestre(double km, String nombre, int numEspecies,String ong,double subvencion,String terreno){
		super(km,nombre,numEspecies,ong,subvencion);
		this.setTerreno(terreno);
	}
	
	public String getTerreno(){
		return terreno;
	}
	
	public void setTerreno(String terreno){
		this.terreno = terreno;
	}
	
	public String getInfo(){
		return super.getInfo() + "\nTipo de terreno: "+getTerreno();
	}
	
}
	