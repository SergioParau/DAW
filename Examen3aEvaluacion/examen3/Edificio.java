package examen3;

public abstract class Edificio {

	private int id;
	private String nombre;
	private String estilo;
	private String arquitecto;
	private int anyo;
	private String direccion;
	private int precioEntrada;

	public Edificio(int id, String nombre, String estilo, String arquitecto, int anyo,
			String direccion, int precioEntrada) {

		this.id = id;
		this.nombre = nombre;
		this.estilo = estilo;
		this.arquitecto = arquitecto;
		this.anyo = anyo;
		this.direccion = direccion;
		this.precioEntrada = precioEntrada;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getArquitecto() {
		return arquitecto;
	}

	public void setArquitecto(String arquitecto) {
		this.arquitecto = arquitecto;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(int precioEntrada) {
		this.precioEntrada = precioEntrada;
	}
	
	public abstract int calcularPrecio();

	@Override
	public String toString() {
		
		return "Edificio Nº: " + id + "\n Nombre: " + nombre + ", Estilo:"
				+ estilo + ", Arquitecto: " + arquitecto + ",\n Anyo: " + anyo
				+ ", Direccion: " + direccion + ", Precio Entrada: "
				+ precioEntrada + "\n";
	}
	
	
}
