package mercado;

public class Producto {
	private String nombre;
	private String codigo;
	private float  precio;
	private int cantidad;
	public  int limite;
	
	public Producto(String n,String c,float p,int ca,int li) {
		nombre=n;
		codigo=c;
		precio=p;
		cantidad=ca;
		limite=li;
	}
	
	public String datos() {
		return "Nombre: "+nombre+'\n'+
			   "Codigo: "+codigo+'\n'+
			   "Precio: "+precio+'\n'+
			   "Cantidad: "+cantidad+'\n';
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public float precioVenta() {
		return getPrecio()+((getPrecio()*5)/100);
	}

	public boolean necesita() {
		return cantidad<limite;
	}

	public String toString() {
		return nombre+" "+codigo;
	}
	
}
