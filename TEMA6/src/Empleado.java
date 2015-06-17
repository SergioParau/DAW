
public class Empleado extends Persona  {
	
	
	private String nombre;
	private float salario;
	private int anyoAlta;
	public static final int INICIO_EMPRESA = 1995;
	
	
	public Empleado(String nombre_ , float salario_, int anyoAlta_){
		super(nombre_, anyoAlta_);
		salario=salario_;
	}
	
	public String getNombre(){
		return nombre;
		
	}
	
	public float getsalario(){
		return salario;
		
	}
	
	public int getanyoAlta(){
		return anyoAlta;
	}
	
	protected void setAnyoAlta(int anyoAlta_){
		int anyoActual = 2015;
		if (anyoAlta >=INICIO_EMPRESA && anyoAlta <=anyoActual)
			anyoAlta = anyoAlta_;
		else
			anyoAlta = anyoActual;
	}
	
	
	public void incSalario(float subida){
		
		salario += subida;
		
	}

	public String getDetalle(){
		return "Salario: "+salario;
	}
	
	}

	
	


