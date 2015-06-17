
public class AppLibros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Libros fante = new Libros(1);
		
		System.out.println(fante.toString());
		fante.setTitulo("Wait for Spring, Bandini");
		fante.modificarRegistro(1);
		System.out.println(fante.toString());
		fante.listarRegistro("precio<15");
		
		Libros galveston = new Libros();
		galveston.setIdLibro(4);
		galveston.setTitulo("Galveston");
		galveston.setGenero("Crimen");
		galveston.setAutor("Nic Pizzolato");
		galveston.setPrecio(15.35);
		galveston.grabarRegistro(galveston);
		
		System.out.println(galveston.toString());
		
		
	}

}