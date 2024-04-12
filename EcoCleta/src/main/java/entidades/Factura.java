package entidades;
import control.Cliente;
import java.util.Date;

public class Factura {
    private String idFactura;
    private String idCliente;
    private String nombreCliente;
    private String codigoTransporte;
    private int    distancia;
    private float monto;
    private Date fecha;
    
    public Factura(Cliente cliente,String codigoBicicleta,int distancia,String id,float monto){      
        this.idFactura = id;
        this.idCliente = cliente.getId();
        this.nombreCliente = cliente.getNombre();
        this.codigoTransporte = codigoTransporte;
        this.distancia = distancia;
        this.fecha = new Date();
        this.monto = monto;
    }
    
    public String getIdFactura() {
        return idFactura;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public int getDistancia() {
        return distancia;
    }

    
    public String toString(){
        String s = "";
        s = "FACTURA: " + idFactura + "\n" +
            "CODIGO: "+ codigoTransporte + "\n" + 
            "CLIENTE:\n"+
            "   NOMBRE: " + nombreCliente + "\n" +
            "   tID: "+ idCliente + "\n"+
            "\tMONTO $" +  monto + "\n";
        return s;
    }
    
    
}
