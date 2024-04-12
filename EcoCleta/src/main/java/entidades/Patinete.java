package entidades;

public class Patinete extends Transporte{
    
    private int cantidadRuedas;

    public Patinete(String codigo, String tipo,int cantidadRuedas){
        super(codigo, tipo, 1500);
        this.cantidadRuedas = cantidadRuedas;
    }

    

    @Override
    public float calcularMonto(int distancia) {
        double porcentaje = 1d;
        
        if(distancia >= 0 && distancia <= 1000)porcentaje =  0.20f;
        else if(distancia > 1000 && distancia <= 2000)porcentaje = 0.15f;
        else if(distancia > 2000 && distancia <= 3000)porcentaje = 0.10f;
        else if(distancia > 3000 )porcentaje =  0.5f;
                
        return (float) ((float)getTarifaBase() + ((float)getTarifaBase() * porcentaje)) ;
    }
}
