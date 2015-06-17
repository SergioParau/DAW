package GestionBiblioteca;

public class Libro {
	
	private String titulo;
	private String autor;
	private int anyo;
	private String editorial;
	private String isbn;
	
	public Libro(String isbn){
	}
	
	public Libro(String titulo,String autor,int anyo,String editorial,String isbn){
		
		this.titulo = titulo;
		this.autor = autor;
		this.anyo = anyo;
		this.editorial = editorial;
		this.isbn = isbn;
	
	}
	
	public String getTitulo(){
		
		return titulo;
	}
	
	public void setTitulo(String titulo){
		
		this.titulo = titulo;;
	}
	
	public String getAutor(){
		return autor;
	}
	
	public void setAutor(String autor){
		
		this.autor = autor;
	}
	
	public int getAnyo(){
		
		return anyo;
	}
	
	public void setAnyo(int anyo){
		
		this.anyo = anyo;
	}
	
	public String getEditorial(){
		
		return editorial;
		
	}
	
	public void setEditorial(String editorial){
		
		this.editorial = editorial;
	}
	
	public String getISBN(){
		return isbn;
	}
	
	public String toString(){

		return titulo+";"+autor+";"+anyo+";"+editorial+";"+isbn;
	}

}
