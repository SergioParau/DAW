package generarEntrada;

	
	import java.io.Serializable;

import conexionBD.PassMD5;
	
	public class Entrada implements Serializable {
		
		private String nombre=null; 
		private String apellidos=null;
		private String fecha=null ;
		private String nomEvent=null;
		private String localizacion=null;
		private String ciudad=null;
		private int precio=0;
		private String id = null;
		
		
		public Entrada () {
			
			
		}
		
		public Entrada (String nombre,String apellidos, String nomEvent, String fecha, String localizacion, String ciudad, int precio, String id){
			
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.fecha = fecha;
			this.nomEvent=nomEvent;
			this.localizacion=localizacion;
			this.ciudad=ciudad;
			this.precio=precio;
			this.setId(id);
			
			
			
		}

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

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public String getNomEvent() {
			return nomEvent;
		}

		public void setNomEvent(String nomEvent) {
			this.nomEvent = nomEvent;
		}

		public String getLocalizacion() {
			return localizacion;
		}

		public void setLocalizacion(String localizacion) {
			this.localizacion = localizacion;
		}

		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			PassMD5 pw = new PassMD5();
			
			String idMD5 = pw.getMD5(id);
			
			this.id = idMD5;
		}

		
		
		
	}

