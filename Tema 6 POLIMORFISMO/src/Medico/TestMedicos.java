package Medico;

public class TestMedicos {

	public static void main(String[] args) {
		

		MedicoConPlaza sergio = new MedicoConPlaza(0, "sergio", "Parau", 20);
		MedicoInterino Marcus = new MedicoInterino("Marcus", "Jackson", 58, "15-03-1956");
		MedicoConPlaza Curtis = new MedicoConPlaza(1, "Curtis", "James", 40);
		MedicoInterino James = new MedicoInterino("James", "Jackson", 53, "12-04-1960");
		MedicoConPlaza Andre = new MedicoConPlaza(2, "Andre", "Romelle", 55);
		MedicoInterino Tupac = new MedicoInterino("Tupac ", "Shakur", 57, "17-09-1958");
		MedicoConPlaza Calvin = new MedicoConPlaza(3, "Calvin", "Cordozar", 55);
		MedicoInterino Marshall = new MedicoInterino("Marshall", "Mathers", 42, "15-06-2003");
		
		RegistroMedicos medicos = new RegistroMedicos();
		
		medicos.addMedico(sergio);
		medicos.addMedico(Marcus);
		medicos.addMedico(Curtis);
		medicos.addMedico(James);
		medicos.addMedico(Andre);
		medicos.addMedico(Tupac);
		medicos.addMedico(Calvin);
		medicos.addMedico(Marshall);
		
		
		System.out.println(medicos.listar());
		

		
		
		
		
	}

}