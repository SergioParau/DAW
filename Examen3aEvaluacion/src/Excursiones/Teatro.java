package Excursiones;

import java.util.ArrayList;


public class Teatro extends Edificio {
private	int numLocalidades;
	private ArrayList<Edificio> obras;
	
	
	public Teatro(int id, String nombre, String estilo, String arquitecto,
			int anyo, String direccion, int precioEntrada, int descuento, ArrayList<Edificio> obras) {

		super(id, nombre, estilo, arquitecto, anyo, direccion, precioEntrada);
		this.obras = obras;
	
		
		
		
	}
	
	public Teatro(int id, String nombre, String estilo, String arquitecto,
			int anyo, String direccion, int precioEntrada, int numLocalidades) {

		super(id, nombre, estilo, arquitecto, anyo, direccion, precioEntrada);
		obras=new ArrayList<Edificio>();
		this.numLocalidades = numLocalidades;
	}
	
		
	
	public int getNumLocalidades() {
		return numLocalidades;
	}

	public void setNumLocalidades(int numLocalidades) {
		this.numLocalidades = numLocalidades;
	}

	public ArrayList<Edificio> getObras() {
		return obras;
	}

	public void setObras(ArrayList<Edificio> obras) {
		this.obras = obras;
	}
	
	
public void anyadirObra(Teatro nombreObra) {
		
		int MAX_e = 100;
		Teatro[] e = new Teatro[MAX_e];
			int num_e = 0;
			
		
		boolean anyadir = false;
		for (int i = 0; i < e.length && !anyadir; i++) {

			if (e[i] == null) {
				e[i] = nombreObra;
				anyadir = true;
				num_e ++;
			
			}
		}
	}
	

	public void eliminarObra(Museo nombreObra) {

		int MAX_e = 100;
		Teatro[] e = new Teatro[MAX_e];
			int num_e = 0;
			
			
		boolean del = false;

		for (int i = 0; i < e.length && !del; i++) {

			if (e[i] != null && nombreObra.equals(e[i])) {
				e[i] = null;
				del = true;
				num_e--;
			}
		}
	}
	
	public String listarObra() {
		String listare = "";
		
		int MAX_e = 100;
		Teatro[] e = new Teatro[MAX_e];
			int num_e = 0;
			
	
		for (int i = 0; i < e.length; i++) {
			if (e[i] != null) {
				if(e[i] instanceof  Teatro){
				listare = listare +"\n"+"Obra\n"+ e[i].toString()+"\n";
				}
			}
		}
		return listare;
			
		}
	
	
	public String toString() {
		String teatros = "";
		
		teatros = super.toString()+ "Teatro [numLocalidades=" + numLocalidades + ", obras=" + obras
				+ "]";
		return teatros;
	}

	public int CalcularPrecio() {
		
		return 0;
	}

}
