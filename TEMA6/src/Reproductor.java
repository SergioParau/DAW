
public class Reproductor  extends Dispositivo{
	
	private int almacenamiento;
	private boolean radio;
	//FIN ATRIBUTOS
	
	
	public Reproductor(int peso, int dimensiones, int precio, int almacenamiento, boolean radio) {
		super(peso, dimensiones, precio);
		// TODO Auto-generated constructor stub
		this.almacenamiento=almacenamiento;
		this.radio=radio;
		
	}
	
	public Reproductor(){
		this(0, 0, 0, 512, true);
	}

		public void imprimir(){
			super.imprimir();
			System.out.println("Almacenamiento"+ almacenamiento + "MB");
			System.out.println("radio"+ radio);
			
		}
		
	
}


