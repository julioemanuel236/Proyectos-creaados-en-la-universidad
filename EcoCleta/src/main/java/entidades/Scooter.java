package entidades;

public class Scooter extends Transporte{

    private String color;

    public Scooter(String codigo, String tipo,String color){
        super(codigo, tipo, 2000);
        this.color = color;
    }
            
    @Override
    public float calcularMonto(int distancia) {
        double porcentaje = 1d;
        
        if(distancia >= 0 && distancia <= 1000)porcentaje =  0.4f;
        else if(distancia > 1000 && distancia <= 2000)porcentaje = 0.3f;
        else if(distancia > 2000 && distancia <= 3000)porcentaje = 0.25f;
        else if(distancia > 3000 )porcentaje =  0.15f;
                
        return (float) ((float)getTarifaBase() + ((float)getTarifaBase() * porcentaje)) ;
    }
    
    public static boolean colorValido(String color){
        return color.length() > 5;
    }
}
