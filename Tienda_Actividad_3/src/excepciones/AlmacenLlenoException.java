package excepciones;

public class AlmacenLlenoException extends Exception{
    
    @Override
    public String getMessage(){
        return "El almacen esta lleno";
    }
    
}
