package Mensajes;

import java.util.*;
public class Terminal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		SMS mens = new SMS();
		
		System.out.println("Seleccione el destinatario : ");
		String dest = input.next();
		mens.setNombreDes(dest);
		System.out.println("Escribe tu sms: ");
		String texto = input.nextLine();
		mens.setTextoSMS(texto);
		input.nextLine();
		System.out.println(mens.enviarSMSAgenda(dest,texto));
		
	}

}