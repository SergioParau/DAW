package Instrumentos;

public class GuitarraElectrica extends InstrumentoDeCuerda{
	
	public GuitarraElectrica(String name,int numCuerdas){
		super(name,numCuerdas);
	}

	
	public String tocar(){
		
		return "Una guitarra el�ctrica de "+this.getNumCuerdas()+" cuerdas est� sonando!";
	}
	
	
}