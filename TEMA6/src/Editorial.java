
import java.util.HashMap;
import java.util.Iterator;


public class Editorial {

	
	
	private HashMap<String,Publicacion> publicaciones;

	public Editorial(){
		publicaciones = new HashMap<String,Publicacion>();
	}
	
	public Editorial(HashMap<String,Publicacion> publicaciones_){
		publicaciones = publicaciones;
		
	}
	
	public void addPublicacion (Publicacion nuevaPublicacion){
		publicaciones.put(nuevaPublicacion.getIsbn(), nuevaPublicacion);
	
	
	}
	public void removePublicacion(String isbn){
		publicaciones.remove(isbn);
		
	}
		
	public String toString(){
		String	cadEditorial="";
		for(Iterator<String> it = publicaciones.keySet().iterator(); it.hasNext();){
			String clave_isbn = it.next();
				Publicacion p = publicaciones.get(clave_isbn);
				cadEditorial = cadEditorial + p.toString() + "\n";		
		}
		return cadEditorial;
	}
}
