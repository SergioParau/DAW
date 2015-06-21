/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercoches.src;

import java.io.PrintWriter;


public class Coche {
    
    
    // Atributos de instancia 
    /*COMPLETAR*/
    private String matricula;
    private String modelo;
    private String color;
    private int antiguedad;
    private boolean enTaller;
   
    
    /** 
     *  Construye un objeto de la clase {@code Coche} con matricula {@code matricula}, color {@code color_}, 
     *  modelo_ {@code modelo_}, enTaller_ {@code enTaller_}, antiguedad {@code antiguedad_}.
     *  
     *  @param matricula_ String. 
     *  @param modelo_ String.
     *  @param enStock_ String.
     *  @param antiguedad_ String. 
     */
    Coche(String matricula_, String color_, String modelo_, boolean enTaller_, int antiguedad_){
        matricula = matricula_;
        color = color_;
        modelo = modelo_;
        antiguedad = antiguedad_;
        enTaller = enTaller_;
    }
    
    //Metodos
    /** 
     *  Devuelve la matricula {@code matricula} del {@code Coche}.
     *  @return String.
     */   
    public String getMatricula() {
        return matricula;
    }

     /** 
     *  Devuelve el modelo {@code modelo} del {@code Coche}.
     *  @return String.
     */
    public String getModelo() {
        return modelo;
    }

    /** 
     *  Devuelve el color {@code color} del {@code Coche}.
     *  @return String.
     */
    public String getColor() {
        return color;
    }

    /** 
     *  Devuelve si el {@code Coche} está en el Taller {@code modelo}.
     *  @return boolean.
     */
    public boolean getEnTaller() {
        return enTaller;
    }

   /** 
     *  Devuelve la antiguedad {@code antiguedad} del {@code Coche}.
     *  @return int.
     */
    public int getAntiguedad() {
        return antiguedad;
    }
   
    /** 
     *  Devuelve un {@code String} con los datos del Coche (la matrícula, el modelo, 
     *  el color, la antiguedad y si está en el taller).
     *  @return String.
     */
    @Override
    public String toString(){
        String coche = matricula+" "+color+" "+modelo+" "+antiguedad+" "+enTaller;
        return coche;
    }
    
    /** 
     *  Escribe en {@code fich} toda la informacion del {@code Coche}. 
     *  @param fich PrintWriter.
     */
    public void guardar(PrintWriter fich) throws Exception {
    /* Se invoca desde el metodo guardar de la clase Taller */        
        fich.println(matricula + " " + color + " " + modelo + " " + antiguedad + " " + enTaller);
        
    } // de guardar
}
