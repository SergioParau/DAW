package Vehiculo;

public class TestVehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RegistroVehiculo taller = new RegistroVehiculo();
		
		Coche peugeot = new Coche("plateado","p307d2001",1300);
		Coche audi = new Coche("negro","aA52010",2300);
		Coche seat = new Coche("azul","sIB1995",1100);
		Coche volvo = new Coche("rojo","vS602004",2000);
		
		Barco mag = new Barco("blanco","magBL2008");
		Barco excel = new Barco("negro","excNG1999");
		Barco excal = new Barco("azul","excAZ2002");
		Barco eloise = new Barco("marron","eloMRN1994");
		
		taller.addVehiculo(eloise);
		taller.addVehiculo(excal);
		taller.addVehiculo(excel);
		taller.addVehiculo(mag);
		taller.addVehiculo(volvo);
		taller.addVehiculo(seat);
		taller.addVehiculo(audi);
		taller.addVehiculo(peugeot);
		
		
		if(taller.encontrarVehiculo(4) instanceof Coche){
			System.out.println("El Vehículo solicitado es el siguiente coche:");
			System.out.println(taller.encontrarVehiculo(4));
		}else if(taller.encontrarVehiculo(4) instanceof Barco){
			System.out.println("El Vehículo solicitado es el siguiente barco:\n");
			System.out.println(taller.encontrarVehiculo(4));
		}
		
		
		
		System.out.println(taller.listarVehiculos());
		
		
		
		taller.delVehiculo("magBL2008");
		
	
		
		System.out.println(taller.listarVehiculos());
		
		
		
	}

}