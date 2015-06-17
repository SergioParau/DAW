package conexionBD;

import java.sql.*;

import usuarios.Usuario;

public class Registro extends AccesoBD{
	
	

	/*
	 * LOGIN-REGISTRO USUARIOSLos siguientes metodos registran usuarios y
	 * compruebanq que los mismos existen en la BBDD
	 */

	public void regUsuario(Usuario usuario) {
		
		AccesoBD.createConexion();
		
		try {
			//int id_Usuario;
			con.setAutoCommit(false);
			/*String query = "use gestorentradas;";
            rs = st.executeQuery(query);
            PreparedStatement getCod;
            getCod = con.prepareStatement("SELECT id_Usuario FROM usuario ORDER BY id_Usuario DESC LIMIT 1;");
            rs = getCod.executeQuery();*/
            
            //rs.getInt("id_usuario");
            
            /*if(!rs.next()){
            	id_Usuario = 1;
            }else{
	            int maxID = rs.getInt("id_Usuario");
	            id_Usuario = maxID + 1;
            }*/
			PreparedStatement registro;
			registro = con.prepareStatement("INSERT INTO proyecto.usuario "
					+ "(nombre_usuario,dni,nombre,apellidos,direccion,poblacion,provincia,codigo_postal,pais,telefono,email,contrasenya,gestor) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
			//registro.setInt(1, id_Usuario);
			registro.setString(1, usuario.getNombreUsuario());
			registro.setString(2, usuario.getDNI());
			registro.setString(3, usuario.getNombre());
			registro.setString(4, usuario.getApellidos());
			registro.setString(5, usuario.getDireccion());
			registro.setString(6, usuario.getPoblacion());
			registro.setString(7, usuario.getProvincia());
			registro.setInt(8, usuario.getCodigo_postal());
			registro.setString(9, usuario.getPais());
			registro.setString(10, usuario.getTlf());
			registro.setString(11,usuario.getEmail() );
			registro.setString(12, usuario.getContrasenya());
			registro.setBoolean(13, usuario.isGestor());
			registro.executeUpdate();
			registro.close();
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		AccesoBD.closeConexion();
	}
	public boolean esGestor(String nombreUsuario){
		boolean esGestor = false;
		AccesoBD.createConexion();
		
		try{
			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement checkGestor;
			checkGestor = con.prepareStatement("SELECT gestor FROM proyecto.usuario WHERE nombre_usuario = ?;");
			checkGestor.setString(1, nombreUsuario);
			rs = checkGestor.executeQuery();
			while(rs.next()){
				esGestor = rs.getBoolean("Gestor");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return esGestor;
	}
	public boolean login(String nombreUsuario,String pw) {
		boolean login = false;
		PassMD5 passGen = new PassMD5();
		String pwMD5 = passGen.getMD5(pw);
		
		AccesoBD.createConexion();

		
		try {
			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement checkLogin;
			checkLogin = con
					.prepareStatement("SELECT nombre FROM proyecto.usuario WHERE contrasenya = ? and nombre_usuario = ?");
			checkLogin.setString(1, pwMD5);
			checkLogin.setString(2, nombreUsuario);
			rs = checkLogin.executeQuery();
			if(rs.next()){
				login = true;
			}
			checkLogin.close();
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		AccesoBD.closeConexion();

		return login;
	}
	public boolean comprobarEmail(String email){
		
		boolean foo = false;
		
		AccesoBD.createConexion();
		
		try{
			con.setAutoCommit(false);
			st = con.createStatement();
			PreparedStatement checkEmail;
			System.out.println("Consultando correo: "+email);
			checkEmail = con.prepareStatement("SELECT nombre FROM proyecto.usuario WHERE email LIKE ?;");
			checkEmail.setString(1, email);
			rs = checkEmail.executeQuery();
			if(rs.next()){
				foo = true;
				System.out.println("EXISTE");
			}
			checkEmail.close();
			con.commit();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		AccesoBD.closeConexion();
		
		return foo;
	}
	public boolean updatePassword(String email,String pw){
		boolean cambiado = false;
		PassMD5 pass = new PassMD5();
		String passMD = pass.getMD5(pw);
		
		createConexion();
		
		try{
			con.setAutoCommit(false);
			st = con.createStatement();
			
			PreparedStatement cambiarPw;
			cambiarPw = con.prepareStatement("UPDATE proyecto.usuario SET contrasenya = ? "
					+ "WHERE email LIKE ?");
			cambiarPw.setString(1, passMD);
			cambiarPw.setString(2, email);
			int filas = cambiarPw.executeUpdate();
			if(filas != 0){
				cambiado = true;
			}
			con.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeConexion();
		
		return cambiado;
	}
	//======================FIN MÉTODOS REGISTRO/LOGIN==========================//
}
