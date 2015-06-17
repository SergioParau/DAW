package Vehiculo;

public class Vehiculo {

	private String color;
	private String sn;
	
	public Vehiculo(String color,String sn){
		this.setColor(color);
		this.setSn(sn);
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	public String toString(){
		String datos = "";
		
		datos = "Color: "+getColor()+"\n"+"Num. de Serie: "+getSn();
		
		return datos;
	}
	
}