package Instrumentos;

public class BajoElectrico extends InstrumentoDeCuerda{
	
	public BajoElectrico(String name,int numCuerdas){
		super(name,numCuerdas);
	}

	
	public String tocar(){
		
		return "Un bajo el�ctrico de "+this.getNumCuerdas()+" cuerdas est� sonando!";
	}
	
}