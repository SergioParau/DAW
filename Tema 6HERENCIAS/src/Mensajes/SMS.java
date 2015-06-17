package Mensajes;

public class SMS extends Mensaje {

	public String textoSMS;

	public SMS() {
		super();
	}

	public SMS(String nombreRem, String nombreDes, String numRem, String numDes) {
		super(nombreRem, nombreDes, numRem, numDes);
		this.textoSMS = textoSMS;
	}

	public void setTextoSMS(String textoSMS) {
		this.textoSMS = textoSMS;
	}

	public String getTextoSMS() {
		return textoSMS;
	}

	public String enviarSMSAgenda(String nombreDes, String texto) {

		setTextoSMS(texto);
		String mensaje = "SMS enviado correctamente de " + super.getNombreRem()
				+ " a " + super.getNombreDes() + ": " + texto;

		return mensaje;
	}

}