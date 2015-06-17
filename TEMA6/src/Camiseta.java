
public class Camiseta extends Ropa {

	private String mangas;
	private boolean dibujo;


public Camiseta ( String c, String f, float p, String t, String mangas, boolean dibujo) {
	
	super (c, f, p, t);
	this.mangas=mangas;
	this.dibujo=dibujo;
	
}

public Camiseta() {
	this("sin color", "sin fabricante", 0, "sin tejido", "asasd", true);
}
public void imprimir() {
	super.imprimir();
	System.out.println("goles recibidos:" + mangas);
	System.out.println("penaltis parados:" + dibujo);
}
}
