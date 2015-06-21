/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercoches.src;
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Taller {

    // Atributos de instancia 
    /*COMPLETAR*/
    private String nombre;
    private String direccion;
    private String hora_apertura;
    private String hora_cierre;
    private int numCoches;
    Coche[] coches;
    // Atributos de clase
    /** Numero maximo de coches en el taller. */
    private static int NUM_MAX_COCHES = 50;

    
    /** 
     *  Construye un objeto de la clase {@code Taller} con direccion {@code direccion}, hora_apertura {@code hora_apertura}, 
     *  hora_cierre {@code hora_cierre}, nombre {@code nombre} que será TallerdeCoches.
     *  
     *  @param direccion_ String. 
     *  @param hora_apertura_ String.
     *  @param hora_cierre_ String.
     */
    Taller(String direccion_, String hora_apertura_, String hora_cierre_) {

        /*COMPLETAR*/
    	nombre = "TallerdeCoches";
    	direccion = direccion_;
    	hora_apertura = hora_apertura_;
    	hora_cierre = hora_cierre_;
    	coches = new Coche[NUM_MAX_COCHES];
    	cargar();
    	
        
    }

    
    /** 
     *  Devuelve los coches que tiene o ha tenido {@code coches} el Taller {@code Taller}.
     *  @return String.
     */ 
    public Coche[] getCoches() {
        return coches;
    }

    /** 
     *  Devuelve la direccion {@code direccion} del {@code Taller}.
     *  @return String.
     */ 
    public String getDireccion() {
        return direccion;
    }

    /** 
     *  Devuelve la hora de apertura {@code hora_apertura} del {@code Taller}.
     *  @return String.
     */ 
    public String getHora_apertura() {
        return hora_apertura;
    }

    /** 
     *  Devuelve la hora de cierre {@code hora_cierre} del {@code Taller}.
     *  @return String.
     */ 
    public String getHora_cierre() {
        return hora_cierre;
    }


    
    /** 
     *   Dada una matricula {@code matricula}, 
     *   devuelve un valor true si existe un coche con esa matrícula que ha estado en el Taller.
     *   En caso contrario, devuelve un valor false.
     *   
     *   @param matricula String.
     */    
    public boolean existeCoche(String matricula) {
        
        boolean encontrado = false;
        
        /*COMPLETAR*/
        for(int i = 0;coches[i]!=null&&i<coches.length;i++){
        	if(!encontrado&&coches[i].getMatricula().equals(matricula)){
        		encontrado = true;
        	}
        }
        
        
        return encontrado;
        
    }
    
    
    
    /** 
     *   Dada un coche {@code coche}, 
     *   añade el coche al array de coches del taller e incrementa el número 
     *   de coches que están en el taller.
     *   @param Coche coche
     *   @return String.
     */  
    public String anyadirCoche(Coche coche) {
        
        String msg = "";
        boolean anyadido = false;
        if (!existeCoche(coche.getMatricula())) {
            for (int i = 0; i < coches.length && !anyadido; i++) {
                if (coches[i] == null) {
                    coches[i] = coche;
                    anyadido = true;
                    numCoches++;
                    msg = "El coche ha sido anyadido con éxito\n";
                }
            }
        } else {
            msg = "El coche ya está en el taller\n";
        }
        return msg;
    }

    
    /** 
     *  Dado una matricula {@code matricula},
     *  si existe un coche con esa matricula, el coche se borra del array de coches {@code coches} del Taller {@code Taller}
     *  y devuelve el {@code String}: "El coche ha sido eliminado con éxito"
     *  En caso contrario, la cancelacion no es posible y devuelve el {@code String}:
     *  "El coche no está en el taller"
     *  @param String matricula.
     *  @return String.
     */ 
    public String borrarCoche(String matricula) {
        String msg = "";
        boolean borrado = false;
        /*COMPLETAR*/
        
        for(int i = 0;!borrado&&i<coches.length;i++){
        	
        	if(coches[i]!=null&&coches[i].getMatricula().equals(matricula)){
        		
        		coches[i]=null;
        		borrado = true;
        		numCoches--;
        		msg = "El coche ha sido eliminado con éxito.";
        	}else{
        		msg = "El coche no está en el taller";
        	}
        	
        	
        }
        
        return msg;
        
    }


    /** 
     *  Devuelve un {@code String} con los coches que están actualmente en el taller
     * y que sean de un determinado modelo y tengan una determinada antiguedad.
     *  @param String modelo.
     *  @param int antiguedad.
     *  @return String.
     */
    public String filtroCoches(String modelo, int antiguedad) {
        String listaCoches = "";
        
        /*COMPLETAR*/
        for(int i = 0;coches[i]!=null&&i<coches.length;i++){
        	
        	if(coches[i].getModelo().equals(modelo)&&coches[i].getAntiguedad()==antiguedad){
        		listaCoches = listaCoches + coches[i].toString()+"\n";
        	}
        	
        }
        
        return listaCoches;
    }
    
    
    /** 
     *  Devuelve un {@code Coche} que tenga una matrícula igual a {@code matricula}.
     *  Si no encuentra el coche, devuelve un null.
     *  @param String matricula.
     *  @return Coche.
     */
    
    public Coche buscaCoche(String matricula){
        Coche cocheEncontrado = null;
        
        /*COMPLETAR*/
        
        for(int i = 0;coches[i]!=null&&i<coches.length;i++){
        	if(coches[i].getMatricula().equals(matricula)){
        		
        		cocheEncontrado = coches[i];
        	}
        	
        	
        }
        
        return cocheEncontrado;
    }
    
    
    /** 
     *  Devuelve un {@code String} con un informe sobre las diferencias y las similitudes entre
     *  dos coches. El informe será un String que mostrará información sobre las antiguedades 
     *  de los coches, los colores, los modelos y los talleres. 
     *  @param Coche c1.
     *  @param Coche c2.
     *  @return String.
     */
    public String comparaCoches(Coche c1, Coche c2){
        
        String informe = "";
        
        /*COMPLETAR*/
        //COMPARA ANTIGÜEDAD
        if(c1.getAntiguedad()==c2.getAntiguedad()){
        	informe = "Antigüedad: tienen la misma antigüedad: "+c1.getAntiguedad()+"\n";
        }else{
        	informe = "Antigüedad: no tienen la misma antigüedad: "+c1.getAntiguedad()+" y "+c2.getAntiguedad()+"\n";
        }
        //COMPARA COLOR
        if(c1.getColor().equals(c2.getColor())){
        	informe = informe + "Color: tienen el mismo color: "+c1.getColor()+"\n";
        }else{
        	informe = informe + "Color: no tienen el mismo color: "+c1.getColor()+" y "+c2.getColor()+"\n";
        }
        //COMPARA MODELO
        if(c1.getModelo().equals(c2.getModelo())){
        	informe = informe + "Modelo: son del mismo modelo: "+c1.getModelo()+"\n";
        }else{
        	informe = informe + "Modelo: no son del mismo modelo: "+c1.getModelo()+" y "+c2.getModelo()+"\n";
        }
        //COMPARA ESTANCIA TALLER
        if(c1.getEnTaller()==true&&c2.getEnTaller()==true){
        	informe = informe + "Taller: Están los dos en el taller";
        }else{
        	informe = informe + "Taller: No están los dos en el taller";
        }
        
        
        return informe;
    }
    
    
    
    /** 
     *  Escribe en un fichero llamado {@code nombre}, nombre del {@code Taller}, toda la informacion del mismo.   
     */
    public void guardar() {
	  PrintWriter fich = null;
	  
      /*COMPLETAR*/
    try{
    	fich = new PrintWriter("TallerDeCoches.txt");
    	
    	fich.print("numCoches");
    	fich.println(" "+numCoches);
    	for(int i = 0;i<coches.length;i++){
    		if(coches[i]!=null){
    			coches[i].guardar(fich);
    		}
    	}
    }catch(Exception e){
    	System.out.println("Error:"+e);
    }finally{
    	if(fich!=null){
    		fich.close();
    	}
    }
    } // de guardar
    
    
   
    /** 
     *  Lee desde fichero toda la informacion de los coches 
     *  que están o que han estado en el Taller y los va almacenando en el 
     *  array de coches {@code coches}.
     */    
    public void cargar() {
    
        /*COMPLETAR*/
    	Scanner in = null;
    	try{
        	in = new Scanner(new FileReader("TallerDeCoches.txt"));
        	
        int i = 0;
       	in.next();
    	numCoches = in.nextInt();
   		//System.out.println(numCoches);
   		in.nextLine();
        	
    		while(in.hasNext()){ 	
        	
        	
        		String matricula = in.next();
        		//System.out.print(matricula+" ");
        		String color = in.next();
        		//System.out.print(color+" ");
        		String modelo = in.next();
        		//System.out.print(modelo+" ");
        		int antiguedad = in.nextInt();
        		//System.out.print(antiguedad+" ");
        		boolean enTaller = in.nextBoolean();
        		//System.out.println(enTaller+" ");
        		
        		
        		coches[i] = new Coche(matricula,color,modelo,enTaller,antiguedad);
        		i++;
        	
       }
      
        	
        }catch(IOException e){
        	System.out.println("Error:"+e);
        }finally{
        	if(in!=null){
        		in.close();
        	}
        }
 
    } // de cargar
    
    
}
