package excepciones;

public class CantidadNoValidaException extends Exception{
    private int cantidad;
    public CantidadNoValidaException(int cantidad){
        this.cantidad = cantidad;
    }
    
    @Override
    public String getMessage(){
        return cantidad+" no es una cantidad valida";
    }
}
