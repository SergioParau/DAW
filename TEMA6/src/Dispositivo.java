
public class Dispositivo {

	
	private int peso ;
	private int dimensiones ;
	private int precio;


public Dispositivo(int peso, int dimensiones, int precio){
	this.peso=peso;
	this.dimensiones=dimensiones;
	this.precio=precio;
	
}
public Dispositivo() {
	this(0, 0, 0);
}

public void imprimir(){
	
	System.out.println("peso: " + peso +"g");
	System.out.println("dimensiones: " + dimensiones + "mm");
	System.out.println("Precio: " + precio +"€");
}


}