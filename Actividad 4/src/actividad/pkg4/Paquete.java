package actividad.pkg4;

public abstract class Paquete {
    // Atributos
    protected double peso;
    protected double alto;
    protected double ancho;
    protected double largo;
    protected String destino;

    public Paquete(double peso, double alto, double ancho, double largo, String destino) {
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
        this.destino = destino;
    }

        
    // Método abstracto
    public abstract double calcularCostoEnvio();
}
