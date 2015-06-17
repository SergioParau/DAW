package Figura;

public abstract class Figura2D extends Figura{

	private String colorRelleno;

	public Figura2D(){
		
	}
	
	public Figura2D(String color, String colorRelleno){
		super(color);
		this.colorRelleno = colorRelleno;
	}
	
	
	public String getColorRelleno() {
		return colorRelleno;
	}

	public void setColorRelleno(String colorRelleno) {
		this.colorRelleno = colorRelleno;
	}
	
}