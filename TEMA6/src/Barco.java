public class Barco extends Vehiculo {

	private String caracteristicas;
	private int cilindrada;

	public Barco(String color, int num_serie, String caracteristicas,
			int cilindrada) {
		super(color, num_serie);
		this.caracteristicas = caracteristicas;
		this.cilindrada = cilindrada;

	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getDescripCoche() {

		String DescrCoche = "Caracteristicas" + caracteristicas
				+ "\nCilindrada" + cilindrada;
		return DescrCoche;

	}

}
