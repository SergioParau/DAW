package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AccesoBD {

	
	protected static Connection con;
	protected static Statement st;
	protected static ResultSet rs;

	/*
	 * APERTURA Y CIERRE DE CONEXIONES Estos m�todos se encargan de abrir y
	 * cerrar las conexiones que se realicen a las BBDD
	 * 
	 */

	public static void createConexion() {

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gestorentradas", "postgres", "root");
			st = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}

	}

	public static void closeConexion() {

		if (con != null && st != null) {
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ====================FIN M�TODOS ABRIR/CERRAR
	// CONEXIONES=====================
}
