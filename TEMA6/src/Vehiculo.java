public class Vehiculo {

	private String color;
	private int num_serie;

	public Vehiculo(String color, int num_serie) {

		this.color = color;
		this.num_serie = num_serie;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(int num_serie) {
		this.num_serie = num_serie;
	}

	public String getDescription() {
		String descripcion = "color" + color + "\nNumero de serie" + num_serie;
		return descripcion;

	}

}
