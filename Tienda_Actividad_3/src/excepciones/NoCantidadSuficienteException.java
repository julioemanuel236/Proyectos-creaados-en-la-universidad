
package excepciones;


public class NoCantidadSuficienteException extends Exception{
    private double cantidad;
    public NoCantidadSuficienteException(double cantidad){
        this.cantidad = cantidad;
    }
    
    @Override
    public String getMessage(){
        return "No hay suficiente cantidad para vender "+cantidad;
    }
}
