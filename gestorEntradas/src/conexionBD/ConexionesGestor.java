package conexionBD;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import usuarios.Evento;

public class ConexionesGestor extends AccesoBD{

	/*
	 * Esta clase gestiona las conexiones a Bases de datos 
	 * realizadas por los gestores con el fin de actualizar 
	 * los eventos, darlos de baja u obtener información acerca de su estado
	 */
	
	
	public void altaEvento(Evento evento){
			AccesoBD.createConexion();

			try {
				con.setAutoCommit(false);
				st = con.createStatement();
				PreparedStatement altaEvento;
				altaEvento = con.prepareStatement("INSERT INTO proyecto.evento "
						+ "(nombre,tipo_evento,localizacion,ciudad,fecha,disponible,entradas_restantes,entradas_viprestantes,"
						+ "precio_entradavip,precio_entradageneral,entradas_generalrestantes,informacion) "
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");
				altaEvento.setString(1, evento.getNombre());
				altaEvento.setString(2, evento.getTipoEvento());
				altaEvento.setString(3, evento.getLocal());
				altaEvento.setString(4, evento.getCiudad());
				altaEvento.setTimestamp(5, evento.getFecha());
				altaEvento.setBoolean(6, evento.isQuedanEntradas());
				altaEvento.setInt(7, evento.getNumVip()+evento.getNumGen());
				altaEvento.setInt(8, evento.getNumVip());
				altaEvento.setInt(9, evento.getPrecioVip());
				altaEvento.setInt(10, evento.getPrecioGen());
				altaEvento.setInt(11, evento.getNumGen());
				altaEvento.setString(12,evento.getInfo());
				altaEvento.executeUpdate();
				altaEvento.close();
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			AccesoBD.closeConexion();
		}
	
	public boolean bajaEvento(String nombre){
		
		boolean borrado = false;
		
		AccesoBD.createConexion();
		
		try{
			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement bajaEvento;
			bajaEvento = con.prepareStatement("DELETE FROM proyecto.evento WHERE lower(nombre) LIKE lower(?);");
			bajaEvento.setString(1, "%"+nombre+"%");
			int filasBorradas = bajaEvento.executeUpdate();
			if(filasBorradas > 0){
				borrado = true;
			}
			bajaEvento.close();
			con.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		AccesoBD.closeConexion();
		
		return borrado;
	}
	
	public Evento estadoEvento(String nombre){
		
		boolean disponible = false;
		int numEntradas = 0;
		int entGen = 0;
		int entVip = 0;
		Evento entradas = new Evento(disponible,numEntradas,entGen,entVip);
		AccesoBD.createConexion();
		
		try{
			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement consulta;
			consulta = con.prepareStatement("SELECT disponible,entradas_restantes,entradas_generalrestantes,entradas_viprestantes FROM proyecto.evento WHERE lower(nombre) like lower(?);");
			consulta.setString(1, "%"+nombre+"%");
			rs = consulta.executeQuery();
			if(rs.next()){
			disponible = rs.getBoolean("disponible");
			numEntradas = rs.getInt("entradas_restantes");
			entGen = rs.getInt("entradas_generalrestantes");
			entVip = rs.getInt("entradas_viprestantes");
			}
			entradas = new Evento(disponible,numEntradas,entGen,entVip);
			consulta.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		AccesoBD.closeConexion();
		
		
		return entradas;
	}
}
