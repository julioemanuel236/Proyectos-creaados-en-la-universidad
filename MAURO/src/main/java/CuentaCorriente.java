public class CuentaCorriente extends Producto implements Cuenta {

    private int saldo;
    private int cupoSobregiro;


    public void consignar(int monto) {
        this.saldo += monto;
    }


    public void retirar(int monto) {
        this.saldo -= monto;
    }


    public int consultarSaldo() {
        return saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getCupoSobregiro() {
        return cupoSobregiro;
    }

    public void setCupoSobregiro(int cupoSobregiro) {
        this.cupoSobregiro = cupoSobregiro;
    }


    public String getTipo() {
        return super.getTipo()+ "Cuenta Corriente";
    }
    public int valorSobregirado(){
        return cupoSobregiro;
    }
    public String toString(){
        return super.toString()+ "Saldo: "+saldo+ "Cupo Sobregiro: "+cupoSobregiro;
    }
}
