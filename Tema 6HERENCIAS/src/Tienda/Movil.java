package Tienda;

public class Movil extends Dispositivo {
	
	private String operadora;
	private boolean tieneCamara;
	
	public Movil(){
		super();
	}
	
	public Movil(float peso,float ancho,float alto,float grueso,float precio,String operadora,boolean tieneCamara){
		super(peso,ancho,alto,grueso,precio);
		this.operadora = operadora;
		this.tieneCamara = tieneCamara;
	}
	
	
	
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public boolean isTieneCamara() {
		return tieneCamara;
	}
	public void setTieneCamara(boolean tieneCamara) {
		this.tieneCamara = tieneCamara;
	}
	
	public String toString(){
		String descripcionMovil;
		
		descripcionMovil = super.toString() + "\n"+"Operadora: "+operadora+"\n";
		
		if(tieneCamara){
			descripcionMovil = descripcionMovil + "Cámara: Sí";
		}else{
			descripcionMovil = descripcionMovil + "Cámara: No";
		}
		
		return descripcionMovil;
	}
	
	
}