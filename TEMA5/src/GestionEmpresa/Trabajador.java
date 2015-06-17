package GestionEmpresa;

public class Trabajador {

	private String nombre;
	private String DNI;
	private int antiguedad;
	private int salario;
	private String departamento;
	
	public Trabajador(String name,String id,int anyos,int sueldo, String dept){
		
		nombre = name;
		DNI = id;
		antiguedad = anyos;
		salario = sueldo;
		departamento = dept;
	}
	
	public String getNombre(){
		
		return  nombre;
		
	}
	public String getDNI(){
		
		return DNI;
	}
	public int getAntiguedad(){
		return antiguedad;
	}
	public int getSalario(){
		return salario;
	}
	public String getDepartamento(){
		return departamento;
	}
	public String toString(){
		
		StringBuilder collect = new StringBuilder();
		collect.append(nombre+" ");
		collect.append(DNI);
		collect.append(" "+Integer.toString(antiguedad));
		collect.append(" "+Integer.toString(salario));
		collect.append(" "+departamento);
		
		return collect.toString();
		
	}
	
	
	
}
