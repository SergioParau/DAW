package Vehiculo;

public class RegistroVehiculo {

	private static int MAX_V = 100;
	Vehiculo[] V = new Vehiculo[MAX_V];
	private int num_v;

	public void addVehiculo(Vehiculo vehiculo) {

		boolean add = false;

		for (int i = 0; i < V.length && !add; i++) {

			if (V[i] == null) {
				V[i] = vehiculo;
				add = true;
				num_v++;
			}
		}
	}

	public void delVehiculo(String sn) {

		boolean del = false;

		for (int i = 0; i < V.length && !del; i++) {

			if (V[i] != null && sn.equals(V[i].getSn())) {
				V[i] = null;
				del = true;
				num_v--;
			}
		}
	}

	public void pintarVehiculo(String color) {

		for (int i = 0; i < V.length; i++) {

			if (V[i] != null) {
				V[i].setColor(color);
			}
		}
	}

	public Vehiculo encontrarVehiculo(int pos) {

		return V[pos];
	}

	public String listarVehiculos() {
		String listarV = "";

		for (int i = 0; i < V.length; i++) {
			if (V[i] != null) {
				if(V[i] instanceof Coche){
				listarV = listarV +"\n"+"Coche\n"+ V[i].toString()+"\n";
				}
				if(V[i] instanceof Barco){
				listarV = listarV+"\n" +"Barco\n"+ V[i].toString()+"\n";
				}
			}
		}

		return listarV;
	}

}
