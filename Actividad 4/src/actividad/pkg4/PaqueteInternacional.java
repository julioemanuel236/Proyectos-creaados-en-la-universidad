
package actividad.pkg4;

public class PaqueteInternacional extends Paquete implements Envio {
    private static final double FACTOR_CONVERSION = 3000.0;
    private static final double[] PRECIOS = {69.0, 78.0, 97.0, 116.0, 135.0, 154.0, 173.0, 192.0, 211.0, 230.0, 249.0};

    public PaqueteInternacional(double peso,double alto,double ancho,double largo,String destino) {
        super(peso,alto,ancho,largo,destino);
    }
    
    @Override
    public double calcularCostoEnvio() {
        // Calculamos el peso volumétrico
        double pesoVolumetrico = (this.alto * this.ancho * this.largo) / FACTOR_CONVERSION;
        // Redondeamos al número entero siguiente si el resultado no es un número entero
        pesoVolumetrico = Math.ceil(pesoVolumetrico);
        // Si el peso real es mayor al peso volumétrico, usamos el peso real
        double peso = Math.max(this.peso, pesoVolumetrico);

        // Buscamos el precio correspondiente al peso en la tabla de precios
        int indice = Math.min((int) peso , PRECIOS.length - 1);
        double precio = PRECIOS[indice];

        return precio;
    }

    @Override
    public void enviarPaquete(Paquete paquete) {
        // Implementación del método. Por ejemplo, podríamos imprimir un mensaje
        // indicando que el paquete ha sido enviado.
        System.out.println("El paquete ha sido enviado a: " + paquete.destino);
    }
}
