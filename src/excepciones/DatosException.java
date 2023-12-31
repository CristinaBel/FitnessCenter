package excepciones;

public class DatosException extends Exception {
       
    String problema;
    
    public DatosException(String problema){
        super(problema);
    }
   
    public String getProblema(){
        return problema;
    }
}
