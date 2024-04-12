package negocio;

public class clientes {
	private String name;
	private String producto;
	private int consumo;
	
	public clientes (String name,String producto, int consumo ) {
		this.name = name;
		this.producto = producto;
		this.consumo = consumo;
	}
     public String Name() {
    	 return name;
     }
     public String Producto() {
    	 return producto;
     }
     public int Consumo() {
    	 return consumo;
     }
}
