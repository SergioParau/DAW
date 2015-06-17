package Tienda;

public class Dispositivo {

	private float peso;
	private float ancho;
	private float alto;
	private float grueso;
	private float precio;
	
	public Dispositivo(){
		
	}
	
	public Dispositivo(float peso,float ancho,float alto,float grueso,float precio){
		this.peso = peso;
		this.ancho = ancho;
		this.alto = alto;
		this.grueso = grueso;
		this.precio = precio;
	}
	
	
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getAlto() {
		return alto;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public float getGrueso() {
		return grueso;
	}

	public void setGrueso(float grueso) {
		this.grueso = grueso;
	}
	
	public String toString(){
		String descripcion;
		
		descripcion = "Peso: "+peso+"g"+"\n"+"Dimensiones: "+ancho+"mm"+"x"+alto+"mm"+"x"+grueso+"mm"+"\n"+"Precio: "+precio+" euros";
		
		return descripcion;
	}
}