import java.util.ArrayList;

public class ClienteEmpresarial extends Cliente {
    
    private String nit;
    private String representanteLegal;

    public ClienteEmpresarial(String nombre, String cedula,String nit, String representanteLegal ){
        super(nombre,cedula);
        productos = new ArrayList<Producto>();
        this.nit = nit;
        this.representanteLegal = representanteLegal;
    }

    public String getNit() {
        return nit;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
    public String toString(){
        return super.toString()+ " Nit: "+nit+ "Representantante legal: "+representanteLegal;
    }
}