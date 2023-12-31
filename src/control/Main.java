package control;


import excepciones.DatosException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;


public class Main {
    
    public static void main (String [] args) throws IOException, DatosException{
    
        
        Scanner teclado = new Scanner(System.in);
        final Logger LOG = Logger.getLogger(control.Control.class.getName());
        FileHandler fileXml = new FileHandler("C:\\datos\\log.xml");
        LOG.addHandler(fileXml);
        Control gestor = null;
        try {
            gestor = new Control();
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, "No se encuentra el Fitness Center", ex);
        } catch (JAXBException ex) {
            LOG.log(Level.SEVERE, "Ha habido un error", ex);
        }
        
        ThreadCopia tc = new ThreadCopia(gestor);
      
        
        String input = "-1";        
        String nombre = null;
        String telefono1 = null;
        String tipo1 = null;
        String telefono2 = null;
        String tipo2 = null;
        String color = null;
        String sal = null; 
        String nivel = null; 
                      
        do {            
            System.out.println("FITNESS CENTER");
            System.out.println("Pulse un número: ");
            System.out.println("0 - Salir del programa");
            System.out.println("1 - Dar de alta un miembro");
            System.out.println("2 - Dar de baja un miembro");
            System.out.println("3 - Modificar un miembro");
            System.out.println("4 - Consultar un miembro");
            System.out.println("5 - Consultar el color favorito de un miembro");
            System.out.println("6 - Ver un listado de todos los miembros");
            System.out.println("7 - Guardar en un fichero");
            System.out.println("8 - Cargar de un fichero");
            System.out.println("9 - Activar copia de seguridad");     
            
            input = teclado.nextLine();
     
            switch(input){
                
                case "1":
                    System.out.println("Escribe los datos del miembro a dar de alta(si no quiere rellenar un campo, déjelo en blanco): ");
                    System.out.println("Nombre: ");
                    nombre =  teclado.nextLine();  
                    if (!nombre.equals("")){
                        System.out.println("Teléfono 1: ");
                        telefono1 = teclado.nextLine();
                        System.out.println("Tipo de teléfono 1: ");
                        tipo1 = teclado.nextLine();
                        System.out.println("Teléfono 2: ");
                        telefono2 = teclado.nextLine();
                        System.out.println("Tipo de teléfono 2: ");
                        tipo2 = teclado.nextLine();
                        System.out.println("Color favorito: ");
                        color = teclado.nextLine();
                        System.out.println("Salario: ");
                        sal = teclado.nextLine();   
                        System.out.println("Nivel: ");
                        nivel = teclado.nextLine();  
                        try {    
                            gestor.alta(nombre, tipo1, telefono1, tipo2, telefono2, color, sal, nivel);
                            System.out.println("Alta realizada");
                        System.out.println(); 
                        } catch (DatosException ex) {
                            System.out.println("Por favor, introduce un nombre válido");
                            LOG.log(Level.SEVERE, null, ex);
                        }                        
                    }                    
                    break;

                case "2":
                    System.out.println("Escribe el nombre del miembro a eliminar: ");
                    nombre = teclado.nextLine();
                    if (!nombre.equals("")){
                        try {
                            gestor.baja(nombre);
                            System.out.println("Baja realizada");
                        System.out.println();
                        } catch (DatosException ex) {
                            System.out.println("Por favor, introduce un nombre válido");
                            LOG.log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                case "3":
                    System.out.println("Escribe el nombre del miembro a modificar (si no quiere rellenar un campo, déjelo en blanco): ");     
                    nombre = teclado.nextLine(); 
                    try {
                        System.out.println(gestor.consultar(nombre));
                        System.out.println(); 
                        if (!nombre.equals("")){
                            System.out.println("Tipo de teléfono 1: ");
                            tipo1 = teclado.nextLine();
                            System.out.println("Teléfono 1: ");
                            telefono1 = teclado.nextLine(); 
                            System.out.println("Tipo de teléfono 2: ");
                            tipo2 = teclado.nextLine();
                            System.out.println("Teléfono 2: ");
                            telefono2 = teclado.nextLine();                       
                            System.out.println("Escribe el nuevo color favorito: ");
                            color = teclado.nextLine();
                            System.out.println("Escribe la cantidad del aumento de salario (para un descenso escribe una cifra negativa): ");
                            sal = teclado.nextLine();   
                            System.out.println("Escribe el nuevo nivel: ");
                            nivel = teclado.nextLine();  
                            try {  
                                gestor.modificar(nombre, tipo1, telefono1, tipo2, telefono2, color, sal, nivel);
                                System.out.println("Modificación realizada");
                                System.out.println();
                            } catch (DatosException ex) {
                                LOG.log(Level.SEVERE, null, ex);
                                }                               
                        } else{
                            break;
                        } 
                    } catch (DatosException ex) {
                        System.out.println("Por favor, introduce un nombre válido");
                        LOG.log(Level.SEVERE, null, ex);
                    }
                                       
                    break;

                case "4":
                    System.out.println("Escribe el nombre del miembro a consultar: ");
                    nombre = teclado.nextLine();
                    if (!nombre.equals("")){
                        try {
                             System.out.println(gestor.consultar(nombre));
                             System.out.println();                    
                        } catch (DatosException ex) {
                            System.out.println("Por favor, introduce un nombre válido");
                            LOG.log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                case "5":
                    System.out.println("Escribe el nombre del miembro cuyo color quieres consultar: ");
                    nombre = teclado.nextLine();
                    if (!nombre.equals("")){
                        try {     
                             System.out.println(gestor.saberColorFav(nombre));
                        } catch (DatosException ex) {
                            System.out.println("Por favor, introduce un nombre válido");
                            LOG.log(Level.SEVERE, null, ex);
                        }
                        System.out.println();
                    }
                    break;

                case "6":
                    String s = gestor.verFitnessCenter();
                    System.out.println(s);
                    System.out.println();
                    break;

                case "7":                
                    try {
                        gestor.guardar();
                        System.out.println("Guardado realizado");
                        System.out.println();
                    } catch (FileNotFoundException ex) {
                        LOG.log(Level.SEVERE, "No se encuentra el Fitness Center", ex);
                    } catch (JAXBException ex) {
                        LOG.log(Level.SEVERE, "Ha habido un error", ex);
                    }
                    break;

                case "8":
                    try {
                        gestor.cargar();
                        System.out.println("Carga realizada");
                        System.out.println();
                    } catch (FileNotFoundException ex) {
                        LOG.log(Level.SEVERE, "No se encuentra el Fitness Center", ex);
                    } catch (JAXBException ex) {
                        LOG.log(Level.SEVERE, "Ha habido un error", ex);
                    }    
                    break; 

                case "9":
                    tc.copiar();
                    break;
                    
                case "0":   
                    tc.parar();               
                    try {
                        tc.getThread().join();
                    } catch (InterruptedException ex) {
                        LOG.log(Level.SEVERE, null, ex);
                    }                
                    return;

                default:   
                    System.err.println("Por favor, introduce un número del 0 al 9. \n");
            }           
        } while (true);
      
    }
}
