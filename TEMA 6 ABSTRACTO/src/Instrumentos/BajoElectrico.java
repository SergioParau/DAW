package Instrumentos;

public class BajoElectrico extends InstrumentoDeCuerda{
	
	public BajoElectrico(String name,int numCuerdas){
		super(name,numCuerdas);
	}

	
	public String tocar(){
		
		return "Un bajo eléctrico de "+this.getNumCuerdas()+" cuerdas está sonando!";
	}
	
}