package excepciones;

public class SeleccionFueraDeRangoExcepction extends Exception{
    
    private int seleccion;
    private int limiteInferior;
    private int limiteSuperior;
    public SeleccionFueraDeRangoExcepction(int selecicon,int limiteInferior,int limiteSuperior){
        this.seleccion = selecicon;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }
    @Override
    public String getMessage(){
        return "Opcion "+seleccion+" Fuera Del Rango [ "+limiteInferior+" : "+limiteSuperior+" ]";
    }
}
