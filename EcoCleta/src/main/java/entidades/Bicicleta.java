package entidades;

public class Bicicleta extends Transporte{
    private int cantidadCambios;

    public Bicicleta(String codigo, String tipo,int cantidadCambios){
        super(codigo, tipo, 3000);
        this.cantidadCambios = cantidadCambios;
    }

    
    @Override
    public float calcularMonto(int distancia) {
        double porcentaje = 1d;
        
        if(distancia >= 0 && distancia <= 1000)porcentaje =  0.5f;
        else if(distancia > 1000 && distancia <= 2000)porcentaje = 0.35f;
        else if(distancia > 2000 && distancia <= 3000)porcentaje = 0.2f;
        else if(distancia > 3000 )porcentaje =  0.1f;
                
        return (float) ((float)getTarifaBase() + ((float)getTarifaBase() * porcentaje)) ;
    }
    
    
}
