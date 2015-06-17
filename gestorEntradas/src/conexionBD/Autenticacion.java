package conexionBD;

public class Autenticacion {

	private static Autenticacion instance=null;
	
	private boolean isAuth=false;
	
	private Autenticacion() {
		
	}
	
	public static Autenticacion getAuth(){
		if(instance==null) instance=new Autenticacion();
		return instance;
	}

	public boolean isAuthenticated(){
		return this.isAuth;
	}
	
	public void setAuthenticated(boolean auth){
		this.isAuth=auth;
	}
	
}
