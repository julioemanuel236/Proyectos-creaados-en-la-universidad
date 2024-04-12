public interface Cuenta {
    
    void consignar(int monto);
    void retirar(int monto);
    int consultarSaldo();
    
}