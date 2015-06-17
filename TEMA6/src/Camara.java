
public class Camara extends Dispositivo {
	
	private int resolucion;
	private boolean flash;
	// FIN ATRIBUTOS
	
	public Camara(int peso, int dimensiones, int precio, int resolucion, boolean flash) {
		super(peso, dimensiones, precio);
		// TODO Auto-generated constructor stub
		this.resolucion = resolucion;
		this.flash=flash;
		
	}
	
	public Camara(){
		this(0, 0, 0, 1280, true);
		
	}
	
	public void imprimir(){
		 
		super.imprimir();
		System.out.println("resolucion"+ resolucion);
		System.out.println("flash"+ flash);
		
		
	}
	
		
}
