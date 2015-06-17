package Excursiones;

import java.util.ArrayList;





public class Museo extends Edificio {
	
	private ArrayList<Edificio> exposiciones;
	private int descuento;

	public Museo(int id, String nombre, String estilo, String arquitecto,
			int anyo, String direccion, int precioEntrada, int descuento, ArrayList<Edificio> exposiciones) {

		super(id, nombre, estilo, arquitecto, anyo, direccion, precioEntrada);
		this.exposiciones=exposiciones;
		this.descuento=descuento;
		
		
		
	}
	
	public Museo(int id, String nombre, String estilo, String arquitecto,
			int anyo, String direccion, int precioEntrada) {

		super(id, nombre, estilo, arquitecto, anyo, direccion, precioEntrada);
		exposiciones=new ArrayList<Edificio>();
		this.descuento=descuento;
		
		
	}
	

	public ArrayList<Edificio> getExposiciones() {
		return exposiciones;
	}

	public void setExposiciones(ArrayList<Edificio> exposiciones) {
		this.exposiciones = exposiciones;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public void anyadirExposicion(Museo nombreExposicion) {
		
		int MAX_e = 100;
		Museo[] e = new Museo[MAX_e];
			int num_e = 0;
			
		
		
		boolean anyadir = false;
		for (int i = 0; i < e.length && !anyadir; i++) {

			if (e[i] == null) {
				e[i] = nombreExposicion;
				anyadir = true;
				num_e ++;
			
			}
		}
	}
	

	public void eliminarExposicion(Museo nombreExposicion) {

		int MAX_e = 100;
		Museo[] e = new Museo[MAX_e];
			int num_e = 0;
			
			
		boolean del = false;

		for (int i = 0; i < e.length && !del; i++) {

			if (e[i] != null && nombreExposicion.equals(e[i])) {
				e[i] = null;
				del = true;
				num_e--;
			}
		}
	}
	
	public String listarExposiciones() {
		String listare = "";
		
		int MAX_e = 100;
		Museo[] e = new Museo[MAX_e];
			int num_e = 0;
			
	
		for (int i = 0; i < e.length; i++) {
			if (e[i] != null) {
				if(e[i] instanceof  Museo){
				listare = listare +"\n"+"Exposicion\n"+ e[i].toString()+"\n";
				}
			}
		}
		return listare;
			
		}
	
	
	public String toString() {
		String Museos ="";
		 Museos= super.toString()+ "Museo [exposiciones=" + exposiciones + ", descuento="
				+ descuento + "]";
		 
		 return Museos;
	}

	public int CalcularPrecio() {
		
	
		return descuento ;
	}
	

}
