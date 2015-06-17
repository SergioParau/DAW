
public class pruebaCuenta {

	public static void main(String[] args) {
		
		Cuenta c1 = new Cuenta(24397053,3200);
		Cuenta c2 = new Cuenta(24397052,8000);
		Cuenta c3 = new Cuenta(4827834,400);
		Cuenta c4 = new Cuenta(19832547,7200);
		
		
		c1.printInfo();
		c1.deposit();
		c1.credit();
		c1.printInfo();
		c2.printInfo();
		c2.credit();
		c2.credit();
		c2.printInfo();
		c3.printInfo();
		c3.deposit();
		c3.deposit();
		c3.printInfo();
		c1.printInfo();
		c4.printInfo();

		
		
		

		
	
		
		

	}

}
