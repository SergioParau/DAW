import java.util.ArrayList;
import java.util.HashMap;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Autor m = new Autor("Sergio Parau", "26-01-1995", "x3750589w");
		Autor m1 = new Autor("Marcus Jackson", "14-04-1980", "123456789A");
		Autor m2 = new Autor("Curtis James", "25-10-1985", "123456789B");
		Autor m3 = new Autor("Lebron James", "01-01-1994", "123456789C");
		Autor m4 = new Autor("Tupac Shakur", "04-10-1959", "123456789D");
		Autor m5 = new Autor("Calvin Cordozar", "07-03-1998", "123456789E");
		Autor m6 = new Autor("Marshall Mathers", "08-08-1986", "123456789F");

		Publicacion misc = new Publicacion("Chester Bennigton", 2015, "ISBNA");
		misc.addAutor(m1);
		misc.addAutor(m2);
		misc.addAutor(m);

		ArrayList<Autor> autoresTrue = new ArrayList();
		autoresTrue.add(m3);
		autoresTrue.add(m4);
		Publicacion trueDec = new Publicacion("Mike Shinoda", 2016,
				autoresTrue, "ISBNB");

		Editorial planeta = new Editorial();

		planeta.altaPub(trueDec);
		planeta.altaPub(misc);

		System.out.println(planeta.toString());

	}

}