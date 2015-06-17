import java.sql.*;

public class Libros {

	// ATRIBUTOS DE CLASE

	private int idLibro;
	private String titulo;
	private String genero;
	private String autor;
	private double precio;

	// ATRIBUTOS BBDD

	private Statement sql;
	private ResultSet rs;
	private Connection miConexion;

	// CONSTRUCTORES =================

	public Libros() {

	}

	public Libros(int numero) {

		this.createConexion();

		try {
			miConexion.setAutoCommit(false);
			sql = miConexion.createStatement();
			PreparedStatement registro;
			registro = (PreparedStatement) miConexion
					.prepareStatement("SELECT * FROM libro WHERE idLibro = ?;");
			registro.setInt(1, numero);
			rs = registro.executeQuery();
			miConexion.commit();
			this.carga(rs);
		} catch (SQLException e) {
			e.printStackTrace();

		}

		this.closeConexion();
	}

	// ======================================

	// M�TODOS DE ACCESO A LA BASE DE DATOS
	public void createConexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/biblioteca", "root", "root");
			sql = miConexion.createStatement();

		} catch (Exception ex) {
			System.out.println("Erro: " + ex);
		}
	}

	public void closeConexion() {

		if (miConexion != null && sql != null) {
			try {
				miConexion.close();
				sql.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void borrarRegistro(int numero) {

		this.createConexion();

		try {
			miConexion.setAutoCommit(false);
			PreparedStatement borrado;
			borrado = (PreparedStatement) miConexion
					.prepareStatement("DELETE FROM libro WHERE idLibro = ?;");
			borrado.setInt(1, numero);
			borrado.executeUpdate();
			miConexion.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.closeConexion();
	}

	public String listarRegistro(String where) {
		String registro = "";

		this.createConexion();

		try {
			miConexion.setAutoCommit(false);
			sql = miConexion.createStatement();
			String query = "Select * from libro where " + where;
			rs = sql.executeQuery(query);
			miConexion.commit();

			while (rs.next()) {
				registro = registro + "T�tulo: " + rs.getString("titulo")
						+ "\nAutor: " + rs.getString("autor") + "\nG�nero: "
						+ rs.getString("genero") + "\nPrecio: "
						+ rs.getString("precio") + "\n\n";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.closeConexion();

		return registro;

	}

	public String toString() {

		String listado = "ID Libro: " + this.getIdLibro() + "\tTitulo: "
				+ this.getTitulo() + "\tGenero: " + this.getGenero()
				+ "\tAutor: " + this.getAutor();

		return listado;
	}

	public void leerRegistro(int numero) {

		this.createConexion();

		try {
			miConexion.setAutoCommit(false);
			sql = miConexion.createStatement();
			PreparedStatement registro;
			registro = (PreparedStatement) miConexion
					.prepareStatement("SELECT * FROM libro WHERE idLibro = ?;");
			registro.setInt(1, numero);
			rs = registro.executeQuery();
			miConexion.commit();
			this.carga(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.closeConexion();

	}

	private void carga(ResultSet rs) {

		try {

			while (rs.next()) {
				this.idLibro = rs.getInt("idLibro");
				this.titulo = rs.getString("titulo");
				this.genero = rs.getString("genero");
				this.autor = rs.getString("autor");
				this.precio = rs.getDouble("precio");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void grabarRegistro(Libros libro) {

		this.createConexion();

		try {
			miConexion.setAutoCommit(false);
			PreparedStatement insert;
			insert = (PreparedStatement) miConexion
					.prepareStatement("INSERT INTO libro VALUES (?,?,?,?,?);");
			insert.setInt(1, libro.getIdLibro());
			insert.setString(2, libro.getTitulo());
			insert.setString(3, libro.getGenero());
			insert.setString(4, libro.getAutor());
			insert.setDouble(5, libro.getPrecio());
			insert.executeUpdate();
			miConexion.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (miConexion != null) {
				System.out.println("Registro realizado correctamente!");
			}
		}

		this.closeConexion();

		this.closeConexion();
	}

	public void modificarRegistro(int idLibro) {

		this.createConexion();
		try {
			miConexion.setAutoCommit(false);
			sql = miConexion.createStatement();
			PreparedStatement update = (PreparedStatement) miConexion
					.prepareStatement("UPDATE libro SET titulo = ? WHERE idLibro = ?;");
			update.setString(1, this.getTitulo());
			update.setInt(2, idLibro);
			update.executeUpdate();
			miConexion.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.closeConexion();
	}

	// ==================================================================

	// GETTERS & SETTERS
	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}