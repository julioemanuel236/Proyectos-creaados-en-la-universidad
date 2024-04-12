package excepciones;

public class NombreNoValidoException extends Exception{
    
    private String nombre;
    
    public NombreNoValidoException(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String getMessage(){
        return nombre+" no es un nombre valido\n";
    }
}
