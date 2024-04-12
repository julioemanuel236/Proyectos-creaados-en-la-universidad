package excepciones;

public class CantidadNoValidaException extends Exception{
    private double cantidad;

    public CantidadNoValidaException(double cantidad){
        this.cantidad = cantidad;
    }
    
    @Override
    public String getMessage(){
        return cantidad+" no es una cantidad valida";
    }
}
