package Mensajes;

public class MMS extends Mensaje {

	private String nombreImg;
	
	public MMS(){
		super();
	}
	
	public MMS(String nombreRem,String nombreDes,String numRem,String numDes,String nombreImg){
		super(nombreRem,nombreDes,numRem,numDes);
		this.setNombreImg(nombreImg);
	}

	public String getNombreImg() {
		return nombreImg;
	}

	public void setNombreImg(String nombreImg) {
		this.nombreImg = nombreImg;
	}
}
