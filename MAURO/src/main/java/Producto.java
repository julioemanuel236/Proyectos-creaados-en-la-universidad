public class Producto {

    private String numero;
    private String nombre;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo(){
        return "Tipo:";
    }
    public String toString(){
        return "Numero: "+numero+ "Nombre: "+nombre;
    }
}