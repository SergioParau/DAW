package Figura;

public class Cuadrado extends Figura2D{

	private int x0;
	private int y0;
	private int x1;
	private int y1;

	
	public Cuadrado(){
		
	}
	
	public Cuadrado(String color,String colorRelleno,int x0,int y0,int x1, int y1){
		super(color,colorRelleno);
		this.setX0(x0);
		this.setX1(x1);
		this.setY0(y0);
		this.setY1(y1);
	}

	public int getX0() {
		return x0;
	}

	public void setX0(int x0) {
		this.x0 = x0;
	}

	public int getY0() {
		return y0;
	}

	public void setY0(int y0) {
		this.y0 = y0;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	public void borra(){
		this.setColor(null);
		this.setColorRelleno(null);
		this.setX0(0);
		this.setX1(0);
		this.setY0(0);
		this.setY1(0);
	}
	
	public void dibuja(){
		this.setColor(getColor());
		this.setColorRelleno(getColorRelleno());
		this.setX0(getX0());
		this.setX1(getX1());
		this.setY0(getY0());
		this.setY1(getY1());
	}
	
}