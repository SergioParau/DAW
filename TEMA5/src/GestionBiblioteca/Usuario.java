package GestionBiblioteca;

public class Usuario {

	private String nombre;
	private int dni;
	private String direccion;
	private int num_prestamos;
	private Prestamo[] prestamos;

	
	public Usuario(String nombre, int dni, String direccion,Prestamo[] prestamos) {
		
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.prestamos = prestamos;
		
		for(int i=0;i<prestamos.length;i++){
			if(prestamos[i]!=null){
				num_prestamos++;
			}
		}
	}

	
	
	public Usuario(String nombre_, int dni_, String direccion_) {
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		num_prestamos = 0;
		prestamos = new Prestamo[10];

	}

	
	public String getNombre() {

		return nombre;
	}

	public int getDNI() {

		
		
		return dni;
	}

	public String getDireccion() {

		return direccion;
	}

	public int getNumPrestamos() {

		return num_prestamos;
	}

	public Prestamo[] getPrestamosActivos() {

		Prestamo[] prestamosActivos = new Prestamo[10];
		
		int j=0;
		
		for (int i = 0; i < prestamos.length; i++) {

			if (prestamos[i] != null && prestamos[i].getEstado()==true) {
				
				prestamosActivos[j] = prestamos[i];
				j++;
			}
		}

		return prestamosActivos;
	}

	public Prestamo[] getPrestamosSancionados() {

		Prestamo[] prestamosSancionados = new Prestamo[10];
		int j = 0;
		for (int i = 0; i < prestamos.length; i++) {

			if (prestamos[i] != null && prestamos[i].getSancion() == true) {

				prestamosSancionados[j] = prestamos[i];
				j++;
			}
		}

		return prestamosSancionados;
	}

	boolean existePrestamo(int id_prestamo) {

		boolean existe = false;

		for (int i = 0; i < prestamos.length && existe == false; i++) {

			if (prestamos[i] != null && String.valueOf(id_prestamo) == prestamos[i].getId()) {
				existe = true;
			}

		}

		return existe;

	}

	public void addPrestamo(Prestamo prestamo_) {

		boolean anyadido = false;

		if (num_prestamos > 10) {
			System.out
					.println("Se ha excedido el número máximo de préstamos. Cancele alguno para poder añadir uno nuevo.");

		} else {

			if (existePrestamo(Integer.parseInt(prestamo_.getId()))==false) {
				for (int i = 0; i < prestamos.length; i++) {

					if (prestamos[i] == null && anyadido == false) {

						prestamos[i] = prestamo_;
						anyadido = true;
						num_prestamos++;

					}

				}
			}
		}
	}//FIN AÑADIR PRESTAMO
	
	public void cancelarPrestamo(int id_prestamo){
		
		boolean cancelado = false;
		
		if(existePrestamo(id_prestamo)){
			
			for(int i=0;i<prestamos.length&&cancelado == false;i++){
				
				if(prestamos[i]!=null&&prestamos[i].getId().equals(String.valueOf(id_prestamo))){
					
					prestamos[i]=null;
					cancelado = true;
					
				}
				
			}
			
			
		}else{
			System.out.println("Este id no se corresponde con ningún préstamo. Vuelva a insertarlo.");
		}
	}//FIN CANCELAR PRESTAMO

	public String toString(){
		
		String cadenaUsuario = nombre + ";" + dni + ";" + direccion + ";" + num_prestamos + ";\n";
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] != null) {
                cadenaUsuario = cadenaUsuario + prestamos[i].toString() + "\n";
            }
        }
		return cadenaUsuario;
		
		
		
	}
	
}
