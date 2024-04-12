package entidades;
import control.Datos;

public abstract class Transporte {
    
    private String codigo;
    private String tipo;
    private int tarifaBase;
    
    public Transporte(String codigo,String tipo,int tarifaBase){
        
        this.tarifaBase = tarifaBase;
        this.codigo = codigo;
        this.tipo = tipo;
        
    }
    
    public abstract float calcularMonto(int distancia);

    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(int tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
        
    public static boolean codigoValido(String codigo){
        return codigo.length() >= 5;
    }
    
    public String getInfo(){
        String separador = Datos.SEPARADOR;
        String s = "{}" + separador + "{}"+ separador +"{}";
        return s.formatted(getClass().getSimpleName(),codigo,tipo);
    }
    
    public static void main(String[] args){
        System.out.println(new Bicicleta("123467","Normal",2).getInfo());
    }
}
