import java.util.Random;
public class CuentaAhorros {
    private int numeroCuenta;
    private int saldo;

    public CuentaAhorros(){
        Random rand = new Random();
        numeroCuenta = rand.nextInt(99)+1;
        saldo = 50;
    }

    public int consultarSaldo() {
        return saldo;
    }

    public boolean retirar(int saldo){
        if(saldo>this.saldo)return false;
        this.saldo-=saldo;
        return true;
    }

    public void consignar(int saldo){
        this.saldo += saldo;
    }
}
