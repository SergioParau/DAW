import java.util.*;
public class Editorial {

	
	private HashMap <String,Publicacion> publis;
	
	public Editorial(){
		publis = new HashMap <String,Publicacion>();
	}
	
	public Editorial(HashMap<String,Publicacion> publis){
		this.publis = publis;
	}
	
	public Publicacion getPub(String isbn){
		
		Publicacion getPub = publis.get(isbn);
		
		return getPub;
	}
	
	public void altaPub(Publicacion p){
		publis.put(p.getIsbn(), p);
	}
	
	public void bajaPub(String isbn){
		publis.remove(isbn);
	}
	
	public String toString(){
		
		String cadEdit = "";
		for(Iterator <String> it = publis.keySet().iterator();it.hasNext();){
			String isbn = it.next();
			Publicacion p = publis.get(isbn);
			cadEdit = cadEdit + p.toString()+"\n";
		}
		return cadEdit;
		
	}
	
	
	
	
}
	
	
	
	
