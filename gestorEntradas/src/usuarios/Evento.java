package usuarios;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evento {
	private int id;
	private String nombre;
	private String tipoEvento; 	//(cine, teatro, m�sica, deporte,�)
	private String local;		//local de celebracion
	private String ciudad;
	private Date fecha;
	private int numGen;
	private int numVip;
	private int precioGen;
	private int precioVip;
	private int numEntradas;//asociado a cada tipo de entradas
	private String hora;
	private String info;
	private boolean quedanEntradas;
	//a la venta o agotadas
	
	
	
//constructor
	
	public Evento (){
	}
	
	public Evento(boolean quedanEntradas,int numEntradas,int entGen,int entVip){
		this.quedanEntradas = quedanEntradas;
		this.setNumEntradas(numEntradas);
		numGen = entGen;
		numVip = entVip;
	}
	
	public Evento(String nombre,String tipoEvento,String local, String ciudad,Date fecha,boolean quedanEntradas,int numGen,int precioGen,int numVip,int precioVip,String info){
		this.nombre = nombre;
		this.tipoEvento = tipoEvento;
		this.local = local;
		this.ciudad = ciudad;
		this.fecha = fecha;
		this.quedanEntradas = quedanEntradas;
		this.numGen = numGen;
		this.precioGen = precioGen;
		this.numVip = numVip;
		this.precioVip = precioVip;
		this.info = info;
	}
	
	public Evento(int id, String nombre, String tipoEvento, String local,
			String ciudad, int precioGen,int precioVip, Date fecha,
			String diaSemana) {
		this.id = id;
		this.nombre = nombre;
		this.tipoEvento = tipoEvento;
		this.local = local;
		this.ciudad = ciudad;
		this.precioGen = precioGen;
		this.setPrecioVip(precioVip);
		this.fecha = fecha;
	}
	
	
//metodos
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getPrecioGen() {
		return precioGen;
	}
	public void setPrecioGen(int precioGen) {
		this.precioGen = precioGen;
	}
	
	public int getPrecioVip() {
		return precioVip;
	}

	public void setPrecioVip(int precioVip) {
		this.precioVip = precioVip;
	}

	
	public java.sql.Timestamp getFecha() {
		
		
	    java.sql.Timestamp sqlDate = new Timestamp(fecha.getTime());
		System.out.println(sqlDate);
		return sqlDate;
	}
	
	
	public void setFecha(){
		
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String dateInString = fecha+hora;
			Date date = sdf.parse(dateInString);
			
		}catch(java.text.ParseException e){
			e.printStackTrace();
		}
	}

	public int getNumEntradas() {
		return numEntradas;
	}

	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}

	public int getNumGen() {
		return numGen;
	}

	public void setNumGen(int numGen) {
		this.numGen = numGen;
	}

	public int getNumVip() {
		return numVip;
	}

	public void setNumVip(int numVip) {
		this.numVip = numVip;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isQuedanEntradas() {
		return quedanEntradas;
	}

	public void setQuedanEntradas(boolean quedanEntradas) {
		this.quedanEntradas = quedanEntradas;
	}
}
