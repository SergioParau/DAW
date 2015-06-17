
public abstract class Persona {
	
	private String nombre;
	private int anyodeAlta;
	
	
	public Persona(String nombre, int anyodeAlta){
		this.setNombre(nombre);
		this.setAnyodeAlta(anyodeAlta);
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getAnyodeAlta() {
		return anyodeAlta;
	}


	public void setAnyodeAlta(int anyodeAlta) {
		this.anyodeAlta = anyodeAlta;
	}

	public void getDescription(){
		String description = "nombre :  " +nombre+"\nAnyo de alta:"  +anyodeAlta;
		description = description +getDetalle();
		System.out.println(description);
		/*if (this instanceof Empleado){
			Empleado emp = (Empleado)this;
			description = description + "\nSalario: "+emp.getsalario();
		
		}else{
			if (this instanceof Jefe){
				Jefe Jefe =(Jefe)this;
				description = description + "\nbonificacion: "+Jefe.getbonificacion();
			}
	
		}*/
	
	}
	
	public abstract String getDetalle();

}
