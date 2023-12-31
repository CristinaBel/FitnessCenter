package control;

import excepciones.DatosException;
import modeloDatos.FitnessCenter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import modeloDatos.FitnessCenter.Member;
import modeloDatos.FitnessCenter.Member.Phone;


public class Control {
    
    FitnessCenter fc = new FitnessCenter();
    Properties configuracion = new Properties();
    
    
     
     
    public Control() throws FileNotFoundException, IOException, JAXBException{
        configuracion.load(new FileInputStream("C:\\datos\\configuracion.props"));                
        fc = cargar();         
        
    }
        
    public void alta(String nombre, String tipo1, String telefono1, String tipo2, String telefono2, String color, String sal, String level) throws DatosException{
        Member nuevo = new Member();
        nuevo.setName(nombre);   
        if (nombre.equals("")) throw new DatosException("Por favor, introduce un nombre válido");
        Phone p1 = new Phone();
        p1.setType(tipo1);
        p1.setValue(telefono1);
        nuevo.getPhone().add(p1);        
        Phone p2 = new Phone();
        p2.setType(tipo2);
        p2.setValue(telefono2);
        nuevo.getPhone().add(p2);        
        nuevo.setFavoriteColor(color);        
        Integer salario = Integer.valueOf(sal);
        nuevo.setSal(salario);        
        nuevo.setLevel(level);  
        synchronized (fc){
            fc.getMember().add(nuevo);
        }               
    }
    
    public void baja(String nombre) throws DatosException{
        Member m = buscar(nombre);
        synchronized (fc){
            if (m != null) fc.getMember().remove(m);
            else throw new DatosException("El contacto " + nombre + " no existe.");
        } 
    }
    
    public void modificar(String nombre, String tipo1, String telefono1, String tipo2, String telefono2, String color, String salario, String level) throws DatosException{
        Member m = buscar(nombre); 
        synchronized (this){
            if (m != null){ 
                if (!telefono1.equals("")) {
                    m.getPhone().get(0).setType(tipo1);
                    m.getPhone().get(0).setValue(telefono1);
                }
                if (!telefono2.equals("")){
                    m.getPhone().get(1).setType(tipo2);
                    m.getPhone().get(1).setValue(telefono2);
                }
                if (!color.equals("")) m.setFavoriteColor(color);
                if (!salario.equals("")) {
                    Integer sal = Integer.valueOf(salario);
                    m.setSal(m.getSal() + sal);
                }
                if (!level.equals("")) m.setLevel(level);  
            } else {
                throw new DatosException("El contacto " + nombre + " no existe.");
            }       
        }
    }
    
    public String saberColorFav(String nombre) throws DatosException{
        Member m = buscar(nombre);
        if (m == null){
            throw new DatosException("El contacto " + nombre + " no existe.");
        }
        return m.getFavoriteColor();
    }
    
    public void guardar() throws FileNotFoundException, IOException, JAXBException{       
        configuracion.store(new FileOutputStream("C:\\datos\\configuracion.props"),"Fichero de configuracion");    
        JAXBContext context = JAXBContext.newInstance(FitnessCenter.class);
        Marshaller mar = context.createMarshaller();            
        mar.setProperty (Marshaller.JAXB_ENCODING , "UTF-8" );
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String s = configuracion.getProperty("ficheroDatos");
        synchronized (fc){
            mar.marshal(fc, new File(s));
        }
    }
    
    public void guardar(String file) throws FileNotFoundException, IOException, JAXBException{       
        configuracion.store(new FileOutputStream("C:\\datos\\configuracion.props"),"Fichero de configuracion");    
        JAXBContext context = JAXBContext.newInstance(FitnessCenter.class);
        Marshaller mar = context.createMarshaller();            
        mar.setProperty (Marshaller.JAXB_ENCODING , "UTF-8" );
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        synchronized (fc){    
            mar.marshal(fc, new File(file));
        }  
    }
    
    public FitnessCenter cargar() throws FileNotFoundException, JAXBException{                        
        JAXBContext context = JAXBContext.newInstance(FitnessCenter.class);
        Unmarshaller unmar = context.createUnmarshaller();
        String s = configuracion.getProperty("ficheroDatos");
        File f = new File(s);
        synchronized (fc){
            fc = (FitnessCenter) unmar.unmarshal(f); 
        }
        return fc;
    }
    
     public FitnessCenter cargar(String file) throws FileNotFoundException, JAXBException{                        
        JAXBContext context = JAXBContext.newInstance(FitnessCenter.class);
        Unmarshaller unmar = context.createUnmarshaller();      
        File f = new File(file);
        synchronized (fc){
            fc = (FitnessCenter) unmar.unmarshal(f);   
        }
        return fc;
    }
    
    
    public String verFitnessCenter() throws DatosException{
        String cad = "";
        List <Member> lista;
        synchronized (fc){
            lista = fc.getMember();
        }
        Collections.sort(lista, new Comparador());
        for (Member m : lista){
           cad +=  consultar(m.getName())+ "\n";
       }
        return cad;
    }
    
    public String consultar(String nombre) throws DatosException{
        Member m = buscar(nombre);
        if (m != null) return m.toString();
        else {
            throw new DatosException("El contacto " + nombre + " no existe.");    
        }         
    }
    
        
    public String []consultar2(String nombre){
        Member m = buscar(nombre);
        String [] consulta = new String [8];
        if (m != null){ 
            consulta [0] = m.getName();
            consulta [1] = m.getPhone().get(0).getValue();
            consulta [2] = m.getPhone().get(0).getType();
            consulta [3] = m.getPhone().get(1).getValue(); 
            consulta [4] = m.getPhone().get(1).getType();
            consulta [5] = m.getFavoriteColor();
            consulta [6] = Integer.toString(m.getSal());
            consulta [7] = m.getLevel();          
        } 
        return consulta;
    }
        
    
    public ArrayList <String> listadoNombres(){
        ArrayList<String> listaNom = new ArrayList<>();
        List <Member> lista;
        synchronized (fc){
            lista = fc.getMember();
        }
        for (Member m : lista){
            listaNom.add(m.getName());
        }      
        return listaNom;
    }
           
    public Member buscar(String nombre){
         List <Member> l;
        synchronized (fc){
            l = fc.getMember();
        }
        for (Member m : l){
            if (m.getName().equals(nombre)){
                return m;
            } 
        }
        return null;  
    }
    
}
    