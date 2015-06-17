package GestionBiblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Prestamo {

	private static int num_prestamos;
	private int id;
	private Libro Libro;
	private String fecha_inicio;
	private String fecha_fin;
	private boolean sancion;
	private String estado;

	public Prestamo(Libro Libro) {

		num_prestamos++;
		id = num_prestamos;
		this.Libro = Libro;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");// FORMATO
																			// DE
																			// FECHA
		Calendar calendar = new GregorianCalendar();// ESTABLECER CALENDARIO
													// GREGORIANO
		Date date_inicio = calendar.getTime();
		fecha_inicio = formatoFecha.format(date_inicio);
		calendar.add(Calendar.DATE, 30);// AÑADIR 30 DÍAS A LA FECHA INICIO
		Date date_fin = calendar.getTime();
		fecha_fin = formatoFecha.format(date_fin);
		sancion = false;
		estado = "activo";

	}
	
	public Prestamo(int id, String fecha_inicio, String fecha_fin, boolean sancion,String estado, Libro libro){
		
		this.id = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.sancion = sancion;
		this.estado = estado;
		this.Libro = libro;
		
		
	}

	public String getId() {

		return String.valueOf(id);

	}

	public Libro getLibro() {

		return Libro;
	}

	public String getFechaInicio() {

		return fecha_inicio;
	}

	public String getFechaFin() {

		return fecha_fin;
	}

	public boolean getSancion() {

		return sancion;
	}

	public boolean getEstado(){
        if(estado.equals("activo")){
            return true;
        }else{
            return false;
        }
    }

	public String toString() {

		return id+";"+fecha_inicio+";"+fecha_fin+";"+sancion+";"+estado+";"+Libro.toString();

	}

	public void ampliarPrestamo(int dias) throws ParseException {

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");// FORMATO
																			// DE
																			// FECHA
		Calendar calendar = new GregorianCalendar();// ESTABLECER CALENDARIO
													// GREGORIANO

			Date date_fin = formatoFecha.parse(fecha_fin);
			calendar.setTime(date_fin);
			calendar.add(Calendar.DATE, dias);
			date_fin = calendar.getTime();
			fecha_fin = formatoFecha.format(date_fin);
	}

	public void setEstado(String estado) {

		estado = "cerrado";

	}

	public void setSancion(boolean sancion) {

		sancion = true;
	}
	
	public static void setNumPrestamos(int num_prestamos_){
		num_prestamos = num_prestamos_;
	}
	
	public static int getNumPrestamos(){
		
		return num_prestamos;
	}
	
	

}
