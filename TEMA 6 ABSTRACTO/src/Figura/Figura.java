package Figura;

public abstract class Figura {

	private String color;
	
	public Figura(String color){
		this.setColor(color);
	}
	
	public Figura(){
		
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract void borra();
	
	
	
	public abstract void dibuja();
		
	
}