package Futbol;

public class Portero extends Jugador {
	
	private int golesRecibidos;
	private int penaltisParados;
	
	public Portero(){
		super();
		
	}
	
	public Portero(String n, String d, int p, int g, int a, int r,int golRec,int penPar){
		super(n,d,p,g,a,r);
		golesRecibidos = golRec;
		penaltisParados = penPar;
		
	}

	public int getGolesRecibidos() {
		return golesRecibidos;
	}

	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}

	public int getPenaltisParados() {
		return penaltisParados;
	}

	public void setPenaltisParados(int penaltisParados) {
		this.penaltisParados = penaltisParados;
	}
	
	public void imprimir(){
		super.imprimir();
		System.out.println("Goles recibidos: "+golesRecibidos);
		System.out.println("Penaltis parados: "+penaltisParados);
	}
}