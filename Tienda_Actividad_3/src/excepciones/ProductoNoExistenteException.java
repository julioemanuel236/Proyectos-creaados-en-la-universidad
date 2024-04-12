
package excepciones;


public class ProductoNoExistenteException extends Exception{
    private String nombre;
    
    public ProductoNoExistenteException(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String getMessage(){
        return nombre+" no es un producto\n";
    }
}
