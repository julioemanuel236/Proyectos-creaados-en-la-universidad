package entidades;
import java.util.Date;
import control.Datos;

public class Factura {
    private String idFactura;    
    private String codigoTransporte;
    private int    distancia;
    private float monto;
    private Date fecha;
    private Cliente cliente;
    private String categoria;
    
    public Factura(String idFactura,Transporte transporte,Cliente cliente,int distancia,float monto,long time){      
        this.idFactura = idFactura;        
        this.categoria = transporte.getClass().getSimpleName();
        this.codigoTransporte = transporte.getCodigo();
        this.cliente = cliente;        
        this.distancia = distancia;
        this.monto = monto;
        this.fecha = new Date(time);
        
    }
    
    public Factura(String idFactura,String codigoTransporte,String categoria,Cliente cliente,int distancia,float monto,long time){      
        this.idFactura = idFactura;        
        this.codigoTransporte = codigoTransporte;
        this.categoria = categoria;
        this.cliente = cliente;        
        this.distancia = distancia;
        this.monto = monto;
        this.fecha = new Date(time);
        
    }
    
    public String getIdFactura() {
        return idFactura;
    }

    public String getIdCliente() {
        return cliente.getId();
    }

    public String getNombreCliente() {
        return cliente.getNombre();
    }
    
    public int getDistancia() {
        return distancia;
    }

    
    public String getInfo(){
        //informacion en formato para guardar
        String separador = Datos.SEPARADOR;
        return idFactura+separador+
               codigoTransporte+separador+               
               categoria+separador+
               cliente.getInfo()+separador+
               String.valueOf(distancia)+separador+
               monto+separador+
               String.valueOf(fecha.getTime());
        
    }
    
    public String getTableInfo(){
        //informacion en formato para
        //mostrar en la tabla de alquiler
        String separador = Datos.SEPARADOR;
        return idFactura+separador+
               cliente.getNombre()+separador+
               cliente.getId()+separador+
               codigoTransporte+separador+ 
               categoria+separador+                                            
               String.valueOf(monto);
               
        
    }
    
    public String toString(){
        String s = "";
        s = "FACTURA: " + idFactura + "\n" +
            "CODIGO: "+ codigoTransporte + "\n" + 
            "CLIENTE:\n"+
            "   NOMBRE: " + cliente.getNombre() + "\n" +
            "   tID: "+ cliente.getId() + "\n"+
            "\tMONTO $" +  monto + "\n";
        return s;
    }

    public String getCodigoTransporte() {
        return codigoTransporte;
    }

    public float getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public void setCodigoTransporte(String codigoTransporte) {
        this.codigoTransporte = codigoTransporte;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
 
    
    
}
