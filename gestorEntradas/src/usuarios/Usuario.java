package usuarios;
import conexionBD.PassMD5;

public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String direccion;
	private String poblacion;
	private String provincia;
	private int codigoPostal;
	private String pais;
	private String tlf;
	private String email;
	private String nombreUsuario;
	private String contrasenya;
	private String dni;
	private boolean gestor;
	
	//constructores
	public Usuario(){
	}
	
	public Usuario(String nombre, String apellidos, String direccion, String poblacion,
			String provincia, int codigoPostal, String pais,String tlf,String email,String nombreUsuario,
			String contrasenya, String dni,boolean gestor){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.tlf = tlf;
		this.email = email;
		this.setNombreUsuario(nombreUsuario);
		this.setContrasenya(contrasenya);
		this.dni = dni;
		this.gestor = gestor;
		
	}
	
	
	//metodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public int getCodigo_postal() {
		return codigoPostal;
	}
	public void setCodigo_postal(int codigo_postal) {
		this.codigoPostal = codigo_postal;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenya() {
		
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		
		PassMD5 passGen = new PassMD5();
		this.contrasenya = passGen.getMD5(contrasenya);
	}
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
	
	public boolean isGestor() {
		return gestor;
	}
	public void setGestor(boolean gestor) {
		this.gestor = gestor;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	
	
}
