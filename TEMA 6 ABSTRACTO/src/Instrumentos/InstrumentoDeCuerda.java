package Instrumentos;



public abstract class InstrumentoDeCuerda extends Instrumento{

	private int numCuerdas;
	
	public InstrumentoDeCuerda(String nombre,int numCuerdas){
		super(nombre);
		this.setNumCuerdas(numCuerdas);
	}

	public int getNumCuerdas() {
		return numCuerdas;
	}

	public void setNumCuerdas(int numCuerdas) {
		this.numCuerdas = numCuerdas;
	}
	
}