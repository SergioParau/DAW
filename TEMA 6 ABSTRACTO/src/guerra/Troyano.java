package guerra;

public class Troyano extends Guerrero{

	public Troyano(){
		
	}
	
	public Troyano(String nombre, int edad, int fuerza){
		super(nombre,edad,fuerza);
	}
	
	public Troyano(Guerrero troyano,String nombre){
		super(troyano,nombre);
	}
	
	public boolean retirarse(){
		return false;
	}
	
	
	
	
}
