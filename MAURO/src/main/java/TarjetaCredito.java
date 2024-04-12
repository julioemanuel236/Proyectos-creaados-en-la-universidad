public class TarjetaCredito extends Producto {
    private int cupoOtorgado;
    private int cupoUsado;

    public int getCupoOtorgado() {
        return cupoOtorgado;
    }

    public void setCupoOtorgado(int cupoOtorgado) {
        this.cupoOtorgado = cupoOtorgado;
    }

    public int getCupoUsado() {
        return cupoUsado;
    }

    public void setCupoUsado(int cupoUsado) {
        this.cupoUsado = cupoUsado;
    }
    public void abono(int monto){
        cupoUsado -= monto;
    }
    public void compra(int monto){
        cupoUsado += monto;
    }
    public String toString(){
        return super.toString()+ "Cupo otorgado: "+cupoOtorgado+ "Cupo Usado: "+cupoUsado;
    }
}