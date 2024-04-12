public class CuentaAhorro extends Producto implements Cuenta{

    private int saldo;
    int COSTOMANEJO = 8900;


    public void consignar(int monto) {
        this.saldo += monto;
    }


    public void retirar(int monto) {
        this.saldo -= monto;
    }


    public int consultarSaldo() {
        return this.saldo;
    }


    public String getTipo() {
        return super.getTipo()+"Cuenta Ahorro";
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getCOSTOMANEJO() {
        return COSTOMANEJO;
    }

    public void setCOSTOMANEJO(int COSTOMANEJO) {
        this.COSTOMANEJO = COSTOMANEJO;
    }

    public int CobrarCuota(){
        return saldo - COSTOMANEJO;
    }
    public String toString(){
        return super.toString() +"Saldo: "+saldo+ "Costo manejo: "+COSTOMANEJO;
    }
}