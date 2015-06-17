
public class Movil extends Dispositivo{
	private String operadora;
	private boolean camara;
	//FIN ATRIBUTO
	
	public Movil(int peso, int dimensiones, int precio, String operadora, boolean camara) {
		super(peso, dimensiones, precio);
		// TODO Auto-generated constructor stub
		
		this.operadora=operadora;
		this.camara=camara;
		
	
	}
	public Movil (){
		this(0, 0, 0, "amena", true);
		
	}
	
	public void imprimir (){
		super.imprimir();
		System.out.println("camara"+ camara);
		System.out.println("operadora"+ operadora);
		
	}

	
	

}
