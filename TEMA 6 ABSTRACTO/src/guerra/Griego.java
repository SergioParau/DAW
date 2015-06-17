package guerra;

public class Griego extends Guerrero{

	public Griego(){
		
	}
	
	public Griego(String nombre,int edad ,int fuerza){
		super(nombre,edad,fuerza);
	}
	
	public boolean retirarse(){
		boolean retiro;
		
		if(this.isHerido()&&!this.isMuerto()){
			retiro = true;
		}else{
			retiro = false;
		}
		
		return retiro;		
	}
}
