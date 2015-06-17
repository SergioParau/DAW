import java.util.ArrayList;


public class Prueba {

	public static void maint (String args[]){
		
		Autor autor1 = new Autor ("Luis", 1900, "124589");
		Autor autor2 = new Autor ("Luis2", 1900, "124589");
		
		Autor autor3 = new Autor ("Luis3", 1900, "124589");
		Autor autor4 = new Autor ("Luis4", 1900, "124589");
		
		Publicacion p1 = new Publicacion("Publicacion", 1900, "isbn1");

		
		p1.addautor(autor1);
		p1.addautor(autor2);
		
		
		ArrayList<Autor>listaAutores=new ArrayList<Autor>();
		
		listaAutores.add(autor3);
		listaAutores.add(autor4);
		
		Publicacion p2 = new Publicacion("Publicacion2", 1900, "isbn2");
		
		Editorial editorial = new Editorial();
		editorial.addPublicacion(p1);
		editorial.addPublicacion(p2);
		
		System.out.println(editorial.toString());
	}
}
