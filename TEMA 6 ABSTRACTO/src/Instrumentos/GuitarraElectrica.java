package Instrumentos;

public class GuitarraElectrica extends InstrumentoDeCuerda{
	
	public GuitarraElectrica(String name,int numCuerdas){
		super(name,numCuerdas);
	}

	
	public String tocar(){
		
		return "Una guitarra eléctrica de "+this.getNumCuerdas()+" cuerdas está sonando!";
	}
	
	
}