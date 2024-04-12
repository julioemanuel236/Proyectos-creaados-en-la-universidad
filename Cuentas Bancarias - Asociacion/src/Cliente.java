public class Cliente {
    private String nombre;
    private String documento;

    private CuentaAhorros cuenta1;
    private CuentaAhorros cuenta2;

    public Cliente(String nombre,String documento){
        this.nombre = nombre;
        this.documento = documento;

        cuenta1 = new CuentaAhorros();
        cuenta2 = new CuentaAhorros();
    }

    public void consignarCuenta1(int saldo){
        cuenta1.consignar(saldo);
    }

    public void consignarCuenta2(int saldo){
        cuenta2.consignar(saldo);
    }

    public boolean retirarCuenta1(int saldo){
        return cuenta1.retirar(saldo);
    }

    public boolean retirarCuenta2(int saldo){
        return cuenta2.retirar(saldo);
    }

    public int consultarCuenta1(){
        return cuenta1.consultarSaldo();
    }

    public int consultarCuenta2(){
        return cuenta2.consultarSaldo();
    }

    public int saldoTotal(){
        return consultarCuenta1()+consultarCuenta2();
    }
}
