package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import control.Control;
import java.io.IOException;
import javax.xml.bind.JAXBException;


public class ThreadCopia implements Runnable{
    
    Control gestor;
    Thread t;
    int i = 0;
    boolean ejecutar = false;
    
    ThreadCopia(Control gestor) throws IOException{
        t = new Thread(this);          
        this.gestor = gestor;        
    }

    @Override
    public void run() {
        while(ejecutar){
            i = (i<2)?i+1:0;            
            try {
                gestor.guardar("C:\\datos\\copia\\datos" + i + ".xml");  
                System.out.println("Copia: " + i);
                t.sleep(8000);                                 
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadCopia.class.getName()).log(Level.SEVERE, null, ex);        
            } catch (IOException ex) {
                Logger.getLogger(ThreadCopia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JAXBException ex) {
                Logger.getLogger(ThreadCopia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    Thread getThread() {
        return t;
    }
    
    
    public void copiar(){
        ejecutar = true;
        t.start();
    }
    
    public void parar(){
        ejecutar = false;
    }
    
    
}









//                gestor.guardar("/home/cris/Ceinmark/2 DAM/Acceso a datos/datos" + i + ".xml");