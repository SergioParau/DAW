

	import java.util.ArrayList;
	import java.util.Iterator;


	public class Publicacion {

		private String titulo;
		private int anyo;
		private ArrayList <Autor> autores;
		private String isbn;
		
		public Publicacion (String titulo, int anyo,ArrayList<Autor> autores,String isbn){
			this.setTitulo(titulo);
			this.setAnyo(anyo);
			this.autores = autores;
			this.isbn = isbn;
		}
		
		public Publicacion(String titulo,int anyo,String isbn){
			this.titulo = titulo;
			this.anyo = anyo;
			this.isbn = isbn;
			autores = new ArrayList<Autor>();
		}
		
		public void addAutor(Autor autor){
			autores.add(autor);
		}

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
		
		public String toString(){
			String info = "";
			
			info = "Titulo: "+getTitulo()+"\nAnyo: "+getAnyo()+"\nISBN: "+getIsbn()+"\nAutores:";
			
			Iterator <Autor> itAutor = autores.iterator(); 
			
			while(itAutor.hasNext()){
				info = info + "\n"+itAutor.next().getNombre();
			}
			
			return info;
		}
		
		
	}

