package conexionBD;

//import TableModel;

import generarEntrada.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.sql.*;

import javax.swing.table.TableModel;
import javax.xml.transform.TransformerException;

import net.proteanit.sql.DbUtils;
import conexionBD.PassMD5;

/*
 * Esta clase gestiona las conexiones a Base de Datos
 * realizadas por el usuario con el fin de buscar eventos
 */

public class ConexionesCliente extends AccesoBD {

	/*
	 * Métodos de Gestor de Usuarios. Estos metodos acceden a la base de datos
	 * para permitir al usuario buscar eventos y reservar entradas.
	 */
	private static int contadorEntradas = 001;
	private static boolean hayEntradas = false;
	private static int codigoUsuario = 0, codigoEvento = 0, precio = 0,
			codigoCompra = 0, codigoTicket = 0;
	private static String nombreUsuario = "", apellidos = "",
			nombreEvento = "", localEvento = "", ciudadEvento = "", fecha = "";

	// CAMBIO
	public TableModel buscarEvento(String nombre) {
		// CAMBIO
		TableModel tm = null;
		AccesoBD.createConexion();

		try {
			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement busquedaEvento;
			busquedaEvento = con
					.prepareStatement("SELECT "
							+ "nombre, "
							+ "tipo_evento, "
							+ "localizacion, "
							+ "ciudad, "
							+ "fecha, "
							+ "entradas_viprestantes, "
							+ "precio_entradavip, "
							+ "precio_entradageneral, "
							+ "entradas_generalrestantes, "
							+ "informacion "
							+ "FROM proyecto.evento WHERE lower(nombre) like lower(?) ;");
			busquedaEvento.setString(1, "%" + nombre + "%");
			// CAMBIO
			rs = busquedaEvento.executeQuery();
			tm = DbUtils.resultSetToTableModel(rs);

			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		AccesoBD.closeConexion();
		// CAMBIO
		return tm;
	}

	// CAMBIO
	public TableModel busquedaEventoFechas(String tipo, Date fechaInicio,
			Date fechaFin) {
		// CAMBIO
		TableModel tm = null;
		AccesoBD.createConexion();

		try {
			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement busquedaEventoFecha;
			busquedaEventoFecha = con
					.prepareStatement("SELECT "
							+ "nombre, "
							+ "tipo_evento, "
							+ "localizacion, "
							+ "ciudad, "
							+ "fecha, "
							+ "entradas_viprestantes, "
							+ "precio_entradavip, "
							+ "precio_entradageneral, "
							+ "entradas_generalrestantes, "
							+ "informacion "
							+ "FROM proyecto.evento WHERE lower(tipo_evento) like lower(?) AND fecha BETWEEN ? AND ?;");
			busquedaEventoFecha.setString(1, tipo);
			busquedaEventoFecha.setDate(2, fechaInicio);
			busquedaEventoFecha.setDate(3, fechaFin);
			// CAMBIO
			rs = busquedaEventoFecha.executeQuery();
			tm = DbUtils.resultSetToTableModel(rs);
			busquedaEventoFecha.close();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		AccesoBD.closeConexion();

		// CAMBIO
		return tm;
	}

	public boolean quedanEntradasVip(String evento, int numEntradas) {
		int num = 0;

		createConexion();
		try {

			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement comprobarVip;
			comprobarVip = con
					.prepareStatement("SELECT entradas_viprestantes FROM proyecto.evento WHERE lower(nombre) like lower(?);");
			comprobarVip.setString(1, "%" + evento + "%");
			rs = comprobarVip.executeQuery();
			while (rs.next()) {
				num = rs.getInt("entradas_viprestantes");
				if (num >= numEntradas) {
					hayEntradas = true;
				} else {
					hayEntradas = false;
				}

			}

			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConexion();

		return hayEntradas;
	}

	public boolean quedanEntradasGen(String evento, int numEntradas) {
		int num = 0;

		createConexion();
		try {

			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement comprobarGen;
			comprobarGen = con
					.prepareStatement("SELECT entradas_generalrestantes FROM proyecto.evento WHERE lower(nombre) like lower(?);");
			comprobarGen.setString(1, "%" + evento + "%");
			rs = comprobarGen.executeQuery();
			while (rs.next()) {
				num = rs.getInt("entradas_generalrestantes");
				if (num >= numEntradas) {
					hayEntradas = true;
				} else {
					hayEntradas = false;
				}

			}

			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConexion();

		return hayEntradas;
	}

	public void comprarEntrada(String pw, String nombre, String formaPago,
			Date fecha_caducidad, int cvv, String tipoTarjeta,
			String tipoEntrada, int numEntradas) {

		String codigoSeg = Integer.toString(cvv);
		Date fechaEvento = new Date(0);
		PassMD5 hash = new PassMD5();
		String pwConverted = hash.getMD5(pw);

		createConexion();

		try {

			/*
			 * RECOGIDA DE DATOS PARA GENERAR LAS TABLAS NECESARIAS DE COMPRA Y
			 * ENTRADA
			 */

			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement getUser;
			getUser = con
					.prepareStatement("SELECT id_usuario,nombre,apellidos FROM proyecto.usuario WHERE contrasenya = ?");
			getUser.setString(1, pwConverted);
			rs = getUser.executeQuery();
			while (rs.next()) {
				codigoUsuario = rs.getInt("id_usuario");
				nombreUsuario = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
			}
			getUser.close();

			if (tipoEntrada.equalsIgnoreCase("general")) {
				PreparedStatement getEventoGeneral;
				getEventoGeneral = con
						.prepareStatement("SELECT id_evento,nombre,localizacion,ciudad,fecha,precio_entradageneral "
								+ "FROM proyecto.evento WHERE lower(nombre) like lower(?);");
				getEventoGeneral.setString(1, nombre);
				rs = getEventoGeneral.executeQuery();
				while (rs.next()) {
					codigoEvento = rs.getInt("id_evento");
					nombreEvento = rs.getString("nombre");
					localEvento = rs.getString("localizacion");
					ciudadEvento = rs.getString("ciudad");
					fechaEvento = rs.getDate("fecha");
					precio = rs.getInt("precio_entradageneral");
				}
				getEventoGeneral.close();
			} else if (tipoEntrada.equalsIgnoreCase("vip")
					|| tipoEntrada.equalsIgnoreCase("especial")) {
				PreparedStatement getEventoVip;
				getEventoVip = con
						.prepareStatement("SELECT id_evento,nombre,localizacion,ciudad,fecha,precio_entradavip "
								+ "FROM proyecto.evento WHERE lower(nombre) like lower(?);");
				getEventoVip.setString(1, nombre);
				rs = getEventoVip.executeQuery();
				while (rs.next()) {
					codigoEvento = rs.getInt("id_evento");
					nombreEvento = rs.getString("nombre");
					localEvento = rs.getString("localizacion");
					ciudadEvento = rs.getString("ciudad");
					fechaEvento = rs.getDate("fecha");
					precio = rs.getInt("precio_entradavip");
				}
				getEventoVip.close();
			}

			/*
			 * GENERAMOS FILA DE COMPRA
			 */

			PreparedStatement generarCompra;
			generarCompra = con
					.prepareStatement("INSERT INTO proyecto.compra (id_usuario,forma_pago,titular,fecha_caducidad,codigo_seguridad,tipo_tarjeta) "
							+ "VALUES (?,?,?,?,?,?); ");
			generarCompra.setInt(1, codigoUsuario);
			generarCompra.setString(2, formaPago);
			generarCompra.setString(3, nombreUsuario + " " + apellidos);
			generarCompra.setDate(4, fecha_caducidad);
			generarCompra.setString(5, hash.getMD5(codigoSeg));
			generarCompra.setString(6, tipoTarjeta);
			generarCompra.executeUpdate();
			generarCompra.close();
			con.commit();

			con.setAutoCommit(false);
			PreparedStatement getCodCompra;
			getCodCompra = con
					.prepareStatement("SELECT id_compra FROM proyecto.compra ORDER BY id_compra DESC LIMIT 1;");
			rs = getCodCompra.executeQuery();
			while (rs.next()) {
				codigoCompra = rs.getInt("id_compra");
			}
			// getCodCompra.close();

			/*
			 * GENERAMOS ENTRADA
			 */

			for (int i = 0; i < numEntradas; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PreparedStatement generarTicket;
				generarTicket = con
						.prepareStatement("INSERT INTO proyecto.entrada (id_evento, descripcion, informacion_adicional,id_compra, reservado)"
								+ "VALUES (?,?,?,?,false);");
				generarTicket.setInt(1, codigoEvento);
				generarTicket.setString(2, nombreEvento + " " + localEvento
						+ " " + ciudadEvento + " " + fechaEvento);
				generarTicket.setString(3, Integer.toString(precio));
				generarTicket.setInt(4, codigoCompra);
				generarTicket.executeUpdate();
				generarTicket.close();
				getCodCompra.close();

				/*
				 * ACTUALIZAMOS NUMERO DE ENTRADAS DE EVENTO
				 */

				PreparedStatement updateEvento;
				if (tipoEntrada.equalsIgnoreCase("general")) {
					updateEvento = con
							.prepareStatement("UPDATE proyecto.evento SET entradas_generalrestantes = (entradas_generalrestantes -1) WHERE id_evento = ?;");
					updateEvento.setInt(1, codigoEvento);
					updateEvento.executeUpdate();
					updateEvento = con
							.prepareStatement("UPDATE proyecto.evento SET entradas_restantes = (entradas_restantes -1) WHERE id_evento = ?;");
					updateEvento.setInt(1, codigoEvento);
					updateEvento.executeUpdate();
					updateEvento.close();
				} else if (tipoEntrada.equalsIgnoreCase("vip")) {
					updateEvento = con
							.prepareStatement("UPDATE proyecto.evento SET entradas_generalrestantes = (entradas_viprestantes -1) WHERE id_evento = ?;");
					updateEvento.setInt(1, codigoEvento);
					updateEvento.executeUpdate();
					updateEvento = con
							.prepareStatement("UPDATE proyecto.evento SET entradas_restantes = (entradas_restantes -1) WHERE id_evento = ?;");
					updateEvento.setInt(1, codigoEvento);
					updateEvento.executeUpdate();
					updateEvento.close();
					con.commit();
				}

				/*
				 * IMPRIMIR TICKET
				 */
				// ATRIBUTOS TICKET
				String[] idUsuario = new String[3];
				String[] descripcion = new String[4];
				String titular = "";
				String descripcionEntrada = "";
				String codEntrada = null;

				PreparedStatement getCodTicket;
				getCodTicket = con
						.prepareStatement("SELECT id_entrada FROM proyecto.entrada ORDER BY id_entrada DESC LIMIT 1;");
				rs = getCodTicket.executeQuery();
				while (rs.next()) {
					codigoTicket = rs.getInt("id_entrada");
				}
				getCodTicket.close();

				PreparedStatement printTicket;
				printTicket = con
						.prepareStatement("SELECT compra.titular,entrada.descripcion, entrada.informacion_adicional FROM "
								+ "proyecto.compra INNER JOIN proyecto.entrada ON compra.id_compra = entrada.id_compra WHERE id_entrada = ?;");
				printTicket.setInt(1, codigoTicket);
				rs = printTicket.executeQuery();
				while (rs.next()) {
					titular = rs.getString("titular");
					descripcionEntrada = rs.getString("descripcion");
					precio = Integer.parseInt(rs
							.getString("informacion_adicional"));
				}

				idUsuario = titular.split(" ");
				nombre = idUsuario[0];
				apellidos = idUsuario[1] + " " + idUsuario[2];
				descripcion = descripcionEntrada.split(" ");

				nombreEvento = descripcion[0];
				localEvento = descripcion[1];
				ciudadEvento = descripcion[2];
				fecha = descripcion[3];

				con.commit();
				codEntrada = Integer.toString(codigoTicket);
				Entrada ticket = new Entrada(nombre, apellidos, nombreEvento,
						fecha, localEvento, ciudadEvento, precio, codEntrada);
				Marshaller marshaller = new Marshaller(ticket);

				marshaller.crearDocumento();
				marshaller.crearArbolDOM();

				File file = new File("ticket" + nombreEvento + contadorEntradas
						+ ".xml");

				try {
					marshaller.escribirDocumentAXml(file);
				} catch (TransformerException e) {
					e.printStackTrace();
				}

				Procesar p = new Procesar();

				String datosXML = "ticket" + nombreEvento + contadorEntradas
						+ ".xml";
				String entradaXSL = "entradas.xsl";
				String salidaHTML = "entradas2.html";
				contadorEntradas++;
				try {

					p.transform(datosXML, entradaXSL, salidaHTML);

				} catch (TransformerException e) {
					e.printStackTrace();
				}

				try {
					p.abrir(salidaHTML);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConexion();

	}

	public void comprarEntradaNoReg(String titular, String nombre,
			String formaPago, Date fecha_caducidad, int cvv,
			String tipoTarjeta, String tipoEntrada, int numEntradas)
			throws IOException {

		String titularNombre = titular;

		String codigoSeg = Integer.toString(cvv);
		Date fechaEvento = new Date(0);
		PassMD5 hash = new PassMD5();

		createConexion();

		try {

			/*
			 * RECOGIDA DE DATOS PARA GENERAR LAS TABLAS NECESARIAS DE COMPRA Y
			 * ENTRADA
			 */

			con.setAutoCommit(false);

			if (tipoEntrada.equalsIgnoreCase("general")) {
				PreparedStatement getEventoGeneral;
				getEventoGeneral = con
						.prepareStatement("SELECT id_evento,nombre,localizacion,ciudad,fecha,precio_entradageneral "
								+ "FROM proyecto.evento WHERE lower(nombre) like lower(?);");
				getEventoGeneral.setString(1, nombre);
				rs = getEventoGeneral.executeQuery();
				while (rs.next()) {
					codigoEvento = rs.getInt("id_evento");
					nombreEvento = rs.getString("nombre");
					localEvento = rs.getString("localizacion");
					ciudadEvento = rs.getString("ciudad");
					fechaEvento = rs.getDate("fecha");
					precio = rs.getInt("precio_entradageneral");
				}
				getEventoGeneral.close();
			} else if (tipoEntrada.equalsIgnoreCase("vip")
					|| tipoEntrada.equalsIgnoreCase("especial")) {
				PreparedStatement getEventoVip;
				getEventoVip = con
						.prepareStatement("SELECT id_evento,nombre,localizacion,ciudad,fecha,precio_entradavip "
								+ "FROM proyecto.evento WHERE lower(nombre) like lower(?);");
				getEventoVip.setString(1, nombre);
				rs = getEventoVip.executeQuery();
				while (rs.next()) {
					codigoEvento = rs.getInt("id_evento");
					nombreEvento = rs.getString("nombre");
					localEvento = rs.getString("localizacion");
					ciudadEvento = rs.getString("ciudad");
					fechaEvento = rs.getDate("fecha");
					precio = rs.getInt("precio_entradavip");
				}
				getEventoVip.close();
			}

			/*
			 * GENERAMOS FILA DE COMPRA
			 */

			PreparedStatement generarCompra;
			generarCompra = con
					.prepareStatement("INSERT INTO proyecto.compra (forma_pago,titular,fecha_caducidad,codigo_seguridad,tipo_tarjeta) "
							+ "VALUES (?,?,?,?,?); ");
			generarCompra.setString(1, formaPago);
			generarCompra.setString(2, titularNombre);
			generarCompra.setDate(3, fecha_caducidad);
			generarCompra.setString(4, hash.getMD5(codigoSeg));
			generarCompra.setString(5, tipoTarjeta);
			generarCompra.executeUpdate();
			generarCompra.close();
			con.commit();

			con.setAutoCommit(false);
			PreparedStatement getCodCompra;
			getCodCompra = con
					.prepareStatement("SELECT id_compra FROM proyecto.compra ORDER BY id_compra DESC LIMIT 1;");
			rs = getCodCompra.executeQuery();
			while (rs.next()) {
				codigoCompra = rs.getInt("id_compra");
			}

			/*
			 * GENERAMOS ENTRADA
			 */

			for (int i = 0; i < numEntradas; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PreparedStatement generarTicket;
				generarTicket = con
						.prepareStatement("INSERT INTO proyecto.entrada (id_evento, descripcion, informacion_adicional,id_compra, reservado)"
								+ "VALUES (?,?,?,?,false);");
				generarTicket.setInt(1, codigoEvento);
				generarTicket.setString(2, nombreEvento + " " + localEvento
						+ " " + ciudadEvento + " " + fechaEvento);
				generarTicket.setString(3, Integer.toString(precio));
				generarTicket.setInt(4, codigoCompra);
				generarTicket.executeUpdate();
				generarTicket.close();
				getCodCompra.close();

				/*
				 * ACTUALIZAMOS NUMERO DE ENTRADAS DE EVENTO
				 */

				PreparedStatement updateEvento;
				if (tipoEntrada.equalsIgnoreCase("general")) {
					updateEvento = con
							.prepareStatement("UPDATE proyecto.evento SET entradas_generalrestantes = (entradas_generalrestantes -1) WHERE id_evento = ?;");
					updateEvento.setInt(1, codigoEvento);
					updateEvento.executeUpdate();
					updateEvento = con
							.prepareStatement("UPDATE proyecto.evento SET entradas_restantes = (entradas_restantes -1) WHERE id_evento = ?;");
					updateEvento.setInt(1, codigoEvento);
					updateEvento.executeUpdate();
					updateEvento.close();
				} else if (tipoEntrada.equalsIgnoreCase("vip")) {
					updateEvento = con
							.prepareStatement("UPDATE proyecto.evento SET entradas_generalrestantes = (entradas_viprestantes -1) WHERE id_evento = ?;");
					updateEvento.setInt(1, codigoEvento);
					updateEvento.executeUpdate();
					updateEvento = con
							.prepareStatement("UPDATE proyecto.evento SET entradas_restantes = (entradas_restantes -1) WHERE id_evento = ?;");
					updateEvento.setInt(1, codigoEvento);
					updateEvento.executeUpdate();
					updateEvento.close();

				}
				con.commit();
				/*
				 * IMPRIMIR TICKET
				 */
				// ATRIBUTOS TICKET
				String[] idUsuario = new String[3];
				String[] descripcion = new String[4];
				String descripcionEntrada = "";
				String codEntrada = null;

				PreparedStatement getCodTicket;
				getCodTicket = con
						.prepareStatement("SELECT id_entrada FROM proyecto.entrada ORDER BY id_entrada DESC LIMIT 1;");
				rs = getCodTicket.executeQuery();
				while (rs.next()) {
					codigoTicket = rs.getInt("id_entrada");
				}
				getCodTicket.close();

				PreparedStatement printTicket;
				printTicket = con
						.prepareStatement("SELECT compra.titular,entrada.descripcion, entrada.informacion_adicional FROM "
								+ "proyecto.compra INNER JOIN proyecto.entrada ON compra.id_compra = entrada.id_compra WHERE id_entrada = ?;");
				printTicket.setInt(1, codigoTicket);
				rs = printTicket.executeQuery();
				while (rs.next()) {
					titular = rs.getString("titular");
					descripcionEntrada = rs.getString("descripcion");
					precio = Integer.parseInt(rs
							.getString("informacion_adicional"));
				}

				idUsuario = titular.split(" ");
				nombre = idUsuario[0];
				apellidos = idUsuario[1] + " " + idUsuario[2];
				descripcion = descripcionEntrada.split(" ");

				nombreEvento = descripcion[0];
				localEvento = descripcion[1];
				ciudadEvento = descripcion[2];
				fecha = descripcion[3];

				con.commit();
				codEntrada = Integer.toString(codigoTicket);
				Entrada ticket = new Entrada(nombre, apellidos, nombreEvento,
						fecha, localEvento, ciudadEvento, precio, codEntrada);

				Marshaller marshaller = new Marshaller(ticket);

				marshaller.crearDocumento();
				marshaller.crearArbolDOM();

				File file = new File("ticket" + nombreEvento + contadorEntradas
						+ ".xml");

				try {
					marshaller.escribirDocumentAXml(file);
				} catch (TransformerException e) {
					e.printStackTrace();
				}

				Procesar p = new Procesar();

				String datosXML = "ticket" + nombreEvento + contadorEntradas
						+ ".xml";
				String entradaXSL = "entradas.xsl";
				String salidaHTML = "entradas2.html";
				contadorEntradas++;
				try {

					p.transform(datosXML, entradaXSL, salidaHTML);

				} catch (TransformerException e) {
					e.printStackTrace();
				}

				try {
					p.abrir(salidaHTML);

				} catch (IOException e) {
					e.printStackTrace();
				}

				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConexion();

	}

	public boolean checkPassword(String pw) {
		boolean esPassword = false;
		PassMD5 pwCrypt = new PassMD5();
		String pass = pwCrypt.getMD5(pw);

		createConexion();

		try {
			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement existeContraseña;
			existeContraseña = con
					.prepareStatement("SELECT nombre FROM proyecto.usuario WHERE contrasenya LIKE ?");
			existeContraseña.setString(1, pass);
			rs = existeContraseña.executeQuery();
			if (rs.next()) {
				esPassword = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConexion();
		return esPassword;
	}

	public boolean entradasVenta(String nombre) {
		boolean venta = false;

		createConexion();

		try {
			con.setAutoCommit(false);

			st = con.createStatement();
			PreparedStatement checkVenta;
			checkVenta = con
					.prepareStatement("SELECT disponible FROM proyecto.evento WHERE lower(nombre) LIKE lower(?);");
			checkVenta.setString(1, nombre);
			rs = checkVenta.executeQuery();
			while (rs.next()) {
				venta = rs.getBoolean("disponible");
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConexion();

		return venta;
	}

}
