/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercoches.src;

import java.util.Scanner;


public class GestorTallerCoches {

    public static int menu(Scanner tec){
        System.out.println("**************************\n"
                         + "**** TALLER DE COCHES ****\n"
                         + "**************************");
        System.out.println("1. Alta coche");
        System.out.println("2. Borra coche");
        System.out.println("3. Compara coches");
        System.out.println("4. Filtro coches");
        System.out.println("5. Guardar");
        System.out.println("0. Salir");
        
        System.out.println("**************************");
        
        return(tec.nextInt());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Taller t = new Taller("Av. LLuis Vives", "10:00", "19:00");
        t.cargar();
        
        Scanner tec = new Scanner(System.in);
        int opcion;
        do{
            opcion = menu(tec);
            switch(opcion){
                case 1:
                	boolean enTaller = false;
                    System.out.println("Alta coche:");
                    
                    /*COMPLETAR*/
                    System.out.println("Introduzca la matrícula del coche:");
                    String matricula = tec.next();
                    System.out.println("Introduzca el color del coche:");
                    String color = tec.next();
                    System.out.println("Introduzca el modelo del coche:");
                    String modelo = tec.next();
                    System.out.println("Está el coche en el taller? Si/No");
                    String respuesta = tec.next();
                    if(respuesta.equals("si")){
                    	enTaller = true;
                    }else if(respuesta.equals("no")){
                    	enTaller = false;
                    }
                    System.out.println("Introduzca (en años) la antigüedad del coche.");
                    int antiguedad = tec.nextInt();
                    
                    Coche c1 = new Coche(matricula,color,modelo,enTaller,antiguedad);
                    System.out.println(t.anyadirCoche(c1));
                    
                    break;
                    
                case 2:
                    System.out.println("Borrar coche:");
                    System.out.println("Matricula:");
                    String matriculaBorrar = tec.next();
                    System.out.println(t.borrarCoche(matriculaBorrar));
                   
                    break;
                
                case 3:
                    
                    /*COMPLETAR*/
                	System.out.println("Inserte la matrícula del primer coche:");
                	String matricula1 = tec.next();
                	System.out.println("Inserte la matrícula del segundo coche:");
                	String matricula2 = tec.next();
                	System.out.println(t.comparaCoches(t.buscaCoche(matricula1), t.buscaCoche(matricula2)));
                	break;
                	
                	
                    
                case 4:
                    System.out.println("Filtro coches:");
                    System.out.println("Introduzca el modelo del coche:");
                    String modeloFiltro = tec.next();
                    System.out.println("Introduzca la antiguedad del coche:");
                    int antiguedadFiltro = tec.nextInt();
                    System.out.println(t.filtroCoches(modeloFiltro, antiguedadFiltro));
                    break;
                
                case 5: 
                    System.out.println("Guardar:");
                    t.guardar();
                    
                    break;
            
            }
            
        }while(opcion!=0);
        
    }
}
