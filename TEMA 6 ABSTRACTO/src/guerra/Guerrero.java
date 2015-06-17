package guerra;

public abstract class Guerrero {

	private String nombre;
	private int edad;
	private int fuerza;
	private boolean herido;
	private boolean muerto;
	
	public Guerrero(String nombre,int edad,int fuerza){
		this.nombre = nombre;
		herido = false;
		muerto = false;
		
		if(comprobarEdad(edad)){
			this.edad = edad;
		}else{
			this.edad = 25;
		}
		
		if(comprobarFuerza(fuerza)){
			this.fuerza = fuerza;
		}else{
			this.fuerza = 5;
		}
	}

	
	public Guerrero(){
		this.nombre = "GuerreroX";
		this.edad = 15;
		this.fuerza = 1;
		herido = false;
		muerto = false;
	}
	
	public Guerrero(Guerrero warrior, String nombre){
		
		this.nombre = nombre;
		this.edad = warrior.edad;
		this.fuerza = warrior.fuerza;
		herido = false;
		herido = true;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	public boolean isHerido() {
		return herido;
	}
	public void setHerido(boolean herido) {
		this.herido = herido;
	}
	public boolean isMuerto() {
		return muerto;
	}
	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}
	
	protected static boolean comprobarEdad (int e){
		boolean f;
		
		if(e>=15&&e<=60){
			f = true;
		}else{
			f = false;
		}
		
		return f;
		
	}
	
	protected static boolean comprobarFuerza (int f){
		boolean var;
		
		if(f>=1&&f<=10){
			var = true;
		}else{
			var = false;
		}
		
		return var;
	}
	
	public abstract boolean retirarse();
	
	public String toString(){
		
		String desc = "";
		
		desc = "Nombre: "+getNombre()+"\nEdad: "+getEdad()+"\nFuerza: "+getFuerza();
		return desc;
	}
	
}