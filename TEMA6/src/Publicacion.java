import java.util.ArrayList;
import java.util.*;

public class Publicacion {
	
	private String titulo;
	private int anyo;
	private String isbn;
	private ArrayList <Autor> Autor;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public ArrayList<Autor> getAutor() {
		return Autor;
	}

	public void setAutor(ArrayList<Autor> autor) {
		Autor = autor;
	}

	public Publicacion (String titulo, int anyo, String isbn, ArrayList<Autor>Autor){
		
		this.titulo=titulo;
		this.anyo=anyo;
		this.isbn=isbn;
		this.Autor=Autor;
		
	}
	
	public Publicacion (String titulo, int anyo, String isbn){
		
		this.titulo=titulo;
		this.anyo=anyo;
		this.isbn=isbn;
		this.Autor=new ArrayList<Autor>();
		
	}
	
	public void addautor(Autor autor){
		Autor.add(autor);
		
		
	}
	
	public String toString(){
		
		String cadPub = "Titulo"  "+titulo+"\n +
						"Anyo" + "+Anyo+"\n +
						"isbn" + "+isbn+"\n +
						"autor"+ "+Autor+"\n;
		
	
				
				
	}
	
	
}
