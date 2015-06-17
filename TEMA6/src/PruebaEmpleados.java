
public class PruebaEmpleados {
	
	public static void main(String args[]){
		Empleado empleado = new Empleado("Juan", 1000, 2001);
		System.out.println("Empleado:"+ empleado.getNombre());
		
		
		Jefe jefe = new Jefe("Pedro", 1200, 1999, 0.5f);
		System.out.println("Empleado:"+ empleado.getNombre());
		jefe.getDescription();
		
		
	}
	

}
