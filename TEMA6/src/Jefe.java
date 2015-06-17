
public class Jefe extends Empleado  {
	
	private float bonificacion;
	

	public Jefe(String nombre_, float salario_, int anyoAlta , float bonificacion) {
		super(nombre_, salario_, anyoAlta);
		// TODO Auto-generated constructor stub
		this.bonificacion=bonificacion;
	}
	
	public float getbonificacion(){
		return bonificacion;
		
	}
	
	public void setBonificacion (float bonificacion){
		this.bonificacion=bonificacion;
		
	}
	public float getsalario(){
		float nuevoSalario= super.getsalario()+ super.getsalario()*bonificacion;
		return nuevoSalario;
	}
		
	public String getDetalle(){
		return "Bonificacion: "+bonificacion;
	}

	
	
	public void setanyoAlta(int anyoAlta){
		super.setAnyoAlta(anyoAlta);
	}
}
